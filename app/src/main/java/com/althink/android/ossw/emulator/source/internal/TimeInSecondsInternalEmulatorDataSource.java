package com.althink.android.ossw.emulator.source.internal;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.watchsets.DataSourceType;

import java.util.Calendar;

/**
 * Created by krzysiek on 29/11/15.
 */
public class TimeInSecondsInternalEmulatorDataSource implements EmulatorDataSource {

    @Override
    public Object getData(DataSourceType type, int range, EmulatorExecutionContext ctx) {
        if (!DataSourceType.NUMBER.equals(type)) {
            return null;
        }
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY) * 3600 +
                Calendar.getInstance().get(Calendar.MINUTE) * 60 +
                Calendar.getInstance().get(Calendar.SECOND);
    }
}
