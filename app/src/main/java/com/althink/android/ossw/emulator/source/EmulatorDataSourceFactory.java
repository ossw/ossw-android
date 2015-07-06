package com.althink.android.ossw.emulator.source;

import com.althink.android.ossw.emulator.WatchEmulator;
import com.althink.android.ossw.emulator.source.internal.BatteryLevelInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.DayOfMonthInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.HourInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.MinutesInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.MonthInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.SecondsInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.YearInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.ZeroDataSource;
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
            case WatchConstants.INTERNAL_DATA_SOURCE_DATE_DAY_OF_MONTH:
                return new DayOfMonthInternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_DATE_MONTH:
                return new MonthInternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_DATE_YEAR:
                return new YearInternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_BATTERY_LEVEL:
                return new BatteryLevelInternalEmulatorDataSource();
            default:
                throw new IllegalArgumentException("Invalid property: " + property);
        }
    }

    public static EmulatorDataSource externalDataSource(int property, WatchEmulator emulator) {
        return new ExternalEmulatorDataSource(emulator, property);
    }

    public static EmulatorDataSource sensorDataSource(int property) {
        return new ZeroDataSource();
    }
}
