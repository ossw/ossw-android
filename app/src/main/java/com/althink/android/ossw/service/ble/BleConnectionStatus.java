package com.althink.android.ossw.service.ble;

import com.althink.android.ossw.R;
import com.althink.android.ossw.service.OsswService;

/**
 * Created by krzysiek on 10/10/15.
 * vaspa: Add resource id for internationalization
 */
public enum BleConnectionStatus {
    DISCONNECTED(R.string.disconnected),
    CONNECTING(R.string.connecting),
    CONNECTED(R.string.connected),
    AUTO_RECONNECT(R.string.auto_reconnect);
    private int stringId;

    BleConnectionStatus(int sId) {
        stringId = sId;
    }

    @Override
    public String toString() {
        return OsswService.getInstance().getApplicationContext().getString(stringId);
    }
}
