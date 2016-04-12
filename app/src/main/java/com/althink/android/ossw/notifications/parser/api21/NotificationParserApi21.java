package com.althink.android.ossw.notifications.parser.api21;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import com.althink.android.ossw.notifications.model.ListNotification;
import com.althink.android.ossw.notifications.model.Notification;
import com.althink.android.ossw.notifications.model.NotificationCategory;
import com.althink.android.ossw.notifications.model.NotificationType;
import com.althink.android.ossw.notifications.model.Operation;
import com.althink.android.ossw.notifications.model.SimpleListItem;
import com.althink.android.ossw.notifications.model.SimpleNotification;
import com.althink.android.ossw.notifications.model.SubjectMessageItem;
import com.althink.android.ossw.notifications.parser.BaseNotificationParser;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by krzysiek on 24/07/15.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class NotificationParserApi21 extends BaseNotificationParser {

    private final static String TAG = NotificationParserApi21.class.getName();

    public NotificationParserApi21(Context context) {
        super(context);
    }

    public Notification parse(String notificationId, StatusBarNotification sbn, Notification existingNotification) {

        Bundle extras = sbn.getNotification().extras;
        Log.i(TAG, "Parsing notification (API21): "+sbn.getNotification());
        if (extras == null) {
            return null;
        }

        String title = getExtrasString(extras, "android.title");
        String text = getExtrasString(extras, "android.text");
        String bigText = getExtrasString(extras, "android.bigText");
        NotificationCategory category = parseCategory(sbn);
        NotificationType type = getNotificationType(sbn, existingNotification);
        Date date = new Date(sbn.getNotification().when);

        boolean isSpam = android.app.Notification.CATEGORY_SYSTEM.equals(sbn.getNotification().category) ||
                android.app.Notification.CATEGORY_SERVICE.equals(sbn.getNotification().category) ||
                android.app.Notification.CATEGORY_STATUS.equals(sbn.getNotification().category) ||
                android.app.Notification.CATEGORY_TRANSPORT.equals(sbn.getNotification().category) ||
                android.app.Notification.CATEGORY_PROGRESS.equals(sbn.getNotification().category);
        isSpam = isSpam || (NotificationType.INFO == type && android.app.Notification.CATEGORY_ALARM.equals(sbn.getNotification().category));
        if (isSpam) {
            Log.i(TAG, "SKIP SPAM NOTIFICATION");
            return null;
        } else if (sbn.getNotification().category == null && NotificationType.INFO == type && sbn.getNotification().deleteIntent == null) {
            Log.i(TAG, "SKIP NON REMOVABLE NOTIFICATION");
            return null;
        }
        if (NotificationType.ALERT == type && !isValidAlert(sbn)) {
            Log.i(TAG, "SKIP FAKE ALERT");
            return null;
        }

        Integer externalId = resolveExternalId(existingNotification, type);

        List<Operation> operations = new LinkedList<>();
        android.app.Notification.Action[] actions = sbn.getNotification().actions;
        if (actions != null) {
            for (android.app.Notification.Action action : actions) {
                operations.add(new Operation(action.title.toString(), action.actionIntent));
            }
        }

        //custom processing
        if ("com.google.android.gm".equals(sbn.getPackageName())) {
            // skip non summary notification
            if (sbn.getNotification().deleteIntent == null) {
                Log.i(TAG, "Skip non summary notification");
                return null;
            }
        } else if ("com.google.android.apps.messaging".equals(sbn.getPackageName())) {
            String value = sbn.getNotification().tickerText.toString();
            String[] split = value.split("\\: ", 2);
            SubjectMessageItem subjectMessageItem = new SubjectMessageItem(split[0], split[1]);
            if (existingNotification != null) {
                LinkedList<SubjectMessageItem> items = new LinkedList<>();
                items.addAll(((ListNotification) existingNotification).getItems());
                items.add(subjectMessageItem);
                return new ListNotification(notificationId, type, category, sbn.getPackageName(), date, operations, "", items, sbn, externalId);
            } else {
                LinkedList<SubjectMessageItem> items = new LinkedList<>();
                items.add(subjectMessageItem);
                return new ListNotification(notificationId, type, category, sbn.getPackageName(), date, operations, "", items, sbn);
            }
        } else if ("com.android.dialer".equals(sbn.getPackageName())) {
            if (operations.isEmpty()) {
                try {
                    Resources dialerRes = context.getPackageManager().getResourcesForApplication("com.android.dialer");
                    int dismissId = dialerRes.getIdentifier("com.android.dialer:string/description_dismiss", null, null);
                    String dismiss = dialerRes.getString(dismissId);
                    operations.add(new Operation(dismiss, null));
                    Log.i(TAG, "Empty operation list - dismiss operation added");
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e(TAG, e.getMessage(), e);
                }
            }
        }

        //generic processing
        if (extras.containsKey("android.textLines")) {
            return buildGenericListNotification(notificationId, sbn, extras, title, category, type, date, externalId, operations);
        }

        if (title != null && (text != null || bigText != null)) {
            return new SimpleNotification(notificationId, type, category, sbn.getPackageName(), date, operations, title, bigText != null ? bigText : text, sbn, externalId);
        }

        return null;
    }

    protected NotificationCategory skypeNotificationType(StatusBarNotification sbn) {
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
