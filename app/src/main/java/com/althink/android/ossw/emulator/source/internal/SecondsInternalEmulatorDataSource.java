package com.althink.android.ossw.emulator.source.internal;

import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.watchsets.DataSourceType;

import java.util.Calendar;

/**
 * Created by krzysiek on 14/06/15.
 */
public class SecondsInternalEmulatorDataSource implements EmulatorDataSource {

    @Override
    public Object getData(DataSourceType type, int range) {
        if(!DataSourceType.NUMBER.equals(type)) {
            return null;
        }
        return Calendar.getInstance().get(Calendar.SECOND);
    }
}
