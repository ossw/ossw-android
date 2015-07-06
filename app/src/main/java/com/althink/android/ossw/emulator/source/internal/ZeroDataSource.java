package com.althink.android.ossw.emulator.source.internal;

import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 06/07/15.
 */
public class ZeroDataSource implements EmulatorDataSource {
    @Override
    public Object getData(DataSourceType type, int range) {
        return 0;
    }
}
