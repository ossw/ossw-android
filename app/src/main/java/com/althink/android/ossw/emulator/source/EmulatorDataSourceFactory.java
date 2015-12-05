package com.althink.android.ossw.emulator.source;

import com.althink.android.ossw.emulator.WatchEmulator;
import com.althink.android.ossw.emulator.source.converter.EmulatorDataConverter;
import com.althink.android.ossw.emulator.source.converter.Hour24ToHour12Converter;
import com.althink.android.ossw.emulator.source.converter.Hour24ToHour12PeriodConverter;
import com.althink.android.ossw.emulator.source.converter.HundredsConverter;
import com.althink.android.ossw.emulator.source.converter.MinutesToPastToDesignatorConverter;
import com.althink.android.ossw.emulator.source.converter.MinutesToPastToMinutesConverter;
import com.althink.android.ossw.emulator.source.converter.OnesConverter;
import com.althink.android.ossw.emulator.source.converter.TensConverter;
import com.althink.android.ossw.emulator.source.converter.TimeToFiveMinutesRoundedTimeConverter;
import com.althink.android.ossw.emulator.source.converter.TimeToHour24Converter;
import com.althink.android.ossw.emulator.source.converter.TimeToMinutesConverter;
import com.althink.android.ossw.emulator.source.converter.MockConverter;
import com.althink.android.ossw.emulator.source.converter.TimeToRoundedHour24Converter;
import com.althink.android.ossw.emulator.source.converter.TimeToSecondsConverter;
import com.althink.android.ossw.emulator.source.internal.BatteryLevelInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.DayOfMonthInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.DayOfWeekInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.DayOfYearInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.FirmwareVersionInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.Hour12DesignatorInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.Hour12InternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.Hour24InternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.MacAddressInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.MinutesInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.MonthInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.SecondsInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.TimeInSecondsInternalEmulatorDataSource;
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
        return internalDataSource(property, null);
    }

    public static EmulatorDataSource internalDataSource(int property, EmulatorDataSource index) {
        switch (property) {
            case WatchConstants.INTERNAL_DATA_SOURCE_TIME_IN_SECONDS:
                return new TimeInSecondsInternalEmulatorDataSource();
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
            case WatchConstants.INTERNAL_DATA_SOURCE_FIRMWARE_VERSION:
                return new FirmwareVersionInternalEmulatorDataSource();
            case WatchConstants.INTERNAL_DATA_SOURCE_MAC_ADDRESS:
                return new MacAddressInternalEmulatorDataSource();
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
        return new StaticDataSource(bytes);
    }

    public static EmulatorDataSource modelDataSource(int property) throws Exception {
        return new EmulatorModelDataSource(property);
    }

    public static EmulatorDataSource convertedDataSource(int converterId, EmulatorDataSource dataSource) throws Exception {
        EmulatorDataConverter converter;
        switch (converterId) {
            case WatchConstants.CONVERTER_TIME_TO_HOUR_24:
                converter = new TimeToHour24Converter();
                break;
            case WatchConstants.CONVERTER_TIME_TO_ROUNDED_HOUR_24:
                converter = new TimeToRoundedHour24Converter();
                break;
            case WatchConstants.CONVERTER_TIME_TO_MINUTES:
                converter = new TimeToMinutesConverter();
                break;
            case WatchConstants.CONVERTER_TIME_TO_SECONDS:
                converter = new TimeToSecondsConverter();
                break;
            case WatchConstants.CONVERTER_TIME_TO_FIVE_MINUTES_ROUNDED_TIME:
                converter = new TimeToFiveMinutesRoundedTimeConverter();
                break;
            case WatchConstants.CONVERTER_HOUR_24_TO_HOUR_12:
                converter = new Hour24ToHour12Converter();
                break;
            case WatchConstants.CONVERTER_HOUR_24_TO_HOUR_12_PERIOD:
                converter = new Hour24ToHour12PeriodConverter();
                break;
            case WatchConstants.CONVERTER_MINUTES_TO_PAST_TO_MINUTES:
                converter = new MinutesToPastToMinutesConverter();
                break;
            case WatchConstants.CONVERTER_MINUTES_TO_PAST_TO_DESIGNATOR:
                converter = new MinutesToPastToDesignatorConverter();
                break;
            case WatchConstants.CONVERTER_ONES:
                converter = new OnesConverter();
                break;
            case WatchConstants.CONVERTER_TENS:
                converter = new TensConverter();
                break;
            case WatchConstants.CONVERTER_HUNDREDS:
                converter = new HundredsConverter();
                break;
            default:
                converter = new MockConverter();

        }
        return new EmulatorConvertedDataSource(converter, dataSource);
    }


}
