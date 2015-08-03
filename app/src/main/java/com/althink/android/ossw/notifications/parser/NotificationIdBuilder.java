package com.althink.android.ossw.notifications.parser;

import android.service.notification.StatusBarNotification;

/**
 * Created by krzysiek on 25/07/15.
 */
public class NotificationIdBuilder {
    public String build(StatusBarNotification sbn) {
        return sbn.getPackageName() + ":" + sbn.getId();
    }
}
