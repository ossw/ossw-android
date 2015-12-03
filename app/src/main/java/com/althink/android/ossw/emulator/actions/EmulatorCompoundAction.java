package com.althink.android.ossw.emulator.actions;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;

import java.util.List;

/**
 * Created by krzysiek on 22/11/15.
 */
public class EmulatorCompoundAction implements EmulatorAction {

    private List<EmulatorAction> actions;

    public EmulatorCompoundAction(List<EmulatorAction> actions) {
        this.actions = actions;
    }

    @Override
    public void performAction(EmulatorExecutionContext ctx) {
        for (EmulatorAction action : actions) {
            action.performAction(ctx);
        }
    }
}
