package com.althink.android.ossw.emulator.source.internal;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 05/12/15.
 */
public class MacAddressInternalEmulatorDataSource implements EmulatorDataSource {

    @Override
    public Object getData(DataSourceType type, int range, EmulatorExecutionContext ctx) {
        return "XX:XX:XX:XX:XX:XX";
    }
}
