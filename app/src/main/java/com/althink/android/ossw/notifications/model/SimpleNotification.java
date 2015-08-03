package com.althink.android.ossw.notifications.model;

import java.util.Date;
import java.util.List;

/**
 * Created by krzysiek on 24/07/15.
 */
public class SimpleNotification extends AbstractNotification {

    private String title;
    private String text;

    public SimpleNotification(String id, NotificationType type, NotificationCategory category, String application, Date date, List<Operation> operations, String title, String text) {
        super(id, type, category, application, date, operations);
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "SimpleNotification{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                "}+" + super.toString();
    }
}
