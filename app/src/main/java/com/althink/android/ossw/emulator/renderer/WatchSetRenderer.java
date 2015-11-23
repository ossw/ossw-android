package com.althink.android.ossw.emulator.renderer;

import android.support.annotation.NonNull;

import com.althink.android.ossw.emulator.WatchEmulator;
import com.althink.android.ossw.emulator.actions.EmulatorAction;
import com.althink.android.ossw.emulator.control.EmulatorControl;
import com.althink.android.ossw.emulator.event.EmulatorEvent;
import com.althink.android.ossw.emulator.watchset.WatchSetEmulatorModel;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchSetRenderer implements ScreenRender {

    private WatchSetEmulatorModel watchset;
    private WatchEmulator emulator;

    public WatchSetRenderer(WatchSetEmulatorModel watchset, WatchEmulator emulator) {
        this.watchset = watchset;
        this.emulator = emulator;
    }

    @Override
    public void render(LowLevelRenderer renderer) {
        for (EmulatorControl control : watchset.getCurrentScreenControls()) {
            control.draw(renderer, buildCtx());
        }
    }

    @Override
    public void handleEvent(EmulatorEvent event) {
        EmulatorAction actionForEvent = watchset.getActionForEvent(event);
        if (actionForEvent != null) {
            actionForEvent.performAction(buildCtx());
        }
    }

    @NonNull
    private EmulatorExecutionContext buildCtx() {
        return new EmulatorExecutionContext(watchset, emulator);
    }
}
