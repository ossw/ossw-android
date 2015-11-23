package com.althink.android.ossw.emulator.actions;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
import com.althink.android.ossw.service.OsswService;
import com.althink.android.ossw.service.WatchExtensionFunction;
import com.althink.android.ossw.watch.WatchConstants;

/**
 * Created by krzysiek on 18/06/15.
 */
public class SimpleEmulatorAction implements EmulatorAction {
    private int actionType;
    private int parameter;

    public SimpleEmulatorAction(int actionType, int parameter) {
        this.actionType = actionType;
        this.parameter = parameter;
    }

    public void performAction(EmulatorExecutionContext ctx) {
        switch (actionType) {
            case WatchConstants.WATCHSET_FUNCTION_TOGGLE_BACKLIGHT:
                ctx.getEmulator().toggleBacklight();
                break;
            case WatchConstants.WATCHSET_FUNCTION_TOGGLE_COLORS:
                ctx.getEmulator().toggleColors();
                break;
            case WatchConstants.WATCHSET_FUNCTION_CHANGE_SCREEN:
                ctx.getWatchset().setCurrentScreen(parameter);
                break;
            case WatchConstants.WATCHSET_FUNCTION_EXTENSION:
                WatchExtensionFunction function = ctx.getWatchset().getOperationContext().getExternalFunctions().get(parameter);
                OsswService service = OsswService.getInstance();
                if (service != null) {
                    service.invokeExtensionFunction(function.getPluginId(), function.getFunctionId(), function.getParameter());
                }
                break;
        }
    }
}
