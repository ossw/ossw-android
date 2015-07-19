package com.althink.android.ossw.notifications;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;

import com.althink.android.ossw.NotificationType;
import com.althink.android.ossw.service.OsswService;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by krzysiek on 31/05/15.
 */
public class CallReceiver extends BroadcastReceiver {

    private final static String TAG = CallReceiver.class.getSimpleName();

    private static int lastState = TelephonyManager.CALL_STATE_IDLE;

    private static int lastNotificationId;

    private static Timer timer;

    @Override
    public void onReceive(Context context, Intent intent) {

        String stateStr = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
        String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

        //Log.i(TAG, "onReceive: " + stateStr);

        int state = 0;
        if (stateStr.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
            state = TelephonyManager.CALL_STATE_IDLE;
        } else if (stateStr.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
            state = TelephonyManager.CALL_STATE_OFFHOOK;
        } else if (stateStr.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            state = TelephonyManager.CALL_STATE_RINGING;
        }

        onCallStateChanged(context, state, number);

    }

    public void onCallStateChanged(Context context, int state, String number) {
        if (lastState == state) {
            //No change, debounce extras
            return;
        }

        if (state == TelephonyManager.CALL_STATE_RINGING) {
            startIncomingCallNotification(context, number, getContactName(context, number));
        } else if (lastState == TelephonyManager.CALL_STATE_RINGING && (state == TelephonyManager.CALL_STATE_OFFHOOK || state == TelephonyManager.CALL_STATE_IDLE)) {
            endIncomingCallNotification(context);
        }
        lastState = state;
    }

    public static String getContactName(Context context, String phoneNumber) {
        ContentResolver cr = context.getContentResolver();
        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneNumber));
        Cursor cursor = cr.query(uri, new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME}, null, null, null);
        if (cursor == null) {
            return null;
        }
        String contactName = null;
        if (cursor.moveToFirst()) {
            contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME));
        }

        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return contactName;
    }

    private void startIncomingCallNotification(Context context, String number, String contactName) {
        //Log.i(TAG, "startIncomingCallNotification: " + number + " " + contactName);

        Intent osswServiceIntent = new Intent(context, OsswService.class);
        OsswService osswBleService = ((OsswService.LocalBinder) peekService(context, osswServiceIntent)).getService();
        int vibration_pattern = (6 << 28) | (100 << 16) | (44 << (16 - 6));
        IncomingCallNotificationBuilder builder = new IncomingCallNotificationBuilder(number, contactName);
        lastNotificationId = osswBleService.uploadNotification(NotificationType.ALERT_NOTIFICATION, builder.build(), vibration_pattern, 3000);

        startNotificationExtender(lastNotificationId, osswBleService);
    }

    private void endIncomingCallNotification(Context context) {
        //Log.i(TAG, "endIncomingCallNotification");
        stopNotificationExtender();

        Intent osswServiceIntent = new Intent(context, OsswService.class);
        OsswService osswBleService = ((OsswService.LocalBinder) peekService(context, osswServiceIntent)).getService();

        osswBleService.closeNotification(lastNotificationId);
    }

    private void startNotificationExtender(int notificationId, OsswService osswBleService) {
        stopNotificationExtender();
        timer = new Timer();
        timer.schedule(new NotificationExtenderTimer(notificationId, osswBleService), 1000, 1000);
    }

    private void stopNotificationExtender() {
        if (timer != null) {
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
            osswBleService.extendNotification(notificationId, 2000);
        }
    }
}