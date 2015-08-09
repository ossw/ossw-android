package com.althink.android.ossw.notifications;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.widget.RemoteViews;

import com.althink.android.ossw.notifications.message.ListNotificationMessageBuilder;
import com.althink.android.ossw.notifications.message.NotificationMessageBuilder;
import com.althink.android.ossw.notifications.message.NotificationSummaryMessageBuilder;
import com.althink.android.ossw.notifications.message.SimpleNotificationMessageBuilder;
import com.althink.android.ossw.notifications.model.ListNotification;
import com.althink.android.ossw.notifications.model.Notification;
import com.althink.android.ossw.notifications.model.NotificationType;
import com.althink.android.ossw.notifications.model.SimpleNotification;
import com.althink.android.ossw.notifications.parser.NotificationIdBuilder;
import com.althink.android.ossw.notifications.parser.api19.NotificationParserApi19;
import com.althink.android.ossw.service.OsswService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by krzysiek on 05/06/15.
 */
public class NotificationListener extends NotificationListenerService {

    private String TAG = this.getClass().getSimpleName();

    private AlertNotificationHandler alertHandler;

    private int nextNotificationId = 1;

    private static boolean isNotificationAccessEnabled = false;

    private static NotificationListener instance;

//    public static int LINE_1;
//    public static int ICON;
//    public static int TITLE;
//    public static int BIG_TEXT;
//    public static int TEXT;
//    public static int BIG_PIC;
//    public static int INBOX_TEXT_0;
//    public static int INBOX_TEXT_1;
//    public static int INBOX_TEXT_2;
//    public static int INBOX_TEXT_3;
//    public static int INBOX_TEXT_4;
//    public static int INBOX_TEXT_5;
//    public static int INBOX_TEXT_6;
//    public static int INBOX_MORE;
//    public static int INFO;
//    public static int TIME;

    Handler handler = new Handler(Looper.getMainLooper());
    Map<String, Notification> notifications = new HashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();

        alertHandler = new AlertNotificationHandler();

        notifications = new HashMap<>();

