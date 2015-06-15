package com.althink.android.ossw.emulator.renderer;

import com.althink.android.ossw.emulator.control.EmulatorControl;
import com.althink.android.ossw.emulator.watchset.WatchSetEmulatorModel;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchsetRenderer implements ScreenRender {

    private WatchSetEmulatorModel watchset;

    public WatchsetRenderer(WatchSetEmulatorModel watchset) {
        this.watchset = watchset;
    }

    @Override
    public void render(LowLevelRenderer renderer) {
        for (EmulatorControl control : watchset.getCurrentScreenControls()) {
            control.draw(renderer);
        }
    }
}
