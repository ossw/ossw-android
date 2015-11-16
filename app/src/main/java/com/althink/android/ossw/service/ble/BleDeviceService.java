package com.althink.android.ossw.service.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by krzysiek on 10/10/15.
 */
public class BleDeviceService {

    private final static String TAG = BleDeviceService.class.getSimpleName();

    private static final UUID CHARACTERISTIC_UPDATE_NOTIFICATION_DESCRIPTOR_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");

    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_SERVICE_DISCOVERING = 2;
    public static final int STATE_CONNECTED = 3;
    public static final int STATE_AUTO_RECONNECT = 4;

    private ExecutorService bleOperationsService = Executors.newSingleThreadExecutor();

    private Context context;
    private BluetoothGatt bluetoothGatt;
    private Object bleOperationLock = new Object();
    private BluetoothManager bluetoothManager;
    private BluetoothAdapter bluetoothAdapter;

    private int connectionState = STATE_DISCONNECTED;

    private BleConnectionStatusHandler connStatusHandler;
    private CharacteristicChangeHandler characteristicChangeHandler;

//    private ExecutorService autoReconnectExecutor = new ThreadPoolExecutor(1, 1,
//            0L, TimeUnit.MILLISECONDS,
//            new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.DiscardPolicy());
//    private Handler handler = new Handler();
    private boolean autoReconnect = false;
    private Timer lastReconnectTimer;
    private String lastBleAddress;

    private final BroadcastReceiver bluetoothStateReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            try {
                String action = intent.getAction();

                // It means the user has changed his bluetooth state.
                if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {

                    if (bluetoothAdapter != null && bluetoothAdapter.getState() == BluetoothAdapter.STATE_ON) {
                        Log.i(TAG, "Bluetooth was enabled");
                        if (lastBleAddress != null) {
                            Log.i(TAG, "Restore last connection");
                            restoreConnection(lastBleAddress);
                        }
                    } else if (bluetoothAdapter != null && bluetoothAdapter.getState() == BluetoothAdapter.STATE_OFF) {
                        stopAutoReconnectAttempt();
                    }

                }
            } catch (Exception e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
    };

