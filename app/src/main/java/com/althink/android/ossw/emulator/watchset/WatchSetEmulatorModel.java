package com.althink.android.ossw.emulator.watchset;

import com.althink.android.ossw.emulator.control.EmulatorControl;

import java.util.List;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchSetEmulatorModel {

    List<WatchSetScreenEmulatorModel> screens;
    private int currentScreen = 0;


    public WatchSetEmulatorModel() {
    }

    public WatchSetEmulatorModel(List<WatchSetScreenEmulatorModel> screens) {
        this.screens = screens;
    }

    public List<EmulatorControl> getCurrentScreenControls() {
        return screens.get(currentScreen).getControls();
    }

    public void setScreens(List<WatchSetScreenEmulatorModel> screens) {
        this.screens = screens;
    }
}
