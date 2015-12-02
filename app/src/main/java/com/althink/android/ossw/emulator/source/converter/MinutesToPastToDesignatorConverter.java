package com.althink.android.ossw.emulator.source.converter;

/**
 * Created by krzysiek on 29/11/15.
 */
public class MinutesToPastToDesignatorConverter implements EmulatorDataConverter {

    @Override
    public Object convert(Object value) {
        if (!(value instanceof Integer)) {
            return 0;
        }
        int v = (Integer) value;
        if (v > 30) {
            return 2;
        } else if (v == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
