package com.althink.android.ossw.service.ble;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

/**
 * Created by krzysiek on 10/10/15.
 */
public interface CharacteristicChangeHandler {
    void handleCharacteristicChange(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic);
}
