package com.althink.android.ossw.emulator.renderer;

import com.althink.android.ossw.emulator.WatchEmulator;
import com.althink.android.ossw.emulator.actions.EmulatorAction;
import com.althink.android.ossw.emulator.actions.EmulatorActionHandler;
import com.althink.android.ossw.emulator.control.EmulatorControl;
import com.althink.android.ossw.emulator.event.EmulatorEvent;
import com.althink.android.ossw.emulator.watchset.WatchSetEmulatorModel;
import com.althink.android.ossw.service.OsswService;
import com.althink.android.ossw.watch.WatchConstants;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchsetRenderer implements ScreenRender {

    private WatchSetEmulatorModel watchset;
    private OsswService service;
    private WatchEmulator emulator;

    public WatchsetRenderer(WatchSetEmulatorModel watchset, OsswService service, WatchEmulator emulator) {
        this.watchset = watchset;
        this.service = service;
        this.emulator = emulator;
    }

    @Override
    public void render(LowLevelRenderer renderer) {
        for (EmulatorControl control : watchset.getCurrentScreenControls()) {
            control.draw(renderer);
        }
    }

    @Override
    public void handleEvent(EmulatorEvent event) {
        EmulatorAction actionForEvent = watchset.getActionForEvent(event);
        if (actionForEvent != null) {
            int param = actionForEvent.getParameter();
            switch (actionForEvent.getActionType()) {
                case WatchConstants.WATCHSET_FUNCTION_TOGGLE_BACKLIGHT:
                    emulator.toggleBacklight();
                    break;
                case WatchConstants.WATCHSET_FUNCTION_TOGGLE_COLORS:
                    emulator.toggleColors();
                    break;
                case WatchConstants.WATCHSET_FUNCTION_CHANGE_SCREEN:
                    watchset.setCurrentScreen(param);
                    break;
            }
        }
    }
}
