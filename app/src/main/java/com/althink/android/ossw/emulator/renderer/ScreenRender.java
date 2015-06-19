package com.althink.android.ossw.emulator.renderer;

import com.althink.android.ossw.emulator.event.EmulatorEvent;

/**
 * Created by krzysiek on 14/06/15.
 */
public interface ScreenRender {
    void render(LowLevelRenderer renderer);

    void handleEvent(EmulatorEvent event);
}
