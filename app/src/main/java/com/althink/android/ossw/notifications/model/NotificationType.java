package com.althink.android.ossw.notifications.model;

/**
 * Created by krzysiek on 24/07/15.
 */
public enum NotificationType {
    ALERT(1), INFO(2), UPDATE(3), DIALOG_SELECT(4), DIALOG_OPTIONS(5), DIALOG_CLOSE(0xff) ;

    private int value;

    NotificationType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
