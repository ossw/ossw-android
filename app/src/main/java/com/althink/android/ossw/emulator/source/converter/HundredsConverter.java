package com.althink.android.ossw.emulator.source.converter;

/**
 * Created by krzysiek on 01/12/15.
 */
public class HundredsConverter implements EmulatorDataConverter {
    @Override
    public Object convert(Object value) {
        if (!(value instanceof Integer)) {
            return 0;
        }
        int v = (Integer) value;
        return (v/100)%10;
    }
}
