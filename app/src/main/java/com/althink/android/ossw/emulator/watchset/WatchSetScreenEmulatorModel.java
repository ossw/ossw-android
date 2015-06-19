package com.althink.android.ossw.emulator.watchset;

import com.althink.android.ossw.emulator.actions.EmulatorAction;
import com.althink.android.ossw.emulator.control.EmulatorControl;

import java.util.List;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchSetScreenEmulatorModel {

    private List<EmulatorControl> controls;

    private List<EmulatorAction> actions;

    public WatchSetScreenEmulatorModel() {
    }

    public WatchSetScreenEmulatorModel(List<EmulatorControl> controls, List<EmulatorAction> actions) {
        this.controls = controls;
        this.actions = actions;
    }

    public List<EmulatorControl> getControls() {
        return controls;
    }

    public void setControls(List<EmulatorControl> controls) {
        this.controls = controls;
    }

    public List<EmulatorAction> getActions() {
        return actions;
    }

    public void setActions(List<EmulatorAction> actions) {
        this.actions = actions;
    }
}
