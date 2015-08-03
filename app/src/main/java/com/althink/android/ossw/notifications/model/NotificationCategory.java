package com.althink.android.ossw.notifications.model;

/**
 * Created by krzysiek on 24/07/15.
 */
public enum NotificationCategory {
    INCOMING_CALL(1), MESSAGE(2), EMAIL(3), SOCIAL(4), ALARM(5), OTHER(255);

    private int value;

    NotificationCategory(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
