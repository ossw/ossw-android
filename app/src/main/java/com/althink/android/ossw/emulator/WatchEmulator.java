package com.althink.android.ossw.emulator;

import com.althink.android.ossw.emulator.event.EmulatorEvent;
import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;
import com.althink.android.ossw.emulator.renderer.ScreenRender;
import com.althink.android.ossw.emulator.renderer.WatchSetRenderer;
import com.althink.android.ossw.emulator.watchset.WatchSetEmulatorModel;
import com.althink.android.ossw.emulator.watchset.WatchSetEmulatorParser;
import com.althink.android.ossw.service.OsswService;
import com.althink.android.ossw.service.OsswServiceProvider;
import com.althink.android.ossw.service.WatchExtensionProperty;
import com.althink.android.ossw.watchsets.CompiledWatchSet;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchEmulator {

    private final static String TAG = WatchEmulator.class.getSimpleName();

    private ScreenRender screenRenderer;

    private OsswServiceProvider osswBleServiceProvider;

    private boolean colorsInverted = false;

    private boolean backlight = false;

    private WatchSetEmulatorModel watchSet;

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

    public WatchSetEmulatorModel parseWatchSet(CompiledWatchSet watchSet) {
        WatchSetEmulatorModel emulatorModel = new WatchSetEmulatorParser(this).parse(watchSet.getWatchData());
        emulatorModel.setOperationContext(watchSet.getWatchContext());
        return emulatorModel;
    }

    public void showWatchSet(WatchSetEmulatorModel watchSet) {

        this.watchSet = watchSet;
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
        WatchExtensionProperty extensionProperty = watchSet.getOperationContext().getExternalParameters().get(property);
        return service.getPropertyFromExtension(extensionProperty.getPluginId(), extensionProperty.getPropertyId());
    }
}
