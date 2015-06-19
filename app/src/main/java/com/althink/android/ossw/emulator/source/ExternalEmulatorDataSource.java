package com.althink.android.ossw.emulator.source;

import com.althink.android.ossw.emulator.WatchEmulator;

/**
 * Created by krzysiek on 19/06/15.
 */
public class ExternalEmulatorDataSource implements EmulatorDataSource {

    private WatchEmulator emulator;
    private int property;

    public ExternalEmulatorDataSource(WatchEmulator emulator, int property) {
        this.emulator = emulator;
        this.property = property;
    }

    @Override
    public Object getData() {
        return emulator.getExternalProperty(property);
    }
}
