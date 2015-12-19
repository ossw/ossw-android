package com.althink.android.ossw.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.althink.android.ossw.R;

import java.util.Date;

/**
 * Created by Pavel on 19/12/2015.
 */
public class CallReceiver extends PhoneCallReceiver {
    private final static String TAG = CallReceiver.class.getSimpleName();
    public static final int CALL_NOTIFICATION_ID = 0x120;
    public static final String DECLINE_CALL_INTENT_ACTION = "com.althink.android.ossw.decline.call";
    public static final String MUTE_CALL_INTENT_ACTION = "com.althink.android.ossw.mute.call";

    @Override
    protected void onIncomingCallStarted(Context ctx, String number, Date start) {
        Log.i(TAG, "incoming call started: " + number);
        NotificationManagerCompat notifyManager = NotificationManagerCompat.from(ctx);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx);
        builder.setContentTitle(getContactName(ctx, number))
                .setContentText(number)
                .setPriority(2)
                .setCategory(Notification.CATEGORY_CALL)
                .setFullScreenIntent(PendingIntent.getBroadcast(ctx, 0, new Intent(OsswService.FULLSCREEN_FAKE_ALARM_INTENT_ACTION), 0), false)
                .addAction(android.R.drawable.ic_menu_close_clear_cancel, "Decline", PendingIntent.getBroadcast(ctx, 0, new Intent(DECLINE_CALL_INTENT_ACTION), 0))
                .addAction(android.R.drawable.ic_menu_close_clear_cancel, "Mute", PendingIntent.getBroadcast(ctx, 0, new Intent(MUTE_CALL_INTENT_ACTION), 0))
                .setSmallIcon(R.drawable.ic_watch_dial);
        notifyManager.notify(CALL_NOTIFICATION_ID, builder.build());
    }

    @Override
    protected void onIncomingCallAnswered(Context ctx, String number, Date start) {
        Log.i(TAG, "incoming call answered: " + number);
        NotificationManagerCompat notifyManager = NotificationManagerCompat.from(ctx);
        notifyManager.cancel(CALL_NOTIFICATION_ID);
        restoreMutedMode(ctx);
    }

    @Override
    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end) {
        Log.i(TAG, "incoming call ended: " + number);
        NotificationManagerCompat notifyManager = NotificationManagerCompat.from(ctx);
        notifyManager.cancel(CALL_NOTIFICATION_ID);
    }

    @Override
    protected void onMissedCall(Context ctx, String number, Date start) {
        Log.i(TAG, "missed call: " + number);
        NotificationManagerCompat notifyManager = NotificationManagerCompat.from(ctx);
        notifyManager.cancel(CALL_NOTIFICATION_ID);
        restoreMutedMode(ctx);
    }

    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start) {
        Log.i(TAG, "outgoing call started: " + number);
    }

    @Override
    protected void onOutgoingCallEnded(Context ctx, String number, Date start, Date end) {
        Log.i(TAG, "outgoing call ended: " + number);
    }

}
