package com.althink.android.ossw.notifications.model;

import java.util.Date;
import java.util.List;

/**
 * Created by krzysiek on 24/07/15.
 */
public class SimpleNotification extends AbstractNotification {

    private String title;
    private String text;

    public SimpleNotification(String id, NotificationType type, NotificationCategory category, String application, Date date, List<Operation> operations, String title, String text, Object notificationObject) {
        super(id, type, category, application, date, operations, notificationObject);
        this.title = title;
        this.text = text;
    }

    public SimpleNotification(String id, NotificationType type, NotificationCategory category, String application, Date date, List<Operation> operations, String title, String text, Object notificationObject, Integer externalId) {
        super(id, type, category, application, date, operations, notificationObject, externalId);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleNotification that = (SimpleNotification) o;

        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
