package com.althink.android.ossw.emulator.source;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
import com.althink.android.ossw.emulator.source.converter.EmulatorDataConverter;
import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 29/11/15.
 */
public class EmulatorConvertedDataSource implements EmulatorDataSource {

    private EmulatorDataConverter converter;
    private EmulatorDataSource dataSource;

    public EmulatorConvertedDataSource(EmulatorDataConverter converter, EmulatorDataSource dataSource) {
        this.converter = converter;
        this.dataSource = dataSource;
    }

    @Override
    public Object getData(DataSourceType type, int range, EmulatorExecutionContext ctx) {
        return converter.convert(dataSource.getData(type, range, ctx));
    }
}
