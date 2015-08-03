package com.althink.android.ossw.notifications.parser.api19;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.SpannableString;
import android.util.Log;

import com.althink.android.ossw.notifications.model.ListNotification;
import com.althink.android.ossw.notifications.model.Notification;
import com.althink.android.ossw.notifications.model.NotificationCategory;
import com.althink.android.ossw.notifications.model.NotificationType;
import com.althink.android.ossw.notifications.model.Operation;
import com.althink.android.ossw.notifications.model.SimpleListItem;
import com.althink.android.ossw.notifications.model.SimpleNotification;
import com.althink.android.ossw.notifications.model.SubjectMessageItem;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by krzysiek on 24/07/15.
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
public class NotificationParserApi19 {

    private final static String TAG = NotificationParserApi19.class.getName();

    private Context context;

    public NotificationParserApi19(Context context) {
        this.context = context;
    }

    public Notification parse(String notificationId, StatusBarNotification sbn, Notification existingNotification) {

        Bundle extras = sbn.getNotification().extras;
        if (extras == null) {
            return null;
        }

        String title = getExtrasString(extras, "android.title");
        String text = getExtrasString(extras, "android.text");
        NotificationCategory category = parseCategory(sbn);
        NotificationType type = sbn.getNotification().priority > 1 ? NotificationType.ALERT : NotificationType.INFO;
        Date date = new Date(sbn.getNotification().when);

        if (NotificationType.INFO == type && sbn.getNotification().deleteIntent == null) {
            Log.i(TAG, "SKIP NON REMOVABLE NOTIFICATION");
            return null;
        }
        if (NotificationType.ALERT == type && !isValidAlert(sbn)) {
            Log.i(TAG, "SKIP FAKE ALERT");
            return null;
        }

        List<Operation> operations = new LinkedList<>();
        android.app.Notification.Action[] actions = sbn.getNotification().actions;
        if (actions != null) {
            for (android.app.Notification.Action action : actions) {
                operations.add(new Operation(action.title.toString(), action.actionIntent));
            }
        }

        //custom processing
        if ("com.android.mms".equals(sbn.getPackageName())) {
            String value = sbn.getNotification().tickerText.toString();
            String[] split = value.split("\\: ", 2);
            SubjectMessageItem subjectMessageItem = new SubjectMessageItem(split[0], split[1]);
            if (existingNotification != null) {
                ((ListNotification) existingNotification).setTitle(title);
                ((ListNotification) existingNotification).getItems().add(subjectMessageItem);
                return existingNotification;
            } else {
                LinkedList<SubjectMessageItem> items = new LinkedList<>();
                items.add(subjectMessageItem);
                return new ListNotification(notificationId, type, category, sbn.getPackageName(), date, operations, title, items);
            }
        }
        else if ("com.android.dialer".equals(sbn.getPackageName())) {
            if (operations.isEmpty()) {
                try {
                    Resources dialerRes = context.getPackageManager().getResourcesForApplication("com.android.dialer");
                    int dismissId = dialerRes.getIdentifier("com.android.dialer:string/description_dismiss", null, null);
                    String dismiss = dialerRes.getString(dismissId);
                    operations.add(new Operation(dismiss, null));
                } catch (PackageManager.NameNotFoundException e) {
                }
            }
        }

        //generic processing
        if (extras.containsKey("android.textLines")) {
            List items = new LinkedList();
            Object[] lines = (Object[]) extras.get("android.textLines");
            for (Object line : lines) {
                items.add(new SimpleListItem(line.toString()));
            }
            return new ListNotification(notificationId, type, category, sbn.getPackageName(), date, operations, title, items);
        }

        if (title != null && text != null) {
            return new SimpleNotification(notificationId, type, category, sbn.getPackageName(), date, operations, title, text);
        }

        return null;
    }

    private boolean isValidAlert(StatusBarNotification sbn) {
        if (isFlagSet(sbn.getNotification(), android.app.Notification.FLAG_NO_CLEAR) &&
                isFlagSet(sbn.getNotification(), android.app.Notification.FLAG_FOREGROUND_SERVICE) &&
                isFlagSet(sbn.getNotification(), android.app.Notification.FLAG_ONGOING_EVENT)) {
            return true;
        }
        if (sbn.getNotification().fullScreenIntent != null) {
            return true;
        }
        return false;
    }

    public boolean isFlagSet(android.app.Notification notification, int flag) {
        return (notification.flags & flag) != 0;
    }

    private String getExtrasString(Bundle extras, String key) {
        Object value = extras.get(key);
        if (value instanceof String) {
            return (String) value;
        }
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    private NotificationCategory parseCategory(StatusBarNotification sbn) {

        switch (sbn.getPackageName()) {
            case "com.android.dialer":
            case "com.android.server.telecom":
                return NotificationCategory.INCOMING_CALL;
            case "com.android.email":
            case "com.google.android.gm":
                return NotificationCategory.EMAIL;
            case "com.android.mms":
                return NotificationCategory.MESSAGE;
            case "com.android.deskclock":
            case "com.google.android.deskclock":
            case "ch.bitspin.timely":
                return NotificationCategory.ALARM;
            case "com.skype.raider":
                return skypeNotificationType(sbn);
        }

        return NotificationCategory.OTHER;
/*
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return NotificationCategory.OTHER;
        }
        String category = sbn.getNotification().category;
        if (category == null) {
            return NotificationCategory.OTHER;
        }
        switch (category) {
            case android.app.Notification.CATEGORY_EMAIL:
                return NotificationCategory.EMAIL;
            case android.app.Notification.CATEGORY_CALL:
                return NotificationCategory.INCOMING_CALL;
            case android.app.Notification.CATEGORY_SOCIAL:
                return NotificationCategory.SOCIAL;
            case android.app.Notification.CATEGORY_MESSAGE:
                return NotificationCategory.MESSAGE;
            case android.app.Notification.CATEGORY_ALARM:
                return NotificationCategory.ALARM;
            default:
                return NotificationCategory.OTHER;
        }*/
    }

    private NotificationCategory skypeNotificationType(StatusBarNotification sbn) {
        if (sbn.getNotification().extras.containsKey("android.support.groupKey")) {
            String key = getExtrasString(sbn.getNotification().extras, "android.support.groupKey");
            if ("CHAT_MESSAGE".equals(key)) {
                return NotificationCategory.MESSAGE;
            }
            return NotificationCategory.OTHER;
        }
        return NotificationCategory.INCOMING_CALL;
    }
}
