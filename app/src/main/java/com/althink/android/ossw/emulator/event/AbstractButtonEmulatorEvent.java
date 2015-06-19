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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractButtonEmulatorEvent that = (AbstractButtonEmulatorEvent) o;
        if (button != that.button) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return button != null ? button.hashCode() : 0;
    }
}
