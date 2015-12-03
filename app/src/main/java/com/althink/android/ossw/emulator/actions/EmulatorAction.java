package com.althink.android.ossw.emulator.actions;

import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;

/**
 * Created by krzysiek on 18/06/15.
 */
public interface EmulatorAction {

    void performAction(EmulatorExecutionContext ctx);
}
