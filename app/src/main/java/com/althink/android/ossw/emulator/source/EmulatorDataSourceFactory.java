package com.althink.android.ossw.emulator.source;

import com.althink.android.ossw.emulator.source.internal.HourInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.MinutesInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.SecondsInternalEmulatorDataSource;
import com.althink.android.ossw.watch.WatchConstants;

/**
 * Created by krzysiek on 14/06/15.
 */
public class EmulatorDataSourceFactory {
    public static EmulatorDataSource internalDataSource(int property) {
        switch (property) {
            case WatchConstants.INTERNAL_DATA_SOURCE_TIME_HOUR:
                return new HourInternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_TIME_MINUTES:
                return new MinutesInternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_TIME_SECONDS:
                return new SecondsInternalEmulatorDataSource();
            default:
                throw new IllegalArgumentException("Invalid property: " + property);
        }
    }

    public static EmulatorDataSource externalDataSource(int property) {
        return null;
    }
}
