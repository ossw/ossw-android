package com.althink.android.ossw.emulator.watchset;

import com.althink.android.ossw.emulator.actions.EmulatorAction;
import com.althink.android.ossw.emulator.actions.EmulatorEventHandler;
import com.althink.android.ossw.emulator.control.EmulatorControl;
import com.althink.android.ossw.emulator.model.EmulatorModelProperty;

import java.util.List;
import java.util.Map;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchSetScreenEmulatorModel {

    private List<EmulatorControl> controls;

    private List<EmulatorEventHandler> actions;

    private Map<Integer, EmulatorModelProperty> model;

    public WatchSetScreenEmulatorModel() {
    }

    public WatchSetScreenEmulatorModel(List<EmulatorControl> controls, List<EmulatorEventHandler> actions) {
        this.controls = controls;
        this.actions = actions;
    }

    public List<EmulatorControl> getControls() {
        return controls;
    }

    public void setControls(List<EmulatorControl> controls) {
        this.controls = controls;
    }

    public List<EmulatorEventHandler> getActions() {
        return actions;
    }

    public void setActions(List<EmulatorEventHandler> actions) {
        this.actions = actions;
    }

    public Map<Integer, EmulatorModelProperty> getModel() {
        return model;
    }

    public void setModel(Map<Integer, EmulatorModelProperty> model) {
        this.model = model;
    }
}
