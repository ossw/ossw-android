package com.althink.android.ossw.notifications.model;

import android.app.PendingIntent;

/**
 * Created by krzysiek on 24/07/15.
 */
public class Operation {
    String title;
    PendingIntent intent;

    public Operation(String title, PendingIntent intent) {
        this.title = title;
        this.intent = intent;
    }

    public String getTitle() {
        return title;
    }

    public PendingIntent getIntent() {
        return intent;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "title='" + title + '\'' +
                ", intent=" + intent +
                '}';
    }
}
