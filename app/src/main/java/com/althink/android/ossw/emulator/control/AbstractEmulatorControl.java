package com.althink.android.ossw.emulator.control;

import com.althink.android.ossw.emulator.source.EmulatorDataSource;

/**
 * Created by krzysiek on 14/06/15.
 */
public abstract class AbstractEmulatorControl implements EmulatorControl {

    private EmulatorDataSource dataSource;

    protected AbstractEmulatorControl(EmulatorDataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected Object getData() {
        return dataSource.getData();
    }
}
