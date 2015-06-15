package com.althink.android.ossw.emulator.event;

/**
 * Created by krzysiek on 14/06/15.
 */
public class AbstractButtonEmulatorEvent implements EmulatorEvent {
    private EmulatorButton button;

    public AbstractButtonEmulatorEvent(EmulatorButton button) {
        this.button = button;
    }

    public EmulatorButton getButton() {
        return button;
    }
}
