package com.althink.android.ossw.service.ble;

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
import android.os.Handler;
import android.util.Log;

import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
    private BluetoothGatt mBluetoothGatt;
    private Object bleOperationLock = new Object();
    private BluetoothManager mBluetoothManager;
    private BluetoothAdapter mBluetoothAdapter;
    private String mBluetoothDeviceAddress;
    private BluetoothGattServer mGattServer;

    private int mConnectionState = STATE_DISCONNECTED;

    private BleConnectionStatusHandler connStatusHandler;
    private CharacteristicChangeHandler characteristicChangeHandler;

    private ExecutorService autoReconnectExecutor = new ThreadPoolExecutor(1, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.DiscardPolicy());
    private Handler mHandler = new Handler();
    private boolean autoReconnect = false;
    private Timer lastReconnectTimer;

    public BleDeviceService(Context context, BleConnectionStatusHandler connStatusHandler, CharacteristicChangeHandler characteristicChangeHandler) {
        this.context = context;
        this.connStatusHandler = connStatusHandler;
        this.characteristicChangeHandler = characteristicChangeHandler;
    }

    public boolean connect(String address, boolean autoReconnect) {
        this.autoReconnect = autoReconnect;

        if (mBluetoothManager == null) {
            initialize();
        }

        if (mBluetoothAdapter == null || address == null) {
            //Log.w(TAG, "BluetoothAdapter not initialized or unspecified address.");
            return false;
        }

        // Previously connected device.  Try to reconnect.
        if (mBluetoothGatt != null) {
            Log.d(TAG, "Trying to use an existing mBluetoothGatt for connection.");
            if (mBluetoothGatt.connect()) {
                mConnectionState = STATE_CONNECTING;
                invokeConnectionStatusHandler(BleConnectionStatus.CONNECTING);
                return true;
            } else {
                return false;
            }
        }

        final BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
        if (device == null) {
            //Log.w(TAG, "Device not found. Unable to connect.");
            invokeConnectionStatusHandler(BleConnectionStatus.DISCONNECTED);
            return false;
        }

        invokeConnectionStatusHandler(BleConnectionStatus.CONNECTING);
        // We want to directly connect to the device, so we are setting the autoConnect
        // parameter to false.
        mBluetoothGatt = device.connectGatt(context, false, mGattCallback);
        //Log.d(TAG, "Trying to create a new connection.");
        mBluetoothDeviceAddress = address;
        mConnectionState = STATE_CONNECTING;

        return true;
    }

    public boolean isConnected() {
        return mBluetoothGatt != null && mConnectionState == STATE_CONNECTED;
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
                mConnectionState = STATE_SERVICE_DISCOVERING;
                //broadcastUpdate(intentAction);
                //Log.i(TAG, "Connected to GATT server.");
                // Attempts to discover services after successful connection.
                mBluetoothGatt.discoverServices();


            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                //Log.i(TAG, "Disconnected from GATT server.");
                cleanupBleCommands();

                if (autoReconnect) {
                    startAutoReconnectAttempt();
                } else {
                    mConnectionState = STATE_DISCONNECTED;
                    invokeConnectionStatusHandler(BleConnectionStatus.DISCONNECTED);
                }
            }
        }

        @Override
        public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
            super.onDescriptorWrite(gatt, descriptor, status);

            Log.i(TAG, "OnDescriptorWrite: " + descriptor);
            synchronized (bleOperationLock) {
                bleOperationLock.notify();
            }
        }

        @Override
        public void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
            super.onDescriptorRead(gatt, descriptor, status);

            Log.i(TAG, "onDescriptorRead: " + descriptor);
            synchronized (bleOperationLock) {
                bleOperationLock.notify();
            }
        }

        @Override
        public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            super.onCharacteristicWrite(gatt, characteristic, status);

            Log.i(TAG, "onCharacteristicWrite: " + characteristic.getUuid() + ", " + Arrays.toString(characteristic.getValue()));
            synchronized (bleOperationLock) {
                bleOperationLock.notify();
            }
        }

        @Override
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            super.onCharacteristicRead(gatt, characteristic, status);

            Log.i(TAG, "onCharacteristicRead: " + characteristic.getUuid() + ", " + characteristic.getStringValue(0));
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
                mConnectionState = STATE_CONNECTED;
                invokeConnectionStatusHandler(BleConnectionStatus.CONNECTED);
            }
        }
    };

    private void startAutoReconnectAttempt() {

        stopAutoReconnectAttempt();

        mConnectionState = STATE_AUTO_RECONNECT;
        invokeConnectionStatusHandler(BleConnectionStatus.AUTO_RECONNECT);

        final Timer newTimer = new Timer();
        lastReconnectTimer = newTimer;
        newTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (mBluetoothAdapter == null || mBluetoothGatt == null) {
                    stopTimer();
                    return;
                }

                if (autoReconnect == false) {
                    Log.i(TAG, "Auto reconnect disabled");
                    stopTimer();
                    return;
                }

                if (mConnectionState != STATE_AUTO_RECONNECT) {
                    Log.i(TAG, "Invalid state, cancel auto reconnect");
                    stopTimer();
                    return;
                }

                Log.i(TAG, "Try to connect");
                mBluetoothGatt.connect();
            }

            private void stopTimer() {
                Log.i(TAG, "Stop reconnect timer");
                newTimer.cancel();
            }
        }, 0, 30000);
    }

    private void stopAutoReconnectAttempt() {
        if (lastReconnectTimer != null) {
            Log.i(TAG, "Stop auto reconnect attempt");
            lastReconnectTimer.cancel();
            lastReconnectTimer = null;
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
        if (mBluetoothManager == null) {
            mBluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
            if (mBluetoothManager == null) {
                Log.e(TAG, "Unable to initialize BluetoothManager.");
                return false;
            }
        }

        try {
            mBluetoothAdapter = mBluetoothManager.getAdapter();
            if (mBluetoothAdapter == null) {
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
        stopAutoReconnectAttempt();
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
     * Request a read on a given {@code BluetoothGattCharacteristic}
     *
     * @param characteristic The characteristic to read from.
     */
    public void readCharacteristic(final BluetoothGattCharacteristic characteristic, final ReadCharacteristicHandler handler) {
        bleOperationsService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {

                if (mBluetoothAdapter == null || mBluetoothGatt == null) {
                    //Log.w(TAG, "BluetoothAdapter not initialized");
                    return null;
                }
                synchronized (bleOperationLock) {
                    mBluetoothGatt.readCharacteristic(characteristic);
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

                if (mBluetoothAdapter == null || mBluetoothGatt == null) {
                    //Log.w(TAG, "BluetoothAdapter not initialized");
                    return null;
                }
                synchronized (bleOperationLock) {
                    Log.i(TAG, "Write characteristic: " + Arrays.toString(data));
                    characteristic.setValue(data);
                    mBluetoothGatt.writeCharacteristic(characteristic);
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

                if (mBluetoothAdapter == null || mBluetoothGatt == null) {
                    //Log.w(TAG, "BluetoothAdapter not initialized");
                    return null;
                }
                synchronized (bleOperationLock) {
                    mBluetoothGatt.writeDescriptor(descriptor);
                    bleOperationLock.wait();
                }
                return null;
            }
        });
    }

    public BleConnectionStatus getConnectionStatus() {
        switch (mConnectionState) {
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
                throw new IllegalStateException("Illegal state: " + mConnectionState);
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
        if (mBluetoothAdapter == null || mBluetoothGatt == null) {
            //Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }
        mBluetoothGatt.setCharacteristicNotification(characteristic, enabled);
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
        if (mBluetoothGatt == null) return null;

        return mBluetoothGatt.getServices();
    }

    public BluetoothGattService getService(UUID serviceUuid) {
        return mBluetoothGatt.getService(serviceUuid);
    }

    public void restoreConnection(final String address) {
        Runnable run = new Runnable() {
            //
            private boolean mScanning;

            // Stops scanning after 10 seconds.
            private static final long SCAN_PERIOD = 20000;

            private BluetoothAdapter.LeScanCallback callback = new BluetoothAdapter.LeScanCallback() {
                @Override
                public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
                    Log.i(TAG, "Dev found: " + device.getName());
                    if (device.getAddress().equals(address)) {
                        Log.i(TAG, "Watch was found");
                        connect(address, true);
                        scanLeDevice(false);
                    }
                }
            };

            @Override
            public void run() {
                if (mBluetoothManager == null) {
                    initialize();
                }

                scanLeDevice(true);
            }

            private void scanLeDevice(final boolean enable) {
                if (enable) {
                    // Stops scanning after a pre-defined scan period.
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mScanning = false;
                            stopLeScan();
                        }
                    }, SCAN_PERIOD);

                    mScanning = true;
                    startLeScan();
                } else {
                    mScanning = false;
                    stopLeScan();
                }
            }

            private void startLeScan() {
                Log.i(TAG, "Start scan");
                mBluetoothAdapter.startLeScan(callback);
            }

            private void stopLeScan() {
                Log.i(TAG, "Stop scan");
                mBluetoothAdapter.stopLeScan(callback);
            }
        };
        run.run();
    }
}