        instance = this;
//        Resources resources = getResources();
//        LINE_1 = resources.getIdentifier("android:id/line1", null, null);
//        ICON = resources.getIdentifier("android:id/icon", null, null);
//        TITLE = resources.getIdentifier("android:id/title", null, null);
//        BIG_TEXT = resources.getIdentifier("android:id/big_text", null, null);
//        TEXT = resources.getIdentifier("android:id/text", null, null);
//        TIME = resources.getIdentifier("android:id/time", null, null);
//        BIG_PIC = resources.getIdentifier("android:id/big_picture", null, null);
//        INBOX_TEXT_0 = resources.getIdentifier("android:id/inbox_text0", null, null);
//        INBOX_TEXT_1 = resources.getIdentifier("android:id/inbox_text1", null, null);
//        INBOX_TEXT_2 = resources.getIdentifier("android:id/inbox_text2", null, null);
//        INBOX_TEXT_3 = resources.getIdentifier("android:id/inbox_text3", null, null);
//        INBOX_TEXT_4 = resources.getIdentifier("android:id/inbox_text4", null, null);
//        INBOX_TEXT_5 = resources.getIdentifier("android:id/inbox_text5", null, null);
//        INBOX_TEXT_6 = resources.getIdentifier("android:id/inbox_text6", null, null);
//        INBOX_MORE = resources.getIdentifier("android:id/inbox_more", null, null);
//        INFO = getResources().getIdentifier("android:id/info", null, null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
    }

    @Override
    public IBinder onBind(Intent mIntent) {
        IBinder mIBinder = super.onBind(mIntent);
        isNotificationAccessEnabled = true;
        return mIBinder;
    }

    @Override
    public boolean onUnbind(Intent mIntent) {
        boolean mOnUnbind = super.onUnbind(mIntent);
        isNotificationAccessEnabled = false;
        return mOnUnbind;
    }

    @Override
    public void onNotificationPosted(final StatusBarNotification sbn) {

        Log.i(TAG, "**********  onNotificationPosted");
        Log.i(TAG, "ID :" + sbn.getId() + " <> " + sbn.getNotification().tickerText + " <> " + sbn.getPackageName() + " <> " + sbn.getNotification().priority + " <> " + sbn.getNotification().flags);

        RemoteViews bigContentView = sbn.getNotification().bigContentView;


        Log.d(TAG, "Incoming notification!");
        Log.d(TAG, "Ticker: " + sbn.getNotification().tickerText);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Bundle extras = sbn.getNotification().extras;
            if (extras != null) {
                for (String key : extras.keySet()) {
                    Log.d(TAG, "EXTRA: " + key + ": " + extraToString(extras.get(key)));
                }
            }
        }

        String notificationId = new NotificationIdBuilder().build(sbn);
        Notification existingNotification = notifications.get(notificationId);
        boolean isUpdate = existingNotification != null;

        Notification notification = new NotificationParserApi19(getApplicationContext()).parse(notificationId, sbn, existingNotification);

        if (notification != null) {
            if (notification.getExternalId() == null) {
                notification.setExternalId(getNextNotificationId());
            }

            Log.i(TAG, "Successfully parsed message:");
            Log.i(TAG, notification.toString());

            notifications.put(notification.getId(), notification);

            if (NotificationType.ALERT == notification.getType() && !isUpdate) {
                alertHandler.handleNotificationStart(notification);
            }
            if (NotificationType.INFO == notification.getType()) {
                if (isUpdate && !hasNewElements(notification, existingNotification)) {
                    updateNotificationList(false, 0);
                } else {
                    int vibration_pattern = (6 << 28) | (70 << 16) | (44 << (16 - 6));
                    updateNotificationList(true, vibration_pattern);
                }
            }
        }
        printNotifications();

    }

    private boolean hasNewElements(Notification newNotification, Notification existingNotification) {
        if (newNotification instanceof SimpleNotification) {
            return false;
        }
        if (newNotification instanceof ListNotification && existingNotification instanceof ListNotification) {
            return ((ListNotification) newNotification).getItems().size() > ((ListNotification) existingNotification).getItems().size();
        }
        return true;
    }

    private void updateNotificationList(boolean notify, int vibration_pattern) {
        Log.i(TAG, "UPDATE NOTIFICATIONS");
        NotificationType type = notify ? NotificationType.INFO : NotificationType.UPDATE;
        List<Notification> notifyList = getAllInfoNotifications();

        OsswService osswService = OsswService.getInstance();
        if (osswService == null) {
            return;
        }
        int messagesNo = countMessages(notifyList);
        if (messagesNo == 1) {
            // if new notification and only one then show notification content
            Notification onlyNotification = notifyList.get(0);
            if (onlyNotification instanceof SimpleNotification) {
                NotificationMessageBuilder builder = new SimpleNotificationMessageBuilder((SimpleNotification) onlyNotification, 0);
                osswService.uploadNotification(onlyNotification.getExternalId(), type, builder.build(), vibration_pattern, 1200, null);
            } else if (onlyNotification instanceof ListNotification) {
                NotificationMessageBuilder builder = new ListNotificationMessageBuilder((ListNotification) onlyNotification, 0);
                osswService.uploadNotification(onlyNotification.getExternalId(), type, builder.build(), vibration_pattern, 1200, null);
            }
        } else if (messagesNo > 0) {
            NotificationMessageBuilder builder = new NotificationSummaryMessageBuilder(messagesNo);
            osswService.uploadNotification(0, type, builder.build(), vibration_pattern, 1200, null);
        } else {
            closeNotifications();
        }
    }

    private int countMessages(List<Notification> notifications) {
        int count = 0;
        for (Notification notification : notifications) {
            if (notification instanceof ListNotification) {
                count += ((ListNotification) notification).getItems().size();
            } else {
                count++;
            }
        }
        return count;
    }

    private void closeNotifications() {
        OsswService osswService = OsswService.getInstance();
        if (osswService == null) {
            return;
        }
        osswService.uploadNotification(0, NotificationType.UPDATE, new byte[0], 0, 0, null);
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        Log.i(TAG, "********** onNOtificationRemoved");
        Log.i(TAG, "ID :" + sbn.getId() + "<>" + sbn.getNotification().tickerText + "<>" + sbn.getPackageName());
        //Intent i = new  Intent("com.kpbird.nlsexample.NOTIFICATION_LISTENER_EXAMPLE");
        //i.putExtra("notification_event","onNotificationRemoved :" + sbn.getPackageName() + "n");

        String notificationId = new NotificationIdBuilder().build(sbn);
        Notification removedNotification = notifications.remove(notificationId);

        if (removedNotification != null) {
            if (NotificationType.ALERT == removedNotification.getType()) {
                alertHandler.handleNotificationStop(notificationId);
            } else {
                updateNotificationList(false, 0);
            }
        }
        printNotifications();
        //sendBroadcast(i);

    }

    private List<Notification> getAllInfoNotifications() {


        ArrayList<Notification> list = new ArrayList<Notification>();
        for (Notification notification : this.notifications.values()) {
            if (notification.getType() == NotificationType.INFO) {
                list.add(notification);
            }
        }
        Collections.sort(list);
        return list;
    }

    private void printNotifications() {
        Log.i(TAG, "Notifications list:");
        ArrayList<Notification> list = new ArrayList<Notification>(notifications.values());
        Collections.sort(list);
        for (Notification notification : list) {
            Log.i(TAG, notification.toString());
        }
    }

    private String extraToString(Object o) {
        if (o == null) {
            return null;
        } else if (o instanceof Bundle) {
            Set<String> keySet = ((Bundle) o).keySet();
            StringBuilder sb = new StringBuilder();
            for (String key : keySet) {
                sb.append(key).append(": ").append(((Bundle) o).get(key)).append(", ");
            }
            return sb.toString();
        } else if (o instanceof Object[]) {
            return Arrays.toString((Object[]) o);
        } else if (o instanceof int[]) {
            return Arrays.toString((int[]) o);
        } else if (o instanceof long[]) {
            return Arrays.toString((long[]) o);
        } else if (o instanceof float[]) {
            return Arrays.toString((float[]) o);
        } else if (o instanceof double[]) {
            return Arrays.toString((double[]) o);
        } else if (o instanceof char[]) {
            return Arrays.toString((char[]) o);
        } else if (o instanceof byte[]) {
            return Arrays.toString((byte[]) o);
        }
        return o.toString();
    }

    private int getNextNotificationId() {
        int notificationId = nextNotificationId;

        nextNotificationId++;
        if (nextNotificationId > 65535) {
            nextNotificationId = 1;
        }

        return notificationId;
    }

    public static boolean isNotificationAccessEnabled() {
        return isNotificationAccessEnabled;
    }

    public static NotificationListener getInstance() {
        return instance;
    }

    public void sendNextNotification(int lastNotificationId) {
        List<Notification> notificationList = getSortedNotificationsList();
        if (notificationList == null) return;
        Notification lastNotification = null;
        Notification nextNotification = null;
        for (Notification n : notificationList) {
            if (lastNotification != null) {
                nextNotification = n;
                break;
            }
            if (n.getExternalId() == lastNotificationId) {
                lastNotification = n;
            }
        }
        if (lastNotification != null) {
            dismissNotification(lastNotification);
        }
        if (nextNotification == null) {
            notificationList = getSortedNotificationsList();
            if (notificationList.size() == 0) {
                closeNotifications();
                return;
            }
            nextNotification = notificationList.get(0);
        }
        sendNotificationPart(nextNotification.getExternalId(), 0);
    }

    private void dismissNotification(Notification lastNotification) {
        notifications.remove(lastNotification.getId());
        StatusBarNotification sbn = (StatusBarNotification) lastNotification.getNotificationObject();
        cancelNotification(sbn.getPackageName(), sbn.getTag(), sbn.getId());
    }

    private List<Notification> getSortedNotificationsList() {
        List<Notification> notificationList = new LinkedList(notifications.values());

        Collections.sort(notificationList, new Comparator<Notification>() {
            @Override
            public int compare(Notification lhs, Notification rhs) {
                return lhs.getDate().compareTo(rhs.getDate());
            }
        });
        return notificationList;
    }

    public void sendNotificationPart(int notificationId, int page) {
        OsswService osswService = OsswService.getInstance();
        if (osswService == null) {
            return;
        }
        for (Notification n : notifications.values()) {
            if (n.getExternalId() == notificationId) {
                if (n instanceof SimpleNotification) {
                    NotificationMessageBuilder builder = new SimpleNotificationMessageBuilder((SimpleNotification) n, page);
                    osswService.uploadNotification(n.getExternalId(), NotificationType.UPDATE, builder.build(), 0, 0, null);
                } else if (n instanceof ListNotification) {
                    NotificationMessageBuilder builder = new ListNotificationMessageBuilder((ListNotification) n, page);
                    osswService.uploadNotification(n.getExternalId(), NotificationType.UPDATE, builder.build(), 0, 0, null);
                }
                break;
            }
        }
    }

    public void sendFirstNotification() {
        List<Notification> notificationList = getSortedNotificationsList();
        if (notificationList.size() == 0) {
            return;
        }
        sendNotificationPart(notificationList.get(0).getExternalId(), 0);
    }
}