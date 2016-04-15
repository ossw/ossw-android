package com.althink.android.ossw.service;

import java.lang.reflect.Method;
import java.util.Date;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.service.notification.NotificationListenerService;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.althink.android.ossw.OsswApp;
import com.althink.android.ossw.R;
import com.althink.android.ossw.notifications.NotificationListener;

/**
 * Created by Pavel on 19/12/2015.
 */
public abstract class PhoneCallReceiver extends BroadcastReceiver {
    private final static String TAG = CallReceiver.class.getSimpleName();
    private static int lastState = TelephonyManager.CALL_STATE_IDLE;
    private static Date callStartTime;
    private static boolean isIncoming;
    private static String savedNumber;
    static boolean muted = false;
    static int interruptionFilter;
    static int ringerMode;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
            savedNumber = intent.getExtras().getString("android.intent.extra.PHONE_NUMBER");
        } else {
            String stateStr = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
            String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            int state = 0;
            if (TelephonyManager.EXTRA_STATE_IDLE.equals(stateStr)) {
                state = TelephonyManager.CALL_STATE_IDLE;
            } else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(stateStr)) {
                state = TelephonyManager.CALL_STATE_OFFHOOK;
            } else if (TelephonyManager.EXTRA_STATE_RINGING.equals(stateStr)) {
                state = TelephonyManager.CALL_STATE_RINGING;
            }
            onCallStateChanged(context, state, number);
        }
    }

    // Incoming call:  goes from IDLE to RINGING when it rings, to OFFHOOK when it's answered, to IDLE when its hung up
    // Outgoing call:  goes from IDLE to OFFHOOK when it dials out, to IDLE when hung up
    public void onCallStateChanged(Context context, int state, String number) {
        if (lastState == state) {
            return;
        }
        int tempState = lastState;
        lastState = state;
        switch (state) {
            case TelephonyManager.CALL_STATE_RINGING:
                isIncoming = true;
                callStartTime = new Date();
                savedNumber = number;
                onIncomingCallStarted(context, number, callStartTime);
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                // Transition of ringing -> offhook are pickups of incoming calls.  Nothing done on them
                if (tempState == TelephonyManager.CALL_STATE_RINGING) {
                    isIncoming = true;
                    callStartTime = new Date();
                    onIncomingCallAnswered(context, number, callStartTime);
                } else {
                    isIncoming = false;
                    callStartTime = new Date();
                    onOutgoingCallStarted(context, savedNumber, callStartTime);
                }
                break;
            case TelephonyManager.CALL_STATE_IDLE:
                // Went to idle -- this is the end of a call.  What type depends on previous state(s)
                if (tempState == TelephonyManager.CALL_STATE_RINGING) {
                    // Ring but no pickup -- missed call
                    onMissedCall(context, savedNumber, callStartTime);
                } else if (isIncoming) {
                    onIncomingCallEnded(context, savedNumber, callStartTime, new Date());
                } else {
                    onOutgoingCallEnded(context, savedNumber, callStartTime, new Date());
                }
                break;
        }
    }

    protected void onIncomingCallStarted(Context ctx, String number, Date start) {
    }

    protected void onIncomingCallAnswered(Context ctx, String number, Date start) {
    }

    protected void onOutgoingCallStarted(Context ctx, String number, Date start) {
    }

    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end) {
    }

    protected void onOutgoingCallEnded(Context ctx, String number, Date start, Date end) {
    }

    protected void onMissedCall(Context ctx, String number, Date start) {
    }

    public static String getContactName(Context context, String phoneNumber) {
        ContentResolver cr = context.getContentResolver();
        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneNumber));
        Cursor cursor = cr.query(uri, new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME}, null, null, null);
        String contactName = context.getString(R.string.unknown_contact);
        if (cursor == null) {
            return contactName;
        }
        if (cursor.moveToFirst()) {
            contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME));
        }

        if (!cursor.isClosed()) {
            cursor.close();
        }

        return contactName;
    }

    public static void setMutedMode(Context ctx) {
        if (muted)
            return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            NotificationListener notifListener = NotificationListener.getInstance();
            interruptionFilter = notifListener.getCurrentInterruptionFilter();
            Log.i(TAG, "Saving interruption filter: " + interruptionFilter);
            notifListener.requestInterruptionFilter(NotificationListenerService.INTERRUPTION_FILTER_NONE);
        } else {
            AudioManager am = (AudioManager) ctx.getSystemService(Context.AUDIO_SERVICE);
            PhoneCallReceiver.ringerMode = am.getRingerMode();
            am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        }
        muted = true;
    }

    public static void restoreFromMutedMode(Context ctx) {
        if (!muted)
            return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            NotificationListener notifListener = NotificationListener.getInstance();
            notifListener.requestInterruptionFilter(interruptionFilter);
        } else {
            AudioManager am = (AudioManager) ctx.getSystemService(Context.AUDIO_SERVICE);
            am.setRingerMode(ringerMode);
        }
        muted = false;
    }

    public static void declineCall() {
        Log.d(TAG, "Declining the call");
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
        } catch (Exception e) {
            Log.e(TAG, "FATAL ERROR: could not connect to telephony subsystem: " + e, e);
        }
    }

    public static void sendSMS(String number, String msg) {
        if (ContextCompat.checkSelfPermission(OsswApp.getContext(),
                Manifest.permission.SEND_SMS)
                == PackageManager.PERMISSION_GRANTED) {
            SmsManager sm = SmsManager.getDefault();
            Log.i(TAG, "Sending SMS: '" + msg + "' to " + number);
            sm.sendTextMessage(number, null, msg, null, null);
        }
    }

    public static void callNumber(String number) {
        if (ContextCompat.checkSelfPermission(OsswApp.getContext(),
                Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED) {
            Uri uri = Uri.parse("tel:" + number);
            Intent callIntent = new Intent(Intent.ACTION_CALL, uri);
            callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            OsswApp.getContext().startActivity(callIntent);
        }
    }
}
