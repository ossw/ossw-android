package com.althink.android.ossw.notifications;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.althink.android.ossw.notifications.model.Notification;
import com.althink.android.ossw.notifications.model.NotificationCategory;
import com.althink.android.ossw.service.OsswService;

import java.lang.reflect.Method;

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
        Log.i(TAG, "handleFunction: " + functionId);
        switch (functionId) {
            case 0x21:
                if (notification.getOperations().size() > 0) {
                    try {
                        PendingIntent intent = notification.getOperations().get(0).getIntent();
                        if (intent != null) {
                            intent.send();
                        } else if (notification.getCategory() == NotificationCategory.INCOMING_CALL) {
                            rejectCall();
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

    public void rejectCall() {
        try {
            String serviceManagerName = "android.os.ServiceManager";
            String serviceManagerNativeName = "android.os.ServiceManagerNative";
            String telephonyName = "com.android.internal.telephony.ITelephony";
            Class<?> telephonyClass;
            Class<?> telephonyStubClass;
            Class<?> serviceManagerClass;
            Class<?> serviceManagerNativeClass;
            Method telephonyEndCall;
            Object telephonyObject;
            Object serviceManagerObject;
            telephonyClass = Class.forName(telephonyName);
            telephonyStubClass = telephonyClass.getClasses()[0];
            serviceManagerClass = Class.forName(serviceManagerName);
            serviceManagerNativeClass = Class.forName(serviceManagerNativeName);
            Method getService = // getDefaults[29];
                    serviceManagerClass.getMethod("getService", String.class);
            Method tempInterfaceMethod = serviceManagerNativeClass.getMethod("asInterface", IBinder.class);
            Binder tmpBinder = new Binder();
            tmpBinder.attachInterface(null, "fake");
            serviceManagerObject = tempInterfaceMethod.invoke(null, tmpBinder);
            IBinder retbinder = (IBinder) getService.invoke(serviceManagerObject, "phone");
            Method serviceMethod = telephonyStubClass.getMethod("asInterface", IBinder.class);
            telephonyObject = serviceMethod.invoke(null, retbinder);
            telephonyEndCall = telephonyClass.getMethod("endCall");
            telephonyEndCall.invoke(telephonyObject);

            //Log.d(TAG, "Call rejected");
        } catch (Exception e) {
            Log.e(TAG, "FATAL ERROR: could not connect to telephony subsystem: " + e, e);
        }
    }

}
