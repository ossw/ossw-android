package com.althink.android.ossw.emulator.actions;

/**
 * Created by krzysiek on 22/11/15.
 */
public class EmulatorEventHandler {
    private int eventId;
    private EmulatorAction action;

    public EmulatorEventHandler(int eventId, EmulatorAction action) {
        this.action = action;
        this.eventId = eventId;
    }

    public EmulatorAction getAction() {
        return action;
    }

    public int getEventId() {
        return eventId;
    }
}
