package com.althink.android.ossw.emulator.source;

import com.althink.android.ossw.emulator.model.EmulatorModelProperty;
import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 22/11/15.
 */
public class EmulatorModelDataSource implements EmulatorDataSource {

    private int propertyId;

    public EmulatorModelDataSource(int propertyId) {
        this.propertyId = propertyId;
    }

    @Override
    public Object getData(DataSourceType type, int range, EmulatorExecutionContext ctx) {
        EmulatorModelProperty property = ctx.getWatchset().getCurrentScreenModel().get(propertyId);
        if (property != null) {
            return property.getValue();
        }
        return null;
    }
}
