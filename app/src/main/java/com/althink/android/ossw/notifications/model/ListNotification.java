package com.althink.android.ossw.notifications.model;

import java.util.Date;
import java.util.List;

/**
 * Created by krzysiek on 25/07/15.
 */
public class ListNotification extends AbstractNotification {
    private String title;
    private List items;

    public ListNotification(String id, NotificationType type, NotificationCategory category, String application, Date date, List<Operation> operations, String title, List items, Object notificationObject) {
        super(id, type, category, application, date, operations, notificationObject);
        this.title = title;
        this.items = items;
    }

    public ListNotification(String id, NotificationType type, NotificationCategory category, String application, Date date, List<Operation> operations, String title, List items, Object notificationObject, Integer externalId) {
        super(id, type, category, application, date, operations, notificationObject, externalId);
        this.title = title;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "ListNotification{" +
                "title='" + title + '\'' +
                ", items=" + items +
                "}+" + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNotification that = (ListNotification) o;

        if (items != null ? !items.equals(that.items) : that.items != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
    }
}
