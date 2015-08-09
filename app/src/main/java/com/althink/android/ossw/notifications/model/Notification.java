package com.althink.android.ossw.notifications.model;

import java.util.Date;
import java.util.List;

/**
 * Created by krzysiek on 24/07/15.
 */
public interface Notification extends Comparable<Notification> {
    String getId();
    NotificationType getType();
    NotificationCategory getCategory();
    String getApplication();
    Date getDate();
    List<Operation> getOperations();
    Integer getExternalId();
    void setExternalId(Integer externalId);
    Object getNotificationObject();
}
