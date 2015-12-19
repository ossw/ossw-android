package com.althink.android.ossw.notifications.parser.api19;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;

import com.althink.android.ossw.R;
import com.althink.android.ossw.notifications.model.ListNotification;
import com.althink.android.ossw.notifications.model.Notification;
import com.althink.android.ossw.notifications.model.NotificationCategory;
import com.althink.android.ossw.notifications.model.NotificationType;
import com.althink.android.ossw.notifications.model.Operation;
import com.althink.android.ossw.notifications.model.SimpleNotification;
import com.althink.android.ossw.notifications.model.SubjectMessageItem;
import com.althink.android.ossw.notifications.parser.BaseNotificationParser;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by krzysiek on 24/07/15.
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
public class NotificationParserApi19 extends BaseNotificationParser {

    private final static String TAG = NotificationParserApi19.class.getName();

    public NotificationParserApi19(Context context) {
        super(context);
    }

    public Notification parse(String notificationId, StatusBarNotification sbn, Notification existingNotification) {

        if (isFlagSet(sbn.getNotification(), android.app.Notification.FLAG_ONGOING_EVENT) &&
                ("com.android.dialer".equals(sbn.getPackageName()) || "com.android.phone".equals(sbn.getPackageName())
                        || "com.android.incallui".equals(sbn.getPackageName())))
            return null;
        Bundle extras = sbn.getNotification().extras;
        if (extras == null) {
            return null;
        }

        String title = getExtrasString(extras, "android.title");
        String text = getExtrasString(extras, "android.text");
        NotificationCategory category = parseCategory(sbn);
        NotificationType type = getNotificationType(sbn, existingNotification);
        Date date = new Date(sbn.getNotification().when);

        if (NotificationType.INFO == type && isFlagSet(sbn.getNotification(), android.app.Notification.FLAG_ONGOING_EVENT)) {
            Log.i(TAG, "SKIP NON REMOVABLE NOTIFICATION from " + sbn.getPackageName());
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
        if ("com.android.mms".equals(sbn.getPackageName())) {
            String value = sbn.getNotification().tickerText.toString();
            String[] split = value.split("\\: ", 2);
            SubjectMessageItem subjectMessageItem = new SubjectMessageItem(split[0], split[1]);
            if (existingNotification != null) {
                LinkedList<SubjectMessageItem> items = new LinkedList<>();
                items.addAll(((ListNotification) existingNotification).getItems());
                items.add(subjectMessageItem);
                return new ListNotification(notificationId, type, category, sbn.getPackageName(), date, operations, title, items, sbn, externalId);
            } else {
                LinkedList<SubjectMessageItem> items = new LinkedList<>();
                items.add(subjectMessageItem);
                return new ListNotification(notificationId, type, category, sbn.getPackageName(), date, operations, title, items, sbn);
            }
        } else if ("com.android.dialer".equals(sbn.getPackageName()) || "com.android.phone".equals(sbn.getPackageName())) {
            addRejectCallOperationIfOptionsListEmpty(operations);
        }

        //generic processing
        if (extras.containsKey("android.textLines")) {
            return buildGenericListNotification(notificationId, sbn, extras, title, category, type, date, externalId, operations);
        }

        if (title != null && text != null) {
            return new SimpleNotification(notificationId, type, category, sbn.getPackageName(), date, operations, title, text, sbn, externalId);
        }

        return parseSimpleNotificationWithoutExtras(notificationId, type, category, date, operations, sbn, externalId);
    }

    private Notification parseSimpleNotificationWithoutExtras(String notificationId, NotificationType type, NotificationCategory category, Date date, List<Operation> operations, StatusBarNotification sbn, Integer externalId) {
        try {
            String title = null;
            String text = null;

            RemoteViews views = sbn.getNotification().bigContentView;
            if (views == null) {
                views = sbn.getNotification().contentView;
            }

            if (views == null) {
                return null;
            }

            Class<?> rvClass = views.getClass();

            Field field = rvClass.getDeclaredField("mActions");
            field.setAccessible(true);

            @SuppressWarnings("unchecked")
            ArrayList<Parcelable> actions = (ArrayList<Parcelable>) field
                    .get(views);

            for (Parcelable action : actions) {
                try {
                    // create parcel from action
                    Parcel parcel = Parcel.obtain();
                    action.writeToParcel(parcel, 0);
                    parcel.setDataPosition(0);

                    // check if is 2 / ReflectionAction
                    int tag = parcel.readInt();
                    if (tag != 2)
                        continue;

                    int viewId = parcel.readInt();

                    String methodName = parcel.readString();

                    if (methodName != null && (methodName.equals("setText") || methodName.equals("setFormat"))) {

                        if (methodName.equals("setText")) {
                            // should be 10 /
                            parcel.readInt();
                        }

                        // Store the actual string
                        CharSequence chars = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);

                        Log.d(TAG, "viewId is " + viewId);
                        Log.d(TAG, "Found value: " + chars);

                        if (chars == null)
                            continue;
                        String value = chars.toString();

                        if (viewId == BaseNotificationParser.COM_ANDROID_PHONE_LINE1) {
                            //sender when one mail / number of messages when multiple
                            title = value;
                        }

                        if (viewId == BaseNotificationParser.COM_ANDROID_PHONE_LINE2) {
                            // title + content when one mail only
                            text = value;
                        }

                        // vaspa: workaround cause viewId never matches PHONE_LINE ids
                        if (methodName.equals("setText") && text == null) {
                            text = value;
                        }

                        parcel.recycle();
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Error accessing object!", e);
                }
            }
            // vaspa: same workaround
            if (title == null)
                title = context.getString(R.string.incall_title);
            if (title != null && text != null) {
                return new SimpleNotification(notificationId, type, category, sbn.getPackageName(), date, operations, title, text, sbn, externalId);
            }
        } catch (Exception e) {
            Log.e(TAG, "Could not access mActions!", e);
        }
        return null;
    }
}