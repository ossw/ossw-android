package com.althink.android.ossw.emulator.source.converter;

/**
 * Created by krzysiek on 29/11/15.
 */
public class TimeToFiveMinutesRoundedTimeConverter implements EmulatorDataConverter {

    @Override
    public Object convert(Object value) {
        if (!(value instanceof Integer)) {
            return 0;
        }
        int v = (Integer) value;
        return (((v + 150) / 300) % 288) * 300;
    }
}
