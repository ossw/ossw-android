package com.althink.android.ossw.emulator.watchset;

import com.althink.android.ossw.emulator.control.EmulatorControl;

import java.util.List;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchSetScreenEmulatorModel {

    private List<EmulatorControl> controls;

    public WatchSetScreenEmulatorModel(List<EmulatorControl> controls) {
        this.controls = controls;
    }

    public WatchSetScreenEmulatorModel() {
    }

    public List<EmulatorControl> getControls() {
        return controls;
    }

    public void setControls(List<EmulatorControl> controls) {
        this.controls = controls;
    }
}
