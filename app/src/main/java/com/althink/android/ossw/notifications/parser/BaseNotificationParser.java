package com.althink.android.ossw.notifications.parser;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;

import com.althink.android.ossw.notifications.model.ListNotification;
import com.althink.android.ossw.notifications.model.Notification;
import com.althink.android.ossw.notifications.model.NotificationCategory;
import com.althink.android.ossw.notifications.model.NotificationType;
import com.althink.android.ossw.notifications.model.Operation;
import com.althink.android.ossw.notifications.model.SimpleListItem;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by krzysiek on 06/11/15.
 */
public class BaseNotificationParser {

    protected Context context;

    public static int LINE_1;
    public static int ICON;
    public static int TITLE;
    public static int BIG_TEXT;
    public static int TEXT;
    public static int BIG_PIC;
    public static int INBOX_TEXT_0;
    public static int INBOX_TEXT_1;
    public static int INBOX_TEXT_2;
    public static int INBOX_TEXT_3;
    public static int INBOX_TEXT_4;
    public static int INBOX_TEXT_5;
    public static int INBOX_TEXT_6;
    public static int INBOX_MORE;
    public static int INFO;
    public static int TIME;

    public static int COM_ANDROID_PHONE_LINE1;
    public static int COM_ANDROID_PHONE_LINE2;

    public BaseNotificationParser(Context context) {
        this.context = context;

        Resources resources = context.getResources();
        LINE_1 = resources.getIdentifier("android:id/line1", null, null);
        ICON = resources.getIdentifier("android:id/icon", null, null);
        TITLE = resources.getIdentifier("android:id/title", null, null);
        BIG_TEXT = resources.getIdentifier("android:id/big_text", null, null);
        TEXT = resources.getIdentifier("android:id/text", null, null);
        TIME = resources.getIdentifier("android:id/time", null, null);
        BIG_PIC = resources.getIdentifier("android:id/big_picture", null, null);
        INBOX_TEXT_0 = resources.getIdentifier("android:id/inbox_text0", null, null);
        INBOX_TEXT_1 = resources.getIdentifier("android:id/inbox_text1", null, null);
        INBOX_TEXT_2 = resources.getIdentifier("android:id/inbox_text2", null, null);
        INBOX_TEXT_3 = resources.getIdentifier("android:id/inbox_text3", null, null);
        INBOX_TEXT_4 = resources.getIdentifier("android:id/inbox_text4", null, null);
        INBOX_TEXT_5 = resources.getIdentifier("android:id/inbox_text5", null, null);
        INBOX_TEXT_6 = resources.getIdentifier("android:id/inbox_text6", null, null);
        INBOX_MORE = resources.getIdentifier("android:id/inbox_more", null, null);
        INFO = resources.getIdentifier("android:id/info", null, null);

        try {
            Resources phoneRes = context.getPackageManager().getResourcesForApplication("com.android.phone");
            COM_ANDROID_PHONE_LINE1 = phoneRes.getIdentifier("com.android.phone:id/text1", null, null);
            COM_ANDROID_PHONE_LINE2 = phoneRes.getIdentifier("com.android.phone:id/text2", null, null);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected boolean isValidAlert(StatusBarNotification sbn) {
        if ("com.android.dialer".equals(sbn.getPackageName()) || "com.android.phone".equals(sbn.getPackageName())) {
            return true;
        }
        if (hasActions(sbn)) {
            return true;
        }
        if (isFlagSet(sbn.getNotification(), android.app.Notification.FLAG_NO_CLEAR) &&
                isFlagSet(sbn.getNotification(), android.app.Notification.FLAG_FOREGROUND_SERVICE) &&
                isFlagSet(sbn.getNotification(), android.app.Notification.FLAG_ONGOING_EVENT)) {
            return true;
        }
        return false;
    }

    @TargetApi(19)
    private boolean hasActions(StatusBarNotification sbn) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (sbn.getNotification().actions == null)
                return false;
            if (sbn.getNotification().actions.length > 0) {
                return true;
            }
        }
        return false;
    }


    private boolean isFlagSet(android.app.Notification notification, int flag) {
        return (notification.flags & flag) != 0;
    }

    protected NotificationCategory parseCategory(StatusBarNotification sbn) {

        switch (sbn.getPackageName()) {
            case "com.android.dialer":
            case "com.android.phone":
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
            case "com.htc.android.worldclock":
                return NotificationCategory.ALARM;
            case "com.skype.raider":
                return skypeNotificationType(sbn);
        }
        return buildFromCategory(sbn);
    }

    @TargetApi(21)
    private NotificationCategory buildFromCategory(StatusBarNotification sbn) {
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
        }
    }

    protected NotificationCategory skypeNotificationType(StatusBarNotification sbn) {
        return NotificationCategory.OTHER;
    }

    protected String getExtrasString(Bundle extras, String key) {
        Object value = extras.get(key);
        if (value instanceof String) {
            return (String) value;
        }
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    protected NotificationType getNotificationType(StatusBarNotification sbn, Notification existingNotification) {
        if ("com.android.dialer".equals(sbn.getPackageName()) && existingNotification != null) {
            return sbn.getNotification().priority > 0 ? NotificationType.ALERT : NotificationType.INFO;
        }
        if ("com.htc.android.worldclock".equals(sbn.getPackageName()) && hasActions(sbn)) {
            return NotificationType.ALERT;
        }
        if (sbn.getNotification().fullScreenIntent == null) {
            return NotificationType.INFO;
        }
        return sbn.getNotification().priority > 1 ? NotificationType.ALERT : NotificationType.INFO;
    }

    protected Integer resolveExternalId(Notification existingNotification, NotificationType type) {
        if (existingNotification == null) {
            return null;
        }
        if ("com.skype.raider".equals(existingNotification.getApplication())) {
            return null;
        }
        return (existingNotification != null && existingNotification.getType() == type) ? existingNotification.getExternalId() : null;
    }

    protected Notification buildGenericListNotification(String notificationId, StatusBarNotification sbn, Bundle extras, String title, NotificationCategory category, NotificationType type, Date date, Integer externalId, List<Operation> operations) {
        List items = new LinkedList();
        Object[] lines = (Object[]) extras.get("android.textLines");
        for (Object line : lines) {
            items.add(new SimpleListItem(line.toString()));
        }
        return new ListNotification(notificationId, type, category, sbn.getPackageName(), date, operations, title, items, sbn, externalId);
    }

    protected void addRejectCallOperationIfOptionsListEmpty(List<Operation> operations) {
        if (operations.isEmpty()) {
            try {
                Resources dialerRes = context.getPackageManager().getResourcesForApplication("com.android.dialer");
                if (dialerRes != null) {
                    int dismissId = dialerRes.getIdentifier("com.android.dialer:string/description_dismiss", null, null);
                    String dismiss = dialerRes.getString(dismissId);
                    operations.add(new Operation(dismiss, null));
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Resources dialerRes = context.getPackageManager().getResourcesForApplication("com.android.phone");
                if (dialerRes != null) {
                    int dismissId = dialerRes.getIdentifier("com.android.phone:string/description_target_decline", null, null);
                    String dismiss = dialerRes.getString(dismissId);
                    operations.add(new Operation(dismiss, null));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
