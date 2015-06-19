package com.althink.android.ossw.emulator.actions;

/**
 * Created by krzysiek on 18/06/15.
 */
public class EmulatorAction {
    private int eventId;
    private int actionType;
    private int parameter;

    public EmulatorAction(int eventId, int actionType, int parameter) {
        this.eventId = eventId;
        this.actionType = actionType;
        this.parameter = parameter;
    }

    public int getEventId() {
        return eventId;
    }

    public int getActionType() {
        return actionType;
    }

    public int getParameter() {
        return parameter;
    }
}
