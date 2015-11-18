package com.althink.android.ossw.emulator.source;

import com.althink.android.ossw.emulator.WatchEmulator;
import com.althink.android.ossw.emulator.source.internal.BatteryLevelInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.DayOfMonthInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.DayOfWeekInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.DayOfYearInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.Hour12DesignatorInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.Hour12InternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.Hour24InternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.MinutesInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.MonthInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.SecondsInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.StaticTextDataSource;
import com.althink.android.ossw.emulator.source.internal.YearInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.ZeroDataSource;
import com.althink.android.ossw.watch.WatchConstants;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by krzysiek on 14/06/15.
 */
public class EmulatorDataSourceFactory {
    public static EmulatorDataSource internalDataSource(int property) {
        switch (property) {
            case WatchConstants.INTERNAL_DATA_SOURCE_TIME_HOUR_12:
                return new Hour12InternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_TIME_HOUR_12_DESIGNATOR:
                return new Hour12DesignatorInternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_TIME_HOUR_24:
                return new Hour24InternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_TIME_MINUTES:
                return new MinutesInternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_TIME_SECONDS:
                return new SecondsInternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_DATE_DAY_OF_WEEK:
                return new DayOfWeekInternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_DATE_DAY_OF_MONTH:
                return new DayOfMonthInternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_DATE_DAY_OF_YEAR:
                return new DayOfYearInternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_DATE_MONTH:
                return new MonthInternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_DATE_YEAR:
                return new YearInternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_BATTERY_LEVEL:
                return new BatteryLevelInternalEmulatorDataSource();
            default:
                return new ZeroDataSource();
        }
    }

    public static EmulatorDataSource externalDataSource(int property, WatchEmulator emulator) {
        return new ExternalEmulatorDataSource(emulator, property);
    }

    public static EmulatorDataSource sensorDataSource(int property) {
        return new ZeroDataSource();
    }

    public static EmulatorDataSource staticDataSource(int property, InputStream is) {
        byte[] bytes = new byte[property];
        try {
            is.read(bytes, 0, property);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return new StaticTextDataSource(new String(bytes));
    }
}
