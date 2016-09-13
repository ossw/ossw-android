package com.althink.android.ossw.notifications;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import com.althink.android.ossw.notifications.message.ListNotificationMessageBuilder;
import com.althink.android.ossw.notifications.message.NotificationMessageBuilder;
import com.althink.android.ossw.notifications.message.NotificationSummaryMessageBuilder;
import com.althink.android.ossw.notifications.message.SimpleNotificationMessageBuilder;
import com.althink.android.ossw.notifications.model.ListNotification;
import com.althink.android.ossw.notifications.model.Notification;
import com.althink.android.ossw.notifications.model.NotificationType;
import com.althink.android.ossw.notifications.model.SimpleNotification;
import com.althink.android.ossw.notifications.parser.BaseNotificationParser;
import com.althink.android.ossw.notifications.parser.NotificationIdBuilder;
import com.althink.android.ossw.notifications.parser.api19.NotificationParserApi19;
import com.althink.android.ossw.notifications.parser.api21.NotificationParserApi21;
import com.althink.android.ossw.service.CallReceiver;
import com.althink.android.ossw.service.OsswService;
import com.althink.android.ossw.settings.SettingsActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NotificationListener extends NotificationListenerService {

    private String TAG = this.getClass().getSimpleName();

    private AlertNotificationHandler alertHandler;

    private int nextNotificationId = 1;

    private static NotificationListener instance;

    Map<String, Notification> notifications = new HashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();

        alertHandler = new AlertNotificationHandler();

        notifications = new HashMap<>();

        instance = this;
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
        Log.d(TAG, "onDestroy");
    }

    @Override
    public IBinder onBind(Intent mIntent) {
        IBinder mIBinder = super.onBind(mIntent);
        Log.d(TAG, "onBind");
        return mIBinder;
    }

    @Override
    public boolean onUnbind(Intent mIntent) {
        boolean mOnUnbind = super.onUnbind(mIntent);
        Log.d(TAG, "onUnbind");
        return mOnUnbind;
    }

    @Override
    public void onNotificationPosted(final StatusBarNotification sbn) {

        //Log.i(TAG, "**********  onNotificationPosted");
        Log.i(TAG, "ID :" + sbn.getId() + " <> " + sbn.getNotification().tickerText + " <> " + sbn.getPackageName() + " <> " + sbn.getNotification().priority + " <> " + sbn.getNotification().flags);

//        RemoteViews bigContentView = sbn.getNotification().bigContentView;


        //Log.d(TAG, "Incoming notification!");
        // Log.d(TAG, "Ticker: " + sbn.getNotification().tickerText);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Bundle extras = sbn.getNotification().extras;
//            if (extras != null) {
//                for (String key : extras.keySet()) {
//                    Log.d(TAG, "EXTRA: " + key + ": " + extraToString(extras.get(key)));
//                }
//            }
//        }

        String notificationId = new NotificationIdBuilder().build(sbn);
        Notification existingNotification = notifications.get(notificationId);

        Notification notification = parseNotification(sbn, notificationId, existingNotification);

        if (notification != null) {

            boolean isUpdate = existingNotification != null && existingNotification.getExternalId() != null && existingNotification.getExternalId().equals(notification.getExternalId());

            if (isUpdate && !hasChanged(notification, existingNotification)) {
                Log.i(TAG, "Nothing has changed in notification, SKIP IT");
                return;
            }

            if (notification.getExternalId() == null) {
                notification.setExternalId(getNextNotificationId());
            }

            Log.d(TAG, "Successfully parsed message: "+notification.toString());

            notifications.put(notification.getId(), notification);

            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            if (NotificationType.ALERT == notification.getType()) {
                if (sharedPref.getBoolean("alert_notifications", true))
                    alertHandler.handleNotificationStart(notification);
            }
            if (NotificationType.INFO == notification.getType()) {
                if (sharedPref.getBoolean("notifications", true))
                    if (isUpdate && !hasNewElements(notification, existingNotification)) {
                        updateNotificationList(false, 0, 0, false);
                    } else {
                        sendNotifications();
                    }
            }
        }
        printNotifications();
    }

    public void sendNotifications() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean vibrate = sharedPref.getBoolean(SettingsActivity.NOTIFICATION_VIBRATION_PREFIX, true);
        int vibrationPattern = 0;
        int vibrationLength = 0;
        if (vibrate) {
            vibrationPattern = VibrationPatternBuilder.getNotificationVibrationPattern(this);
            vibrationLength = VibrationPatternBuilder.getNotificationVibrationLength(this);
        }
        updateNotificationList(true, vibrationPattern, vibrationLength, false);
    }

    private boolean hasChanged(Notification notification, Notification existingNotification) {
        return !notification.equals(existingNotification);
    }

    private boolean skipNotification(StatusBarNotification sbn) {
        String pName = sbn.getPackageName();
        // allow some self-created notifications
        int nId = sbn.getId();
        if (getPackageName().equals(pName) && (nId == OsswService.TEST_NOTIFICATION_ID
                || nId == OsswService.TEST_ALERT_ID || nId == CallReceiver.CALL_NOTIFICATION_ID))
            return false;

        if ("com.android.dialer".equals(pName) || "com.android.phone".equals(pName)
                || "com.sec.android.app.clockpackage".equals(pName)) {
            return false;
        }

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Set<String> selections = sharedPref.getStringSet("notification_applications", null);
        if (selections == null) {
            Log.d(TAG, "Empty notification filter configuration");
            return true;
        }
//        Log.i(TAG, "Notifications filter: " + sbn.getPackageName() + " in " + selections.toString());
        if (selections.contains(sbn.getPackageName())) {
//            Log.i(TAG, "Notification are enabled for given app");
            return false;
        }
        Log.d(TAG, "Notification from '" + sbn.getPackageName() + "' is not in the list, it will be skipped");
        return true;
    }

    private Notification parseNotification(StatusBarNotification sbn, String notificationId, Notification existingNotification) {
        if (skipNotification(sbn)) {
            return null;
        }
        if (BaseNotificationParser.isFlagSet(sbn.getNotification(), android.app.Notification.FLAG_ONGOING_EVENT) &&
                ("com.android.dialer".equals(sbn.getPackageName()) || "com.android.phone".equals(sbn.getPackageName())
                        || "com.android.incallui".equals(sbn.getPackageName())))
            return null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return new NotificationParserApi21(getApplicationContext()).parse(notificationId, sbn, existingNotification);
        } else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            // WARNING: following check blocks incoming call notifications from the system app
            // in KitKat a special notification should be generated
            return new NotificationParserApi19(getApplicationContext()).parse(notificationId, sbn, existingNotification);
        }
        return null;
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

    private void updateNotificationList(boolean notify, int vibrationPattern, int vibrationLength, boolean forceSummary) {
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
                osswService.uploadNotification(onlyNotification.getExternalId(), type, builder.build(), vibrationPattern, vibrationLength, null);
            } else if (onlyNotification instanceof ListNotification) {
                NotificationMessageBuilder builder = new ListNotificationMessageBuilder((ListNotification) onlyNotification, 0);
                osswService.uploadNotification(onlyNotification.getExternalId(), type, builder.build(), vibrationPattern, vibrationLength, null);
            }
        } else if (messagesNo > 0) {
            NotificationMessageBuilder builder = new NotificationSummaryMessageBuilder(messagesNo);
            osswService.uploadNotification(0, type, builder.build(), vibrationPattern, vibrationLength, null);
        } else {
            if (forceSummary) {
                NotificationMessageBuilder builder = new NotificationSummaryMessageBuilder(0);
                osswService.uploadNotification(0, type, builder.build(), vibrationPattern, vibrationLength, null);
            } else {
                closeNotifications();
            }
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
        //Log.i(TAG, "********** onNOtificationRemoved");
        Log.i(TAG, "ID :" + sbn.getId() + "<>" + sbn.getNotification().tickerText + "<>" + sbn.getPackageName());

        String notificationId = new NotificationIdBuilder().build(sbn);
        Notification removedNotification = notifications.remove(notificationId);

        if (removedNotification != null) {
            if (NotificationType.ALERT == removedNotification.getType()) {
                alertHandler.handleNotificationStop(notificationId);
            } else {
                updateNotificationList(false, 0, 0, false);
            }
        }
        //printNotifications();
    }

    private List<Notification> getAllInfoNotifications() {


        ArrayList<Notification> list = new ArrayList<>();
        for (Notification notification : this.notifications.values()) {
            if (notification.getType() == NotificationType.INFO) {
                list.add(notification);
            }
        }
        Collections.sort(list);
        return list;
    }

    private void printNotifications() {
//        Log.i(TAG, "Notifications list:");
        ArrayList<Notification> list = new ArrayList<>(notifications.values());
        Collections.sort(list);
        for (Notification notification : list) {
            Log.i(TAG, notification.toString());
        }
    }

