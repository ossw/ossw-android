package com.althink.android.ossw.emulator.source.internal;

import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 17/11/15.
 */
public class StaticTextDataSource implements EmulatorDataSource {
    private String text;

    public StaticTextDataSource(String text) {
        this.text = text;
    }

    @Override
    public Object getData(DataSourceType type, int range) {
        return text;
    }
}
