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
                            intent.send();
                        } else if (notification.getCategory() == NotificationCategory.INCOMING_CALL) {
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
