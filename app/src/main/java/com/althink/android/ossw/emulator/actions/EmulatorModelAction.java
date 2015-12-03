package com.althink.android.ossw.emulator.actions;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.service.OsswService;
import com.althink.android.ossw.service.WatchExtensionFunction;
import com.althink.android.ossw.watch.WatchConstants;
import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 23/11/15.
 */
public class EmulatorModelAction implements EmulatorAction {

    private int actionType;
    private int propertyId;
    private EmulatorDataSource dataSource;

    public EmulatorModelAction(int actionType, int propertyId) {
        this.actionType = actionType;
        this.propertyId = propertyId;
    }

    public EmulatorModelAction(int actionType, int propertyId, EmulatorDataSource dataSource) {
        this.actionType = actionType;
        this.dataSource = dataSource;
        this.propertyId = propertyId;
    }

    @Override
    public void performAction(EmulatorExecutionContext ctx) {
        switch (actionType) {
            case WatchConstants.WATCHSET_FUNCTION_MODEL_SET:
                ctx.getWatchset().getCurrentScreenModel().get(propertyId).setValue(dataSource.getData(DataSourceType.NUMBER, 0x40, ctx));
                break;
            case WatchConstants.WATCHSET_FUNCTION_MODEL_INCREMENT:
                ctx.getWatchset().getCurrentScreenModel().get(propertyId).increment();
                break;
            case WatchConstants.WATCHSET_FUNCTION_MODEL_DECREMENT:
                ctx.getWatchset().getCurrentScreenModel().get(propertyId).decrement();
                break;
            case WatchConstants.WATCHSET_FUNCTION_MODEL_ADD:
                ctx.getWatchset().getCurrentScreenModel().get(propertyId).add(dataSource.getData(DataSourceType.NUMBER, 0x40, ctx));
                break;
            case WatchConstants.WATCHSET_FUNCTION_MODEL_SUBTRACT:
                ctx.getWatchset().getCurrentScreenModel().get(propertyId).subtract(dataSource.getData(DataSourceType.NUMBER, 0x40, ctx));
                break;
        }
    }
}
