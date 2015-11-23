package com.althink.android.ossw.emulator.actions;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.watchsets.DataSourceType;

import java.util.List;
import java.util.Map;

/**
 * Created by krzysiek on 22/11/15.
 */
public class EmulatorChooseAction implements EmulatorAction {

    private EmulatorDataSource dataSource;
    private Map<Object, List<EmulatorAction>> map;

    public EmulatorChooseAction(EmulatorDataSource dataSource, Map<Object, List<EmulatorAction>> map) {
        this.map = map;
        this.dataSource = dataSource;
    }

    @Override
    public void performAction(EmulatorExecutionContext ctx) {
        Object value = dataSource.getData(DataSourceType.NUMBER, 0x40, ctx);
        List<EmulatorAction> actions = map.get(value);
        if (actions != null) {
            for (EmulatorAction action : actions) {
                action.performAction(ctx);
            }
        }
    }
}
