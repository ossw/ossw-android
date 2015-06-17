package com.althink.android.ossw.service;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.althink.android.ossw.gmail.GmailProvider;
import com.althink.android.ossw.plugins.PluginDefinition;
import com.althink.android.ossw.plugins.PluginFunctionDefinition;
import com.althink.android.ossw.plugins.PluginManager;
import com.althink.android.ossw.plugins.PluginPropertyDefinition;
import com.althink.android.ossw.watchsets.CompiledWatchSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class OsswService extends Service {
    private final static String TAG = OsswService.class.getSimpleName();

    public final static UUID OSSW_SERVICE_UUID = UUID.fromString("58C60001-20B7-4904-96FA-CBA8E1B95702");

    private BluetoothManager mBluetoothManager;
    private BluetoothAdapter mBluetoothAdapter;
    private String mBluetoothDeviceAddress;
    private BluetoothGatt mBluetoothGatt;
    private int mConnectionState = STATE_DISCONNECTED;
    private BluetoothGattServer mGattServer;

    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_SERVICE_DISCOVERING = 2;
    public static final int STATE_CONNECTED = 3;
    public static final int STATE_RECONNECT = 4;

    private GmailProvider gmailProvider;

    private boolean autoreconnect = true;

    private WatchOperationContext watchContext;

    private Handler handler = new Handler();

    private List<PluginDefinition> plugins;

    private Map<String, ContentObserver> contentObservers = new HashMap<>();

    private final HashMap<String, ExternalServiceConnection> externalServiceConnections = new HashMap<>();

    public final static String ACTION_WATCH_CONNECTING =
            "com.althink.android.ossw.ACTION_WATCH_CONNECTING";
    public final static String ACTION_WATCH_CONNECTED =
            "com.althink.android.ossw.ACTION_WATCH_CONNECTED";
    public final static String ACTION_WATCH_DISCONNECTED =
            "com.althink.android.ossw.ACTION_WATCH_DISCONNECTED";

    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            Log.i(TAG, "onConnection: " + status + ", " + newState);
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                //intentAction = ACTION_WATCH_CONNECTED;
                mConnectionState = STATE_SERVICE_DISCOVERING;
                //broadcastUpdate(intentAction);
                Log.i(TAG, "Connected to GATT server.");
                // Attempts to discover services after successful connection.
                Log.i(TAG, "Attempting to start service discovery:" +
                        mBluetoothGatt.discoverServices());

            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                mConnectionState = STATE_DISCONNECTED;
                Log.i(TAG, "Disconnected from GATT server.");
                broadcastUpdate(ACTION_WATCH_DISCONNECTED);

                if (autoreconnect) {
                    Log.i(TAG, "Reconnect");
                    connect(mBluetoothDeviceAddress);
                }
            }
        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                Log.w(TAG, "onServicesDiscovered received: " + status);

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        broadcastUpdate(ACTION_WATCH_CONNECTED);
                        mConnectionState = STATE_CONNECTED;
                    }
                }, 1000);
            }
        }
    };

    private void broadcastUpdate(final String action) {
        final Intent intent = new Intent(action);
        Log.i(TAG, "Send Intent: " + intent);
        sendBroadcast(intent);
    }

    //  public int onStartCommand(Intent intent, int flags, int startId) {
    //      return START_STICKY;
    //  }

    private final BluetoothGattServerCallback mBluetoothGattServerCallback = new BluetoothGattServerCallback() {

        @Override
        public void onCharacteristicReadRequest(BluetoothDevice device, int requestId,
                                                int offset, BluetoothGattCharacteristic characteristic) {

            if (mGattServer != null) {
                mGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, new byte[]{33});
            }
        }
    };


    private void broadcastUpdate(final String action,
                                 final BluetoothGattCharacteristic characteristic) {
        final Intent intent = new Intent(action);
        sendBroadcast(intent);
    }

    public void setWatchOperationContext(WatchOperationContext watchContext) {
        this.watchContext = watchContext;
    }

    public class LocalBinder extends Binder {
        public OsswService getService() {
            return OsswService.this;
        }
    }

    private class PluginPropertyObserver extends ContentObserver {
        private final String TAG = "PluginPropertyObserver";
        private Handler mHandler;
        private String pluginId;

        int tmp = 0;

        public PluginPropertyObserver(Handler handler, String pluginId) {
            super(handler);
            mHandler = handler;
            this.pluginId = pluginId;
        }

        @Override
        public void onChange(boolean selfChange) {
            Log.d(TAG, "onChange: " + selfChange + ", plugin: " + pluginId);

            if(pluginId.equals("com.althink.android.ossw.plugins.ipsensorman")) {
                Cursor query = getContentResolver().query(Uri.parse("content://" + pluginId + "/properties"), new String[]{"heartRate"}, null, null, null);
                query.moveToNext();
                sendExternalParamToWatchAsync((byte) 1, (byte) query.getInt(query.getColumnIndex("heartRate")), ExternalParamType.BYTE);
            }

        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Start service");

        plugins = new PluginManager(getApplicationContext()).findPlugins();
        for (PluginDefinition plugin : plugins) {
            ExternalServiceConnection connection = new ExternalServiceConnection();

            // bind plugin service
            Intent serviceIntent = new Intent();
            serviceIntent.setAction(plugin.getPluginId());
            bindService(serviceIntent, connection.getConnection(), BIND_AUTO_CREATE);
            externalServiceConnections.put(plugin.getPluginId(), connection);

            // listen on plugin property change
            PluginPropertyObserver observer = new PluginPropertyObserver(handler, plugin.getPluginId());
            Uri contentUri = Uri.parse("content://" + plugin.getPluginId() + "/properties");
            Log.i(TAG, "Register handler for uri: " + contentUri);
            getApplicationContext().getContentResolver().registerContentObserver(contentUri, false, observer);
            contentObservers.put(plugin.getPluginId(), observer);
        }

        return super.onStartCommand(intent, flags, startId);
    }

    public void invokeExtensionFunction(String extensionId, String functionName) {
        ExternalServiceConnection connection = externalServiceConnections.get(extensionId);
        if (connection == null) {
            Log.e(TAG, "Service " + extensionId + " is not connected");
            return;
        }
        try {
            connection.getMessanger().send(Message.obtain(null, /*TODO*/5, 0, 0));
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "Service bind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "Service unbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service destroyed");
        // After using a given device, you should make sure that BluetoothGatt.close() is called
        // such that resources are cleaned up properly.  In this particular example, close() is
        // invoked when the UI is disconnected from the Service.
        for (ExternalServiceConnection connection : externalServiceConnections.values()) {
            unbindService(connection.getConnection());
        }
        externalServiceConnections.clear();
        for(ContentObserver observer : contentObservers.values()) {
            getContentResolver().unregisterContentObserver(observer);
        }
        contentObservers.clear();
        close();
    }

    private final IBinder mBinder = new LocalBinder();

    /**
     * Initializes a reference to the local Bluetooth adapter.
     *
     * @return Return true if the initialization is successful.
     */
    public boolean initialize() {
        Log.i(TAG, "Initialize");
        // For API level 18 and above, get a reference to BluetoothAdapter through
        // BluetoothManager.
        if (mBluetoothManager == null) {
            mBluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
            if (mBluetoothManager == null) {
                Log.e(TAG, "Unable to initialize BluetoothManager.");
                return false;
            }
        }

        gmailProvider = new GmailProvider(this);
        gmailProvider.onInitialize(false);

        try {
            BluetoothGattServer mGattServer = mBluetoothManager.openGattServer(getApplicationContext(), mBluetoothGattServerCallback);
            UUID serviceUUID = UUID.randomUUID();
            UUID characteristicUUID = UUID.randomUUID();
            UUID descriptorUUID = UUID.randomUUID();

            BluetoothGattCharacteristic characteristic = new BluetoothGattCharacteristic(characteristicUUID, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
            characteristic.setValue(77, BluetoothGattCharacteristic.FORMAT_UINT8, 0);

            BluetoothGattDescriptor descriptor = new BluetoothGattDescriptor(descriptorUUID, BluetoothGattDescriptor.PERMISSION_READ);

            mBluetoothAdapter = mBluetoothManager.getAdapter();
            if (mBluetoothAdapter == null) {
                Log.e(TAG, "Unable to obtain a BluetoothAdapter.");
                return false;
            }
            characteristic.addDescriptor(descriptor);

            BluetoothGattService service = new BluetoothGattService(serviceUUID, BluetoothGattService.SERVICE_TYPE_PRIMARY);
            service.addCharacteristic(characteristic);

            if (mGattServer != null) {
                mGattServer.addService(service);
            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return true;
        }
        return true;
    }

    /**
     * Connects to the GATT server hosted on the Bluetooth LE device.
     *
     * @param address The device address of the destination device.
     * @return Return true if the connection is initiated successfully. The connection result
     * is reported asynchronously through the
     * {@code BluetoothGattCallback#onConnectionStateChange(android.bluetooth.BluetoothGatt, int, int)}
     * callback.
     */
    public boolean connect(final String address) {
        Log.i(TAG, "Connect");

        if (mBluetoothManager == null) {
            initialize();
        }

        if (mBluetoothAdapter == null || address == null) {
            Log.w(TAG, "BluetoothAdapter not initialized or unspecified address.");
            return false;
        }

        // Previously connected device.  Try to reconnect.
        if (mBluetoothDeviceAddress != null && address.equals(mBluetoothDeviceAddress)
                && mBluetoothGatt != null) {
            Log.d(TAG, "Trying to use an existing mBluetoothGatt for connection.");
            if (mBluetoothGatt.connect()) {
                mConnectionState = STATE_CONNECTING;
                return true;
            } else {
                return false;
            }
        }

        final BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
        if (device == null) {
            Log.w(TAG, "Device not found. Unable to connect.");
            return false;
        }

        broadcastUpdate(ACTION_WATCH_CONNECTING);
        // We want to directly connect to the device, so we are setting the autoConnect
        // parameter to false.
        mBluetoothGatt = device.connectGatt(this, false, mGattCallback);
        Log.d(TAG, "Trying to create a new connection.");
        mBluetoothDeviceAddress = address;
        mConnectionState = STATE_CONNECTING;
        return true;
    }

    /**
     * Disconnects an existing connection or cancel a pending connection. The disconnection result
     * is reported asynchronously through the
     * {@code BluetoothGattCallback#onConnectionStateChange(android.bluetooth.BluetoothGatt, int, int)}
     * callback.
     */
    public void disconnect() {
        if (mBluetoothAdapter == null || mBluetoothGatt == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }
        mBluetoothGatt.disconnect();
    }

    /**
     * After using a given BLE device, the app must call this method to ensure resources are
     * released properly.
     */
    public void close() {
        if (mBluetoothGatt == null) {
            return;
        }
        mBluetoothGatt.close();
        mBluetoothGatt = null;
    }

    /**
     * Request a read on a given {@code BluetoothGattCharacteristic}. The read result is reported
     * asynchronously through the {@code BluetoothGattCallback#onCharacteristicRead(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic, int)}
     * callback.
     *
     * @param characteristic The characteristic to read from.
     */
    public void readCharacteristic(BluetoothGattCharacteristic characteristic) {
        if (mBluetoothAdapter == null || mBluetoothGatt == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }
        mBluetoothGatt.readCharacteristic(characteristic);
    }

    /**
     * Enables or disables notification on a give characteristic.
     *
     * @param characteristic Characteristic to act on.
     * @param enabled        If true, enable notification.  False otherwise.
     */
    public void setCharacteristicNotification(BluetoothGattCharacteristic characteristic,
                                              boolean enabled) {
        if (mBluetoothAdapter == null || mBluetoothGatt == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }
        mBluetoothGatt.setCharacteristicNotification(characteristic, enabled);
    }

    /**
     * Retrieves a list of supported GATT services on the connected device. This should be
     * invoked only after {@code BluetoothGatt#discoverServices()} completes successfully.
     *
     * @return A {@code List} of supported services.
     */
    public List<BluetoothGattService> getSupportedGattServices() {
        if (mBluetoothGatt == null) return null;

        return mBluetoothGatt.getServices();
    }

    public int getStatus() {
        return mConnectionState;
    }

    public void sendExternalParamToWatchAsync(byte paramId, Object value, ExternalParamType paramType) {
        Log.i(TAG, "sendExternalParamToWatch");
        new UpdatePropertyInWatchTask().execute(paramId, value, paramType);
    }

    private void sendExternalParamToWatchInternal(byte paramId, Object value, ExternalParamType paramType) {

        Log.i(TAG, "sendExternalParamToWatchInternal");

        if (watchContext == null || watchContext.getExternalParameters() == null || watchContext.getExternalParameters().size() <= paramId) {
     //       return;
        }

        if (mBluetoothGatt == null || !(mConnectionState == STATE_CONNECTED)) {
            return;
        }

        BluetoothGattService service = mBluetoothGatt.getService(OSSW_SERVICE_UUID);

        if (service == null) {
            return;
        }

        Log.i(TAG, "OK");


        BluetoothGattCharacteristic txCharact = service
                .getCharacteristic(UUID.fromString("58C60002-20B7-4904-96FA-CBA8E1B95702"));

        byte commandId = 0x11;
        if (txCharact != null) {
            switch (paramType) {
                case BYTE:
                    txCharact.setValue(new byte[]{commandId, (byte) paramId, (byte) value});
                    break;
                case SHORT:
                    txCharact.setValue(new byte[]{commandId, (byte) paramId, (byte)(((Short) value).shortValue() >> 8), (byte)(((Short) value).shortValue() & 0xFF)});
                    break;
            }

            boolean status = mBluetoothGatt.writeCharacteristic(txCharact);
            Log.i(TAG, "Write: " + value + ", result: " + status);
        }
    }

    private class UpdatePropertyInWatchTask extends AsyncTask<Object, Void, Void> {

        @Override
        protected Void doInBackground(Object... params) {

            sendExternalParamToWatchInternal((byte) params[0], params[1], (ExternalParamType) params[2]);
            return null;
        }
    }
}
