package com.althink.android.ossw.notifications;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.althink.android.ossw.settings.SettingsActivity;
import com.althink.android.ossw.notifications.message.AlertNotificationMessageBuilder;
import com.althink.android.ossw.notifications.message.NotificationMessageBuilder;
import com.althink.android.ossw.notifications.model.Notification;
import com.althink.android.ossw.notifications.model.SimpleNotification;
import com.althink.android.ossw.service.OsswService;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by krzysiek on 25/07/15.
 */
public class AlertNotificationHandler {

    private String TAG = this.getClass().getSimpleName();

    private static Notification lastNotification;

    private static Timer timer;

    public void handleNotificationStart(Notification notification) {
        Log.i(TAG, "HANDLE notification START: " + notification);
        if (!(notification instanceof SimpleNotification)) {
            Log.i(TAG, "HANDLE notification START - SKIP");
            return;
        }

        boolean update = lastNotification != null && lastNotification.getExternalId() == notification.getExternalId();

        if (lastNotification != null && !update) {
            Log.i(TAG, "SKIP, other alert notification in progress");
            return;
        }
        lastNotification = notification;

        OsswService osswBleService = OsswService.getInstance();
        if (osswBleService != null) {
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(osswBleService);
            boolean vibrate = sharedPref.getBoolean(SettingsActivity.ALERT_VIBRATION_PREFIX , true);
            int vibrationPattern = 0;
            int vibrationLength = 0;
            if (vibrate) {
                Calendar c = Calendar.getInstance();
                int minutes = 60 * c.get(Calendar.HOUR_OF_DAY) + c.get(Calendar.MINUTE);
                String active = sharedPref.getString(SettingsActivity.ALERT_VIBRATION_PREFIX + "_time", "0:0-23:59");
                int dash = active.indexOf('-');
                int from_time = NotificationListener.getMinutes(active.substring(0, dash));
                int till_time = NotificationListener.getMinutes(active.substring(dash + 1));
                if ((from_time <= minutes && minutes <=till_time) ||
                        (from_time >= till_time) && (from_time <= minutes || minutes <= till_time)) {
                    vibrationPattern = VibrationPatternBuilder.getAlertVibrationPattern(osswBleService.getApplicationContext());
                }
            }
            NotificationMessageBuilder builder = new AlertNotificationMessageBuilder(notification.getCategory(), ((SimpleNotification) notification).getTitle(), ((SimpleNotification) notification).getText(), notification.getOperations());
            osswBleService.uploadNotification(notification.getExternalId(), notification.getType(), builder.build(), vibrationPattern, 7000, new AlertNotificationFunctionHandler(notification, osswBleService));

            if (!update) {
                Log.i(TAG, "Start notification: " + lastNotification.getId() + ", " + lastNotification.getExternalId());
                startNotificationExtender(notification.getExternalId(), osswBleService);
            } else {
                Log.i(TAG, "Update notification: " + lastNotification.getId() + ", " + lastNotification.getExternalId());
            }
        }
    }

    public void handleNotificationStop(String notificationId) {
        //Log.i(TAG, "HANDLE notification STOP: " + notificationId);
        if (lastNotification != null && lastNotification.getId().equals(notificationId)) {

            stopNotificationExtender();

            OsswService osswService = OsswService.getInstance();
            if (osswService != null) {
                //Log.i(TAG, "Close notification: " + lastNotification.getId() + ", " + lastNotification.getExternalId());
                osswService.closeAlertNotification(lastNotification.getExternalId());
            }

            lastNotification = null;
        }
    }

    private void startNotificationExtender(int notificationId, OsswService osswBleService) {
        //Log.i(TAG, "Start notification extender: " + notificationId);
        stopNotificationExtender();
        timer = new Timer();
        timer.schedule(new NotificationExtenderTimer(notificationId, osswBleService), 1000, 1500);
    }

    private void stopNotificationExtender() {
        if (timer != null) {
            //Log.i(TAG, "Stop notification extender");
            //Log.i(TAG, "Cancel timer");
            timer.cancel();
            timer = null;
        }
    }

    class NotificationExtenderTimer extends TimerTask {

        private int notificationId;
        private OsswService osswBleService;

        public NotificationExtenderTimer(int notificationId, OsswService osswBleService) {
            this.notificationId = notificationId;
            this.osswBleService = osswBleService;
        }

        @Override
        public void run() {
            //Log.i(TAG, "Extend notification: " + lastNotification.getId() + ", " + lastNotification.getExternalId());
            osswBleService.extendAlertNotification(notificationId, 7000);
        }
    }
}