    public BleDeviceService(Context context, BleConnectionStatusHandler connStatusHandler, CharacteristicChangeHandler characteristicChangeHandler) {
        this.context = context;
        this.connStatusHandler = connStatusHandler;
        this.characteristicChangeHandler = characteristicChangeHandler;

        context.registerReceiver(bluetoothStateReceiver, new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED));
    }

    public boolean connect(String address, boolean autoReconnect) {
        this.autoReconnect = autoReconnect;
        this.lastBleAddress = address;

        if (address == null) {
            Log.w(TAG, "Unspecified address.");
            return false;
        }

        if (!makeSureBleEnabled()) {
            Log.i(TAG, "Bluetooth is disabled.");
            return false;
        }

        if (bluetoothGatt != null) {
            // close previous gatt
            bluetoothGatt.close();
            bluetoothGatt = null;
        }

        final BluetoothDevice device = bluetoothAdapter.getRemoteDevice(address);
        if (device == null) {
            //Log.w(TAG, "Device not found. Unable to connect.");
            invokeConnectionStatusHandler(BleConnectionStatus.DISCONNECTED);
            return false;
        }

        invokeConnectionStatusHandler(BleConnectionStatus.CONNECTING);
        // We want to directly connect to the device, so we are setting the autoConnect
        // parameter to false.
        bluetoothGatt = device.connectGatt(context, false, mGattCallback);
        //Log.d(TAG, "Trying to create a new connection.");
        connectionState = STATE_CONNECTING;

        return true;
    }

    public boolean isConnected() {
        return bluetoothGatt != null && connectionState == STATE_CONNECTED;
    }

    private void invokeConnectionStatusHandler(BleConnectionStatus status) {
        if (connStatusHandler != null) {
            connStatusHandler.handleConnectionStatusChange(status);
        }
    }

    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            Log.i(TAG, "onConnection: " + status + ", " + newState);
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                stopAutoReconnectAttempt();
                //intentAction = ACTION_WATCH_CONNECTED;
                connectionState = STATE_SERVICE_DISCOVERING;
                //broadcastUpdate(intentAction);
                //Log.i(TAG, "Connected to GATT server.");
                // Attempts to discover services after successful connection.
                bluetoothGatt.discoverServices();


            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                //Log.i(TAG, "Disconnected from GATT server.");
                cleanupBleCommands();

                if (autoReconnect) {
                    startAutoReconnectAttempt();
                } else {
                    connectionState = STATE_DISCONNECTED;
                    invokeConnectionStatusHandler(BleConnectionStatus.DISCONNECTED);
                }
            }
        }

        @Override
        public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
            super.onDescriptorWrite(gatt, descriptor, status);

            //Log.i(TAG, "OnDescriptorWrite: " + descriptor);
            synchronized (bleOperationLock) {
                bleOperationLock.notify();
            }
        }

        @Override
        public void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
            super.onDescriptorRead(gatt, descriptor, status);

            //Log.i(TAG, "onDescriptorRead: " + descriptor);
            synchronized (bleOperationLock) {
                bleOperationLock.notify();
            }
        }

        @Override
        public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            super.onCharacteristicWrite(gatt, characteristic, status);

            //Log.i(TAG, "onCharacteristicWrite: " + characteristic.getUuid() + ", " + Arrays.toString(characteristic.getValue()));
            synchronized (bleOperationLock) {
                bleOperationLock.notify();
            }
        }

        @Override
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            super.onCharacteristicRead(gatt, characteristic, status);

            //Log.i(TAG, "onCharacteristicRead: " + characteristic.getUuid() + ", " + characteristic.getStringValue(0));
            synchronized (bleOperationLock) {
                bleOperationLock.notify();
            }
        }

        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            super.onCharacteristicChanged(gatt, characteristic);

            if (characteristicChangeHandler != null) {
                characteristicChangeHandler.handleCharacteristicChange(gatt, characteristic);
            }
        }

        @Override
        public void onServicesDiscovered(final BluetoothGatt gatt, int status) {
            Log.w(TAG, "onServicesDiscovered received: " + status);
            if (status == BluetoothGatt.GATT_SUCCESS) {
                //Log.w(TAG, "onServicesDiscovered received: " + status);
                connectionState = STATE_CONNECTED;
                invokeConnectionStatusHandler(BleConnectionStatus.CONNECTED);
            }
        }
    };

    private void startAutoReconnectAttempt() {

        stopAutoReconnectAttempt();

        connectionState = STATE_AUTO_RECONNECT;
        invokeConnectionStatusHandler(BleConnectionStatus.AUTO_RECONNECT);

        final Timer newTimer = new Timer();
        lastReconnectTimer = newTimer;
        newTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (bluetoothAdapter == null || bluetoothGatt == null) {
                    stopAutoReconnectAttempt();
                    return;
                }

                if (autoReconnect == false) {
                    //Log.i(TAG, "Auto reconnect disabled");
                    stopAutoReconnectAttempt();
                    return;
                }

                if (connectionState != STATE_AUTO_RECONNECT) {
                    //Log.i(TAG, "Invalid state, cancel auto reconnect");
                    stopAutoReconnectAttempt();
                    return;
                }

                if (!bluetoothAdapter.isEnabled()) {
                    //Log.i(TAG, "Bluetooth is disabled");
                    stopAutoReconnectAttempt();
                    return;
                }

                //Log.i(TAG, "Try to connect");
                bluetoothGatt.connect();
            }
        }, 0, 30000);
    }

    private void stopAutoReconnectAttempt() {
        if (lastReconnectTimer != null) {
            //Log.i(TAG, "Stop auto reconnect attempt");
            lastReconnectTimer.cancel();
            lastReconnectTimer = null;
        }
        if (connectionState == STATE_AUTO_RECONNECT) {
            connectionState = STATE_DISCONNECTED;
            invokeConnectionStatusHandler(BleConnectionStatus.DISCONNECTED);
        }
    }

    private void cleanupBleCommands() {
        bleOperationsService.shutdownNow();
        synchronized (bleOperationLock) {
            bleOperationLock.notifyAll();
        }
        bleOperationsService = Executors.newSingleThreadExecutor();
    }

    /**
     * Initializes a reference to the local Bluetooth adapter.
     *
     * @return Return true if the initialization is successful.
     */
    public boolean initialize() {
        //Log.i(TAG, "Initialize");
        // For API level 18 and above, get a reference to BluetoothAdapter through
        // BluetoothManager.
        if (bluetoothManager == null) {
            bluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
            if (bluetoothManager == null) {
                Log.e(TAG, "Unable to initialize BluetoothManager.");
                return false;
            }
        }

        try {
            bluetoothAdapter = bluetoothManager.getAdapter();
            if (bluetoothAdapter == null) {
                //Log.e(TAG, "Unable to obtain a BluetoothAdapter.");
                return false;
            }

        } catch (Exception e) {
            //Log.e(TAG, e.getMessage(), e);
            return false;
        }

        return true;
    }

    public void disconnect() {
        autoReconnect = false;
        lastBleAddress = null;
        stopAutoReconnectAttempt();
        if (bluetoothAdapter == null || bluetoothGatt == null) {
            //Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }
        bluetoothGatt.disconnect();
    }

    /**
     * After using a given BLE device, the app must call this method to ensure resources are
     * released properly.
     */
    public void close() {
        disconnect();
        context.unregisterReceiver(bluetoothStateReceiver);
        if (bluetoothGatt == null) {
            return;
        }
        bluetoothGatt.close();
        bluetoothGatt = null;
    }


    /**
     * Request a read on a given {@code BluetoothGattCharacteristic}
     *
     * @param characteristic The characteristic to read from.
     */
    public void readCharacteristic(final BluetoothGattCharacteristic characteristic, final ReadCharacteristicHandler handler) {
        bleOperationsService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {

                if (bluetoothAdapter == null || bluetoothGatt == null) {
                    //Log.w(TAG, "BluetoothAdapter not initialized");
                    return null;
                }
                synchronized (bleOperationLock) {
                    bluetoothGatt.readCharacteristic(characteristic);
                    bleOperationLock.wait();
                }
                if (handler != null) {
                    handler.handleValue(characteristic.getValue());
                }
                return null;
            }
        });
    }

    public void writeCharacteristic(final BluetoothGattCharacteristic characteristic, final byte[] data) {
        bleOperationsService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {

                if (bluetoothAdapter == null || bluetoothGatt == null) {
                    //Log.w(TAG, "BluetoothAdapter not initialized");
                    return null;
                }
                synchronized (bleOperationLock) {
                    //Log.i(TAG, "Write characteristic: " + Arrays.toString(data));
                    characteristic.setValue(data);
                    bluetoothGatt.writeCharacteristic(characteristic);
                    bleOperationLock.wait();
                }
                return null;
            }
        });
    }

    public void writeDescriptor(final BluetoothGattDescriptor descriptor) {
        bleOperationsService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {

                if (bluetoothAdapter == null || bluetoothGatt == null) {
                    //Log.w(TAG, "BluetoothAdapter not initialized");
                    return null;
                }
                synchronized (bleOperationLock) {
                    bluetoothGatt.writeDescriptor(descriptor);
                    bleOperationLock.wait();
                }
                return null;
            }
        });
    }

    public BleConnectionStatus getConnectionStatus() {
        switch (connectionState) {
            case STATE_CONNECTED:
                return BleConnectionStatus.CONNECTED;
            case STATE_DISCONNECTED:
                return BleConnectionStatus.DISCONNECTED;
            case STATE_CONNECTING:
            case STATE_SERVICE_DISCOVERING:
                return BleConnectionStatus.CONNECTING;
            case STATE_AUTO_RECONNECT:
                return BleConnectionStatus.AUTO_RECONNECT;
            default:
                throw new IllegalStateException("Illegal state: " + connectionState);
        }
    }

    /**
     * Enables or disables notification on a give characteristic.
     *
     * @param characteristic Characteristic to act on.
     * @param enabled        If true, enable notification.  False otherwise.
     */
    public void setCharacteristicNotification(BluetoothGattCharacteristic characteristic,
                                              boolean enabled) {
        if (bluetoothAdapter == null || bluetoothGatt == null || characteristic == null) {
            //Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }
        bluetoothGatt.setCharacteristicNotification(characteristic, enabled);
        BluetoothGattDescriptor descriptor = characteristic.getDescriptor(CHARACTERISTIC_UPDATE_NOTIFICATION_DESCRIPTOR_UUID);
        descriptor.setValue(enabled ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : new byte[]{0x00, 0x00});
        writeDescriptor(descriptor); //descriptor write operation successfully started?

    }

    /**
     * Retrieves a list of supported GATT services on the connected device. This should be
     * invoked only after {@code BluetoothGatt#discoverServices()} completes successfully.
     *
     * @return A {@code List} of supported services.
     */
    public List<BluetoothGattService> getSupportedGattServices() {
        if (bluetoothGatt == null) return null;

        return bluetoothGatt.getServices();
    }

    public BluetoothGattService getService(UUID serviceUuid) {
        return bluetoothGatt.getService(serviceUuid);
    }

    public void restoreConnection(final String address) {
        lastBleAddress = address;

        if (makeSureBleEnabled()) {
            connect(address, true);
        } else {
            Log.i(TAG, "Do not restore connection, BLE is disabled");
        }
    }

    private void initIfRequired() {
        if (bluetoothManager == null) {
            initialize();
        }
    }

    private boolean makeSureBleEnabled() {
        initIfRequired();

        if (bluetoothAdapter == null) {
            Log.w(TAG, "BluetoothAdapter not initialized.");
            return false;
        }

        // Ensures Bluetooth is enabled on the device.  If Bluetooth is not currently enabled,
        // fire an intent to display a dialog asking the user to grant permission to enable it.
        if (!bluetoothAdapter.isEnabled()) {
            Log.i(TAG, "Ask if should enable BLE");
            Intent btIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            btIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(btIntent);
            return false;
        }
        return true;
    }

    public BluetoothAdapter getBluetoothAdapter() {
        return bluetoothAdapter;
    }
}
