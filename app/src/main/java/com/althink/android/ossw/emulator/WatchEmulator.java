package com.althink.android.ossw.emulator;

import com.althink.android.ossw.emulator.event.EmulatorEvent;
import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;
import com.althink.android.ossw.emulator.renderer.ScreenRender;
import com.althink.android.ossw.emulator.renderer.WatchSetRenderer;
import com.althink.android.ossw.emulator.watchset.WatchSetEmulatorModel;
import com.althink.android.ossw.emulator.watchset.WatchSetEmulatorParser;
import com.althink.android.ossw.service.OsswService;
import com.althink.android.ossw.service.OsswServiceProvider;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchEmulator {

    private final static String TAG = WatchEmulator.class.getSimpleName();

    private ScreenRender screenRenderer;

    private OsswServiceProvider osswBleServiceProvider;

    private boolean colorsInverted = false;

    private boolean backlight = false;

    private int watchSetId = 0;

    public WatchEmulator(OsswServiceProvider osswBleServiceProvider) {
        this.osswBleServiceProvider = osswBleServiceProvider;
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
    }

    public WatchSetEmulatorModel parseWatchSet(byte[] watchSet) {
        return new WatchSetEmulatorParser(this).parse(watchSet);
    }

    public void showWatchSet(WatchSetEmulatorModel watchSet) {

        watchSetId = watchSet.getId();
        screenRenderer = new WatchSetRenderer(watchSet, osswBleServiceProvider.getService(), this);
    }

    public void toggleBacklight() {
        backlight = !backlight;
    }

    public void toggleColors() {
        colorsInverted = !colorsInverted;
    }

    public Object getExternalProperty(int property) {
        OsswService service = osswBleServiceProvider.getService();
        if (service == null) {
            return null;
        }
        return service.getExternalProperty(watchSetId, property);
    }
}
