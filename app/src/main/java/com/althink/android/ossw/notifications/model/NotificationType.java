package com.althink.android.ossw.notifications.model;

/**
 * Created by krzysiek on 24/07/15.
 */
public enum NotificationType {
    ALERT(1), INFO(2), UPDATE(3);

    private int value;

    NotificationType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
