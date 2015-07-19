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
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.preference.PreferenceManager;

import com.althink.android.ossw.NotificationType;
import com.althink.android.ossw.UploadDataType;
import com.althink.android.ossw.db.OsswDB;
import com.althink.android.ossw.notifications.IncomingCallNotificationHandler;
import com.althink.android.ossw.notifications.NotificationHandler;
import com.althink.android.ossw.plugins.PluginDefinition;
import com.althink.android.ossw.plugins.PluginFunctionDefinition;
import com.althink.android.ossw.plugins.PluginManager;
import com.althink.android.ossw.plugins.PluginPropertyDefinition;
import com.althink.android.ossw.utils.StringNormalizer;
import com.althink.android.ossw.watch.WatchConstants;
import com.althink.android.ossw.watchsets.DataSourceType;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
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
    private boolean started = false;

    private NotificationHandler lastNotificationHandler = null;

    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_SERVICE_DISCOVERING = 2;
    public static final int STATE_CONNECTED = 3;
    public static final int STATE_RECONNECT = 4;

    private boolean autoreconnect = true;

    private WatchOperationContext watchContext;

    private Handler handler = new Handler();

    private List<PluginDefinition> plugins;

    private Map<String, ContentObserver> contentObservers = new HashMap<>();

    private Map<String, Object> sentValuesCache = new HashMap<>();

    private final HashMap<String, ExternalServiceConnection> externalServiceConnections = new HashMap<>();

    private OsswDB db;

    private int nextNotificationId = 1;

    public final static String ACTION_WATCH_CONNECTING =
            "com.althink.android.ossw.ACTION_WATCH_CONNECTING";
    public final static String ACTION_WATCH_CONNECTED =
            "com.althink.android.ossw.ACTION_WATCH_CONNECTED";
    public final static String ACTION_WATCH_DISCONNECTED =
            "com.althink.android.ossw.ACTION_WATCH_DISCONNECTED";

    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            //Log.i(TAG, "onConnection: " + status + ", " + newState);
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                //intentAction = ACTION_WATCH_CONNECTED;
                mConnectionState = STATE_SERVICE_DISCOVERING;
                //broadcastUpdate(intentAction);
                //Log.i(TAG, "Connected to GATT server.");
                // Attempts to discover services after successful connection.
                //Log.i(TAG, "Attempting to start service discovery:" +
                //        mBluetoothGatt.discoverServices());
                mBluetoothGatt.discoverServices();

            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                mConnectionState = STATE_DISCONNECTED;
                //Log.i(TAG, "Disconnected from GATT server.");
                broadcastUpdate(ACTION_WATCH_DISCONNECTED);

                if (autoreconnect) {
                    //Log.i(TAG, "Reconnect");
                    connect(mBluetoothDeviceAddress);
                }
            }
        }

        @Override
        public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            super.onCharacteristicWrite(gatt, characteristic, status);

            // Log.i(TAG, "onCharacteristicWrite: " + characteristic.getUuid());
        }

        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            super.onCharacteristicChanged(gatt, characteristic);

            byte[] value = characteristic.getValue();
            //Log.i(TAG, "onCharacteristicChanged: " + characteristic.getUuid() + ", " + Arrays.toString(value));
            if (value.length > 0) {
                switch (value[0]) {
                    case WatchConstants.OSSW_RX_COMMAND_SET_WATCH_SET_ID:
                        int watchSetId = value[1] << 24 | value[2] << 16 | value[3] << 8 | value[4] & 0xFF;
                        WatchOperationContext ctx = db.getWatchContextByExtWatchSetId(watchSetId);
                        setWatchOperationContext(ctx);
                        if (ctx != null) {
                            sendAllExternalParamsValues();
                        }
                        break;
                    case WatchConstants.OSSW_RX_COMMAND_INVOKE_EXTERNAL_FUNCTION:
                        invokeExtensionFunction(value[1]);
                        break;
                    case WatchConstants.OSSW_RX_COMMAND_INVOKE_NOTIFICATION_FUNCTION:
                        invokeNotificationFunction(value[1]);
                        break;
                }
            }
        }

        private void sendAllExternalParamsValues() {
            byte paramId = 0;
            for (WatchExtensionProperty property : watchContext.getExternalParameters()) {
                Object value = getPropertyFromExtension(property.getPluginId(), property.getPropertyId());
                sendExternalParamToWatchAsync(paramId, property, value);
                paramId++;
            }
        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status == BluetoothGatt.GATT_SUCCESS) {
                //Log.w(TAG, "onServicesDiscovered received: " + status);

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        setCharacteristicNotification(getOsswRxCharacteristic(), true);

                        resetSentValuesCache();
                        mConnectionState = STATE_CONNECTED;
                        broadcastUpdate(ACTION_WATCH_CONNECTED);

                        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(OsswService.this);
                        boolean syncTime = sharedPref.getBoolean("synchronize_time", true);

                        if (syncTime) {
                            new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    sendCurrentTime();
                                }
                            }, 3000);
                        }
                    }
                }, 1000);
            }
        }
    };

    private int getNextNotificationId() {
        int notificationId = nextNotificationId;

        nextNotificationId++;
        if (nextNotificationId > 65535) {
            nextNotificationId = 1;
        }

        return notificationId;
    }

    private void resetSentValuesCache() {
        sentValuesCache.clear();
    }

    private void broadcastUpdate(final String action) {
        final Intent intent = new Intent(action);
        //Log.i(TAG, "Send Intent: " + intent);
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

    public void setWatchOperationContext(WatchOperationContext watchContext) {
        this.watchContext = watchContext;
        resetSentValuesCache();
    }

    public void createOrUpdateWatchSet(String name, String source, WatchOperationContext watchContext, int id) {
        db.addWatchSet(name, source, watchContext, id);
    }

    public void extendNotification(int notificationId, int timeout) {

        if (mBluetoothGatt == null || !(mConnectionState == STATE_CONNECTED)) {

            return;
        }

        BluetoothGattCharacteristic txCharact = getOsswTxCharacteristic();
        if (txCharact == null) {
            return;
        }

        txCharact.setValue(new byte[]{0x26, (byte) (notificationId >> 8), (byte) (notificationId & 0xFF), (byte) (timeout >> 8), (byte) (timeout & 0xFF)});

        boolean status = mBluetoothGatt.writeCharacteristic(txCharact);
        //Log.i(TAG, "Upload init: " + type + ", " + size + ", " + status);
    }

    public void closeNotification(int notificationId) {

        if (mBluetoothGatt == null || !(mConnectionState == STATE_CONNECTED)) {

            return;
        }

        BluetoothGattCharacteristic txCharact = getOsswTxCharacteristic();
        if (txCharact == null) {
            return;
        }

        txCharact.setValue(new byte[]{0x27, (byte) (notificationId >> 8), (byte) (notificationId & 0xFF)});

        boolean status = mBluetoothGatt.writeCharacteristic(txCharact);
        //Log.i(TAG, "Upload init: " + type + ", " + size + ", " + status);
    }

    private class UploadNotificationToWatch extends AsyncTask<Object, Void, Void> {

        @Override
        protected Void doInBackground(Object... params) {
            internalUploadNotification((int) params[0], (NotificationType) params[1], (byte[]) params[2], (int) params[3], (int) params[4]);
            return null;
        }
    }

    public int uploadNotification(NotificationType type, byte[] data, int vibrationPattern, int timeout) {
        int notificationId = getNextNotificationId();
        new UploadNotificationToWatch().execute(notificationId, type, data, vibrationPattern, timeout);
        return notificationId;
    }

    private void internalUploadNotification(int notificationId, NotificationType type, byte[] data, int vibrationPattern, int timeout) {

        if (mBluetoothGatt == null || !(mConnectionState == STATE_CONNECTED)) {

            return;
        }

        BluetoothGattCharacteristic txCharact = getOsswTxCharacteristic();
        if (txCharact == null) {
            return;
        }

        int size = data.length;

        txCharact.setValue(new byte[]{0x23, (byte) type.ordinal(), (byte) ((size >> 8) & 0xFF), (byte) (size & 0xFF)});

        boolean status = mBluetoothGatt.writeCharacteristic(txCharact);
        //Log.i(TAG, "Upload init: " + type + ", " + size + ", " + status);

        int sizeLeft = data.length;

        int dataPtr = 0;
        byte[] dataCommand = new byte[17];
        dataCommand[0] = 0x24;
        while (sizeLeft > 0) {
            int dataInPacket = sizeLeft > 16 ? 16 : sizeLeft;

            for (int i = 0; i < dataInPacket; i++) {
                dataCommand[i + 1] = data[dataPtr++];
            }


            txCharact.setValue(dataCommand);
            status = mBluetoothGatt.writeCharacteristic(txCharact);

            //Log.i(TAG, "Upload data pack: " + dataInPacket + ", " + status);

            sizeLeft -= 16;
        }
        txCharact.setValue(new byte[]{0x25, (byte) (notificationId >> 8), (byte) (notificationId & 0xFF), (byte) ((vibrationPattern >> 24) & 0xFF), (byte) ((vibrationPattern >> 16) & 0xFF), (byte) ((vibrationPattern >> 8) & 0xFF), (byte) (vibrationPattern & 0xFF), (byte) (timeout >> 8), (byte) (timeout & 0xFF)});
        status = mBluetoothGatt.writeCharacteristic(txCharact);

        switch (data[0]) {
            case 1:
                lastNotificationHandler = new IncomingCallNotificationHandler(notificationId, this);
                break;
        }

        //Log.i(TAG, "Upload data done: " + status);
    }

    public class LocalBinder extends Binder {
        public OsswService getService() {
            return OsswService.this;
        }
    }

    public Object getPropertyFromExtension(String pluginId, String property) {
        PluginPropertyDefinition propertyDefinition = getPropertyDefinition(pluginId, property);
        if (propertyDefinition == null) {
            return null;
        }

        Cursor query = getContentResolver().query(Uri.parse("content://" + pluginId + "/properties"), new String[]{property}, null, null, null);
        if (query == null) {
            return null;
        }
        Object value = null;
        try {
            query.moveToNext();
            switch (propertyDefinition.getType()) {
                case ENUM:
                case INTEGER:
                    value = query.getInt(query.getColumnIndex(property));
                    break;
                case FLOAT:
                    value = query.getFloat(query.getColumnIndex(property));
                    break;
                case STRING:
                    value = query.getString(query.getColumnIndex(property));
                    break;
            }
        } finally {
            query.close();
        }
        return value;
    }

    private class PluginPropertyObserver extends ContentObserver {
        private final String TAG = "PluginPropertyObserver";
        private Handler mHandler;
        private String pluginId;

        public PluginPropertyObserver(Handler handler, String pluginId) {
            super(handler);
            mHandler = handler;
            this.pluginId = pluginId;
        }

        @Override
        public void onChange(boolean selfChange) {
            // Log.d(TAG, "onChange: " + selfChange + ", plugin: " + pluginId);

            if (watchContext == null || watchContext.getExternalParameters() == null) {
                return;
            }

            int propertyId = 0;
            for (WatchExtensionProperty property : watchContext.getExternalParameters()) {
                if (property.getPluginId().equals(pluginId)) {
                    handleExternalPropertyChange((byte) propertyId, property);
                }
                propertyId++;
            }
        }

        private void handleExternalPropertyChange(byte propertyId, WatchExtensionProperty property) {
            Object value = getPropertyFromExtension(property.getPluginId(), property.getPropertyId());
            sendExternalParamToWatchAsync((byte) propertyId, property, value);
        }
    }

    private PluginPropertyDefinition getPropertyDefinition(String pluginId, String propertyId) {
        for (PluginDefinition plugin : plugins) {
            if (plugin.getPluginId().equals(pluginId)) {
                for (PluginPropertyDefinition propertyDef : plugin.getProperties()) {
                    if (propertyDef.getName().equals(propertyId)) {
                        return propertyDef;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Log.i(TAG, "Start service");

        if (!started) {
            //Log.i(TAG, "Initialize service");
            db = new OsswDB(this);

            plugins = new PluginManager(getApplicationContext()).findPlugins();
            for (PluginDefinition plugin : plugins) {
                ExternalServiceConnection connection = new ExternalServiceConnection();

                // bind plugin service
                Intent serviceIntent = new Intent();
                serviceIntent.setAction(plugin.getPluginId());
                serviceIntent.setPackage(plugin.getPluginId());
                bindService(serviceIntent, connection.getConnection(), BIND_AUTO_CREATE);
                externalServiceConnections.put(plugin.getPluginId(), connection);

                // listen on plugin property change
                PluginPropertyObserver observer = new PluginPropertyObserver(handler, plugin.getPluginId());
                Uri contentUri = Uri.parse("content://" + plugin.getPluginId() + "/properties");
                //Log.i(TAG, "Register handler for uri: " + contentUri);
                getApplicationContext().getContentResolver().registerContentObserver(contentUri, false, observer);
                contentObservers.put(plugin.getPluginId(), observer);
            }
            started = true;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void invokeNotificationFunction(int functionId) {
        if (lastNotificationHandler != null) {
            lastNotificationHandler.handleFunction(functionId);
        }
    }

    private void invokeExtensionFunction(int extFunctionId) {
        if (watchContext == null || extFunctionId < 0 || watchContext.getExternalFunctions() == null || watchContext.getExternalFunctions().size() <= extFunctionId) {
            return;
        }
        WatchExtensionFunction function = watchContext.getExternalFunctions().get(extFunctionId);
        invokeExtensionFunction(function.getPluginId(), function.getFunctionId(), function.getParameter());
    }

    public void invokeExtensionFunction(String extensionId, String functionName, String parameter) {
        ExternalServiceConnection connection = externalServiceConnections.get(extensionId);
        if (connection == null) {
            //Log.e(TAG, "Service " + extensionId + " is not connected");
            return;
        }
        try {
            Integer functionId = findFunctionId(extensionId, functionName);
            if (functionId != null) {
                Message message = Message.obtain(null, functionId, 0, 0);
                Bundle b = new Bundle();
                b.putString("parameter", parameter);
                message.setData(b);
                connection.getMessanger().send(message);
            }
        } catch (Exception e) {
            //Log.e(TAG, e.getMessage(), e);
        }
    }

    private Integer findFunctionId(String extensionId, String functionName) {
        for (PluginDefinition def : plugins) {
            if (def.getPluginId().equals(extensionId)) {
                for (PluginFunctionDefinition func : def.getFunctions()) {
                    if (func.getName().equals(functionName)) {
                        return func.getId();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public IBinder onBind(Intent intent) {
        //Log.i(TAG, "Service bind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        //Log.i(TAG, "Service unbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //Log.i(TAG, "Service destroyed");
        // After using a given device, you should make sure that BluetoothGatt.close() is called
        // such that resources are cleaned up properly.  In this particular example, close() is
        // invoked when the UI is disconnected from the Service.
        for (ExternalServiceConnection connection : externalServiceConnections.values()) {
            unbindService(connection.getConnection());
        }
        externalServiceConnections.clear();
        for (ContentObserver observer : contentObservers.values()) {
            getContentResolver().unregisterContentObserver(observer);
        }
        contentObservers.clear();
        close();
        started = false;
    }

    private final IBinder mBinder = new LocalBinder();

    /**
     * Initializes a reference to the local Bluetooth adapter.
     *
     * @return Return true if the initialization is successful.
     */
    public boolean initialize() {
        //Log.i(TAG, "Initialize");
        // For API level 18 and above, get a reference to BluetoothAdapter through
        // BluetoothManager.
        if (mBluetoothManager == null) {
            mBluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
            if (mBluetoothManager == null) {
                //Log.e(TAG, "Unable to initialize BluetoothManager.");
                return false;
            }
        }

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
                //Log.e(TAG, "Unable to obtain a BluetoothAdapter.");
                return false;
            }
            characteristic.addDescriptor(descriptor);

            BluetoothGattService service = new BluetoothGattService(serviceUUID, BluetoothGattService.SERVICE_TYPE_PRIMARY);
            service.addCharacteristic(characteristic);

            if (mGattServer != null) {
                mGattServer.addService(service);
            }

        } catch (Exception e) {
            //Log.e(TAG, e.getMessage(), e);
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
        //Log.i(TAG, "Connect");

        if (mBluetoothManager == null) {
            initialize();
        }

        if (mBluetoothAdapter == null || address == null) {
            //Log.w(TAG, "BluetoothAdapter not initialized or unspecified address.");
            return false;
        }

        // Previously connected device.  Try to reconnect.
        if (mBluetoothDeviceAddress != null && address.equals(mBluetoothDeviceAddress)
                && mBluetoothGatt != null) {
            //Log.d(TAG, "Trying to use an existing mBluetoothGatt for connection.");
            if (mBluetoothGatt.connect()) {
                mConnectionState = STATE_CONNECTING;
                return true;
            } else {
                return false;
            }
        }

        final BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
        if (device == null) {
            //Log.w(TAG, "Device not found. Unable to connect.");
            return false;
        }

        broadcastUpdate(ACTION_WATCH_CONNECTING);
        // We want to directly connect to the device, so we are setting the autoConnect
        // parameter to false.
        mBluetoothGatt = device.connectGatt(this, false, mGattCallback);
        //Log.d(TAG, "Trying to create a new connection.");
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
            //Log.w(TAG, "BluetoothAdapter not initialized");
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
            //Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }
        mBluetoothGatt.readCharacteristic(characteristic);
    }

    protected static final UUID CHARACTERISTIC_UPDATE_NOTIFICATION_DESCRIPTOR_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");

    /**
     * Enables or disables notification on a give characteristic.
     *
     * @param characteristic Characteristic to act on.
     * @param enabled        If true, enable notification.  False otherwise.
     */
    public void setCharacteristicNotification(BluetoothGattCharacteristic characteristic,
                                              boolean enabled) {
        if (mBluetoothAdapter == null || mBluetoothGatt == null) {
            //Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }
        mBluetoothGatt.setCharacteristicNotification(characteristic, enabled);
        BluetoothGattDescriptor descriptor = characteristic.getDescriptor(CHARACTERISTIC_UPDATE_NOTIFICATION_DESCRIPTOR_UUID);
        descriptor.setValue(enabled ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : new byte[]{0x00, 0x00});
        mBluetoothGatt.writeDescriptor(descriptor); //descriptor write operation successfully started?

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

    public void sendExternalParamToWatchAsync(byte paramId, WatchExtensionProperty property, Object value) {
        Object cachedValue = sentValuesCache.get(buildCachePropertyKey(property.getPluginId(), property.getPropertyId()));
        if ((cachedValue != null && cachedValue.equals(value)) || (value == null && cachedValue == null)) {
            return;
        }
        new UpdatePropertyInWatchTask().execute(paramId, property, value);
    }

    private int calcExternalPropertySize(DataSourceType type, int range) {
        switch (type) {
            case NUMBER:
                if (range == WatchConstants.NUMBER_RANGE_0__9 ||
                        range == WatchConstants.NUMBER_RANGE_0__19 ||
                        range == WatchConstants.NUMBER_RANGE_0__99 ||
                        range == WatchConstants.NUMBER_RANGE_0__199 ||
                        range == WatchConstants.NUMBER_RANGE_0__9_9 ||
                        range == WatchConstants.NUMBER_RANGE_0__19_9) {
                    return 1;
                } else if (range == WatchConstants.NUMBER_RANGE_0__999 ||
                        range == WatchConstants.NUMBER_RANGE_0__1999 ||
                        range == WatchConstants.NUMBER_RANGE_0__9999 ||
                        range == WatchConstants.NUMBER_RANGE_0__19999 ||
                        range == WatchConstants.NUMBER_RANGE_0__99_9 ||
                        range == WatchConstants.NUMBER_RANGE_0__199_9 ||
                        range == WatchConstants.NUMBER_RANGE_0__999_9 ||
                        range == WatchConstants.NUMBER_RANGE_0__1999_9 ||
                        range == WatchConstants.NUMBER_RANGE_0__9_99 ||
                        range == WatchConstants.NUMBER_RANGE_0__19_99 ||
                        range == WatchConstants.NUMBER_RANGE_0__99_99 ||
                        range == WatchConstants.NUMBER_RANGE_0__199_99) {
                    return 2;
                } else if (range == WatchConstants.NUMBER_RANGE_0__99999 ||
                        range == WatchConstants.NUMBER_RANGE_0__9999_9 ||
                        range == WatchConstants.NUMBER_RANGE_0__19999_9 ||
                        range == WatchConstants.NUMBER_RANGE_0__99999_9 ||
                        range == WatchConstants.NUMBER_RANGE_0__999_99 ||
                        range == WatchConstants.NUMBER_RANGE_0__1999_99 ||
                        range == WatchConstants.NUMBER_RANGE_0__9999_99 ||
                        range == WatchConstants.NUMBER_RANGE_0__19999_99 ||
                        range == WatchConstants.NUMBER_RANGE_0__99999_99) {
                    return 3;
                }
                return 0;
            case ENUM:
                return 1;
            case STRING:
                return range + 1;
        }
        return 0;
    }

    private void sendExternalParamToWatchInternal(byte paramId, WatchExtensionProperty property, Object value) {

        if (watchContext == null || watchContext.getExternalParameters() == null || watchContext.getExternalParameters().size() <= paramId) {
            //       return;
        }

        if (mBluetoothGatt == null || !(mConnectionState == STATE_CONNECTED)) {
            return;
        }

        BluetoothGattCharacteristic txCharact = getOsswTxCharacteristic();
        if (txCharact == null) {
            return;
        }

        //Log.i(TAG, "Update property: " + property.getPropertyId() + " with value " + value);

        byte commandId = 0x30;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        os.write(commandId);
        os.write(paramId);
        switch (property.getType()) {
            case NUMBER:
                Integer intValue = buildIntValue(value, property.getRange());
                switch (calcExternalPropertySize(property.getType(), property.getRange())) {
                    case 3:
                        os.write((intValue) >> 16 & 0xFF);
                    case 2:
                        os.write((intValue) >> 8 & 0xFF);
                    case 1:
                        os.write((intValue) & 0xFF);
                }
                break;
            case STRING:
                String v = (String) value;
                v = StringNormalizer.removeAccents(v);
                if (v.length() > property.getRange()) {
                    v = v.substring(0, property.getRange());
                }
                try {
                    os.write(((String) value).getBytes());
                } catch (IOException e) {
                }
                break;
        }
        txCharact.setValue(os.toByteArray());

        boolean status = mBluetoothGatt.writeCharacteristic(txCharact);
        if (status) {
            sentValuesCache.put(buildCachePropertyKey(property.getPluginId(), property.getPropertyId()), value);
        }
        //  Log.i(TAG, "Write: " + value + ", result: " + status);
    }

    private Integer buildIntValue(Object value, int range) {
        if (value instanceof Integer) {
            return ((Integer) value) * pow(10, range & 0xF);
        } else if (value instanceof Float) {
            BigDecimal decimal = new BigDecimal(((float) value) * pow(10, range & 0xF));
            return decimal.setScale(0, RoundingMode.HALF_UP).intValue();
        }
        return 0;
    }

    private Integer pow(int x, int n) {
        int val = 1;
        for (int i = 0; i < n; i++) {
            val *= x;
        }
        return val;
    }

    private String buildCachePropertyKey(String pluginId, String propertyId) {
        return pluginId + ":" + propertyId;
    }

    private class UpdatePropertyInWatchTask extends AsyncTask<Object, Void, Void> {

        @Override
        protected Void doInBackground(Object... params) {

            sendExternalParamToWatchInternal((byte) params[0], (WatchExtensionProperty) params[1], params[2]);
            return null;
        }
    }

    private class UploadDataToWatch extends AsyncTask<Object, Void, Void> {

        @Override
        protected Void doInBackground(Object... params) {
            internalUploadData((UploadDataType) params[0], (byte[]) params[1]);
            return null;
        }
    }

    public void uploadData(UploadDataType type, byte[] data) {
        new UploadDataToWatch().execute(type, data);
    }

    private void internalUploadData(UploadDataType type, byte[] data) {

        if (mBluetoothGatt == null || !(mConnectionState == STATE_CONNECTED)) {

            return;
        }

        BluetoothGattCharacteristic txCharact = getOsswTxCharacteristic();
        if (txCharact == null) {
            return;
        }

        int size = data.length;

        txCharact.setValue(new byte[]{0x20, (byte) type.ordinal(), (byte) (size >> 24), (byte) ((size >> 16) & 0xFF), (byte) ((size >> 8) & 0xFF), (byte) (size & 0xFF)});

        boolean status = mBluetoothGatt.writeCharacteristic(txCharact);
        //Log.i(TAG, "Upload init: " + type + ", " + size + ", " + status);

        int sizeLeft = data.length;

        int dataPtr = 0;
        byte[] dataCommand = new byte[17];
        dataCommand[0] = 0x21;
        while (sizeLeft > 0) {
            int dataInPacket = sizeLeft > 16 ? 16 : sizeLeft;

            for (int i = 0; i < dataInPacket; i++) {
                dataCommand[i + 1] = data[dataPtr++];
            }


            txCharact.setValue(dataCommand);
            status = mBluetoothGatt.writeCharacteristic(txCharact);

            //Log.i(TAG, "Upload data pack: " + dataInPacket + ", " + status);

            sizeLeft -= 16;
        }
        txCharact.setValue(new byte[]{0x22});
        status = mBluetoothGatt.writeCharacteristic(txCharact);
        //Log.i(TAG, "Upload data done: " + status);
    }

    private void sendCurrentTime() {

        if (mBluetoothGatt == null || !(mConnectionState == STATE_CONNECTED)) {
            return;
        }

        BluetoothGattCharacteristic txCharact = getOsswTxCharacteristic();
        if (txCharact == null) {
            return;
        }

        SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));
        SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

        try {
            Date date = dateFormatGmt.parse(dateFormatLocal.format(new Date()));
            int currentTime = (int) (date.getTime() / 1000);
            txCharact.setValue(new byte[]{0x10, (byte) (currentTime >> 24), (byte) ((currentTime >> 16) & 0xFF), (byte) ((currentTime >> 8) & 0xFF), (byte) (currentTime & 0xFF)});
            //Log.i(TAG, "Set current time");
            boolean status = mBluetoothGatt.writeCharacteristic(txCharact);
        } catch (Exception e) {
            // do nothing
        }

    }


    private BluetoothGattCharacteristic getOsswTxCharacteristic() {
        BluetoothGattService service = mBluetoothGatt.getService(OSSW_SERVICE_UUID);
        if (service == null) {
            return null;
        }
        return service
                .getCharacteristic(UUID.fromString("58C60002-20B7-4904-96FA-CBA8E1B95702"));
    }

    private BluetoothGattCharacteristic getOsswRxCharacteristic() {
        BluetoothGattService service = mBluetoothGatt.getService(OSSW_SERVICE_UUID);
        if (service == null) {
            return null;
        }
        return service
                .getCharacteristic(UUID.fromString("58C60003-20B7-4904-96FA-CBA8E1B95702"));
    }
}
