package com.althink.android.ossw.notifications;

import android.app.PendingIntent;
import android.util.Log;

import com.althink.android.ossw.notifications.model.Notification;
import com.althink.android.ossw.notifications.model.NotificationCategory;
import com.althink.android.ossw.service.OsswService;
import com.althink.android.ossw.service.PhoneCallReceiver;

/**
 * Created by krzysiek on 19/07/15.
 */
public class AlertNotificationFunctionHandler implements NotificationHandler {

    private final static String TAG = AlertNotificationFunctionHandler.class.getSimpleName();
    private Notification notification;
    private OsswService osswService;

    public AlertNotificationFunctionHandler(Notification notification, OsswService osswService) {
        this.notification = notification;
        this.osswService = osswService;
    }

    @Override
    public void handleFunction(int functionId) {
        //Log.i(TAG, "handleFunction: " + functionId);
        switch (functionId) {
            case 0x21:
                if (notification.getOperations().size() > 0) {
                    try {
                        PendingIntent intent = notification.getOperations().get(0).getIntent();
                        if (intent != null) {
                            Log.i(TAG, "handleFunction: UP BUTTON " + intent.toString());
                            intent.send();
                            // TODO: use this code if basic decline call does not work
//                            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
//                                if (notification.getCategory() == NotificationCategory.INCOMING_CALL) {
//                                    SharedPreferences shPref = PreferenceManager.getDefaultSharedPreferences(osswService);
//                                    boolean enabled = shPref.getBoolean("pref_reject_call_message" + TextSwitchPreference.KEY_SUFFIX, false);
//                                    if (enabled && notification instanceof SimpleNotification) {
//                                        String message = shPref.getString("pref_reject_call_message", "");
//                                        String number = ((SimpleNotification) notification).getTitle();
//                                        CallReceiver.sendSMS(number, message);
//                                    }
//
//                                }
//                            }
                        } else if (notification.getCategory() == NotificationCategory.INCOMING_CALL) {
                            Log.i(TAG, "handleFunction: UP BUTTON -> decline call");
                            PhoneCallReceiver.declineCall();
                        }
                    } catch (PendingIntent.CanceledException e) {
                        Log.e(TAG, e.getMessage(), e);
                    }
                }
                break;
            case 0x22:
                if (notification.getOperations().size() > 1) {
                    try {
                        notification.getOperations().get(1).getIntent().send();
                    } catch (PendingIntent.CanceledException e) {
                        Log.e(TAG, e.getMessage(), e);
                    }
                }
                break;
        }
    }

}
