package com.althink.android.ossw.notifications.model;

import java.util.Date;
import java.util.List;

/**
 * Created by krzysiek on 24/07/15.
 */
public class AbstractNotification implements Notification {

    private String id;
    private NotificationType type;
    private NotificationCategory category;
    private String application;
    private Date date;
    private Integer externalId;
    private List<Operation> operations;
    private Object notificationObject;

    public AbstractNotification(String id, NotificationType type, NotificationCategory category, String application, Date date, List<Operation> operations, Object notificationObject) {
        this.id = id;
        this.type = type;
        this.category = category;
        this.application = application;
        this.date = date;
        this.operations = operations;
        this.notificationObject = notificationObject;
    }

    public AbstractNotification(String id, NotificationType type, NotificationCategory category, String application, Date date, List<Operation> operations, Object notificationObject,  Integer externalId) {
        this.id = id;
        this.type = type;
        this.category = category;
        this.application = application;
        this.date = date;
        this.operations = operations;
        this.notificationObject = notificationObject;
        this.externalId = externalId;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public NotificationType getType() {
        return type;
    }

    public NotificationCategory getCategory() {
        return category;
    }

    public String getApplication() {
        return application;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public Date getDate() {
        return date;
    }

    public Integer getExternalId() {
        return externalId;
    }

    public void setExternalId(Integer externalId) {
        this.externalId = externalId;
    }

    public Object getNotificationObject() {
        return notificationObject;
    }

    @Override
    public String toString() {
        return "AbstractNotification{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", category=" + category +
                ", application='" + application + '\'' +
                ", date=" + date +
                ", externalId=" + externalId +
                ", operations=" + operations +
                '}';
    }

    @Override
    public int compareTo(Notification another) {
        return -date.compareTo(another.getDate());
    }
}
