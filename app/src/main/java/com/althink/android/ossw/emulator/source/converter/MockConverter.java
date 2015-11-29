package com.althink.android.ossw.emulator.source.converter;

/**
 * Created by krzysiek on 29/11/15.
 */
public class MockConverter implements EmulatorDataConverter {
    @Override
    public Object convert(Object value) {
        return value;
    }
}
