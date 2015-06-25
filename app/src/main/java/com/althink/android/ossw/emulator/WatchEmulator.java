package com.althink.android.ossw.emulator;

import com.althink.android.ossw.emulator.event.EmulatorEvent;
import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;
import com.althink.android.ossw.emulator.renderer.ScreenRender;
import com.althink.android.ossw.emulator.renderer.WatchSetRenderer;
import com.althink.android.ossw.emulator.watchset.WatchSetEmulatorModel;
import com.althink.android.ossw.emulator.watchset.WatchSetEmulatorParser;
import com.althink.android.ossw.service.OsswService;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchEmulator {

    private final static String TAG = WatchEmulator.class.getSimpleName();

    private ScreenRender screenRenderer;

    private OsswService osswBleService;

    private boolean colorsInverted = false;

    private boolean backlight = false;

    public WatchEmulator(OsswService osswBleService) {
        this.osswBleService = osswBleService;
    }

    public void render(LowLevelRenderer llr) {
        llr.setMode(colorsInverted, backlight);
        llr.clearScreen();
        if (screenRenderer != null) {
            screenRenderer.render(llr);
        }
    }

    public void handleEvent(EmulatorEvent event) {
        screenRenderer.handleEvent(event);
    /*    if (osswBleService != null) {
            osswBleService.invokeExtensionFunction("com.althink.android.ossw.plugins.musicplayer", "nextTrack");
        }*/
    }

    public WatchSetEmulatorModel parseWatchSet(byte[] watchSet) {
        return new WatchSetEmulatorParser(this).parse(watchSet);
    }

    public void showWatchSet(WatchSetEmulatorModel watchSet) {
        screenRenderer = new WatchSetRenderer(watchSet, osswBleService, this);
    }

    public void toggleBacklight() {
        backlight = !backlight;
    }

    public void toggleColors() {
        colorsInverted = !colorsInverted;
    }

    public Object getExternalProperty(int property) {
        return osswBleService.getExternalProperty(property);
    }
}
