package com.althink.android.ossw.notifications;

import android.app.PendingIntent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import com.althink.android.ossw.notifications.model.Notification;
import com.althink.android.ossw.notifications.model.NotificationCategory;
import com.althink.android.ossw.service.CallReceiver;
import com.althink.android.ossw.service.OsswService;
import com.althink.android.ossw.service.PhoneCallReceiver;
import com.althink.android.ossw.settings.TextSwitchPreference;

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
                            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
                                if (notification.getCategory() == NotificationCategory.INCOMING_CALL) {
                                    SharedPreferences shPref = PreferenceManager.getDefaultSharedPreferences(osswService);
                                    boolean enabled = shPref.getBoolean("pref_reject_call_message" + TextSwitchPreference.KEY_SUFFIX, false);
                                    if (enabled) {
//                                        TODO: get the caller number
//                                        Bundle extras = intent.getExtras();
//                                        if (extras != null) {
//                                            String message = shPref.getString("pref_reject_call_message", "");
//                                            String number = extras.getString(CallReceiver.INCOMING_CALL_NUMBER);
//                                            CallReceiver.sendSMS(number, message);
//                                        }
                                    }

                                }
                            }
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