//    private String extraToString(Object o) {
//        if (o == null) {
//            return null;
//        } else if (o instanceof Bundle) {
//            Set<String> keySet = ((Bundle) o).keySet();
//            StringBuilder sb = new StringBuilder();
//            for (String key : keySet) {
//                sb.append(key).append(": ").append(((Bundle) o).get(key)).append(", ");
//            }
//            return sb.toString();
//        } else if (o instanceof Object[]) {
//            return Arrays.toString((Object[]) o);
//        } else if (o instanceof int[]) {
//            return Arrays.toString((int[]) o);
//        } else if (o instanceof long[]) {
//            return Arrays.toString((long[]) o);
//        } else if (o instanceof float[]) {
//            return Arrays.toString((float[]) o);
//        } else if (o instanceof double[]) {
//            return Arrays.toString((double[]) o);
//        } else if (o instanceof char[]) {
//            return Arrays.toString((char[]) o);
//        } else if (o instanceof byte[]) {
//            return Arrays.toString((byte[]) o);
//        }
//        return o.toString();
//    }

    private int getNextNotificationId() {
        int notificationId = nextNotificationId;

        nextNotificationId++;
        if (nextNotificationId > 65535) {
            nextNotificationId = 1;
        }

        return notificationId;
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

        try {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                cancelPreLollipopNotification(sbn);
            } else {
                cancelPostLollipopNotification(sbn);
            }
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }

    @TargetApi(18)
    private void cancelPreLollipopNotification(StatusBarNotification sbn) {
        cancelNotification(sbn.getPackageName(), sbn.getTag(), sbn.getId());
    }

    @TargetApi(21)
    private void cancelPostLollipopNotification(StatusBarNotification sbn) {
        cancelNotification(sbn.getKey());
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
                return;
            }
        }
        // notification not found
        sendNextNotification(notificationId);
    }

    public void sendFirstNotification() {
        List<Notification> notificationList = getSortedNotificationsList();
        if (notificationList.size() == 0) {
            return;
        }
        sendNotificationPart(notificationList.get(0).getExternalId(), 0);
    }

    public void openNotification(int notificationId) {
        Notification notification = null;
        for (Notification n : notifications.values()) {
            if (n.getExternalId() == notificationId) {
                notification = n;
                break;
            }
        }

        if (notification == null) {
            return;
        }

        PendingIntent intent = ((StatusBarNotification) notification.getNotificationObject()).getNotification().contentIntent;

        if (intent != null) {
            try {
                intent.send();
            } catch (Exception e) {
                Log.d(TAG, e.getMessage());
            }
        }

        sendNextNotification(notificationId);
    }

    public void openNotificationsScreen() {
        updateNotificationList(true, 0, 0, true);
    }
}