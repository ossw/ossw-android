package com.althink.android.ossw.emulator.source;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 17/11/15.
 */
public class StaticDataSource implements EmulatorDataSource {
    private byte[] data;

    public StaticDataSource(byte[] data) {
        this.data = data;
    }

    @Override
    public Object getData(DataSourceType type, int range, EmulatorExecutionContext ctx) {
        if (type == DataSourceType.STRING) {
            return new String(data);
        } else if (type == DataSourceType.NUMBER) {
            return new Integer(data[0] << 24 | data[1] << 16 | data[2] << 8 | data[3]);
        }
        return null;
    }
}
