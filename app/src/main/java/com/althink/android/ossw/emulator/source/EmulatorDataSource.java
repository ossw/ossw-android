package com.althink.android.ossw.emulator.source;

import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 14/06/15.
 */
public interface EmulatorDataSource {

    public Object getData(DataSourceType type, int range);
}
