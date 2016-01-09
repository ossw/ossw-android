package com.althink.android.ossw.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.althink.android.ossw.R;
import com.althink.android.ossw.settings.TextSwitchPreference;

import java.util.Date;

/**
 * Created by Pavel on 19/12/2015.
 */
public class CallReceiver extends PhoneCallReceiver {
    private final static String TAG = CallReceiver.class.getSimpleName();
    public static final int CALL_NOTIFICATION_ID = 0x120;
    public static final int DECLINE_REQUEST_ID = 0x200;
    public static final int MUTE_REQUEST_ID = 0x201;
    public static final String DECLINE_CALL_INTENT_ACTION = "com.althink.android.ossw.decline.call";
    public static final String MUTE_CALL_INTENT_ACTION = "com.althink.android.ossw.mute.call";
    public static final String INCOMING_CALL_NUMBER = "incoming.call.number";

    @Override
    protected void onIncomingCallStarted(Context ctx, String number, Date start) {
        Log.i(TAG, "incoming call started: " + number);
        SharedPreferences shPref = PreferenceManager.getDefaultSharedPreferences(ctx);
        String title1;
        boolean enabled = shPref.getBoolean("pref_reject_call_message" + TextSwitchPreference.KEY_SUFFIX, false);
        if (enabled)
            title1 = ctx.getString(R.string.notif_decline_call_sms);
        else
            title1 = ctx.getString(R.string.notif_decline_call);
        String title2 = ctx.getString(R.string.notif_mute_call);
        NotificationManagerCompat notifyManager = NotificationManagerCompat.from(ctx);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx);
        Intent declineCallIntent = new Intent(DECLINE_CALL_INTENT_ACTION);
        declineCallIntent.putExtra(INCOMING_CALL_NUMBER, number);
        builder.setContentTitle(getContactName(ctx, number))
                .setContentText(number)
                .setPriority(2)
                .setCategory(Notification.CATEGORY_CALL)
                .setFullScreenIntent(PendingIntent.getBroadcast(ctx, 0, new Intent(OsswService.FULLSCREEN_FAKE_ALARM_INTENT_ACTION), 0), false)
                .addAction(android.R.drawable.ic_menu_close_clear_cancel, title1, PendingIntent.getBroadcast(ctx, DECLINE_REQUEST_ID, declineCallIntent, PendingIntent.FLAG_UPDATE_CURRENT))
                .addAction(android.R.drawable.ic_menu_close_clear_cancel, title2, PendingIntent.getBroadcast(ctx, MUTE_REQUEST_ID, new Intent(MUTE_CALL_INTENT_ACTION), PendingIntent.FLAG_UPDATE_CURRENT))
                .setSmallIcon(R.drawable.ic_watch_dial);
        notifyManager.notify(CALL_NOTIFICATION_ID, builder.build());
    }

    @Override
    protected void onIncomingCallAnswered(Context ctx, String number, Date start) {
        Log.i(TAG, "incoming call answered: " + number);
        NotificationManagerCompat notifyManager = NotificationManagerCompat.from(ctx);
        notifyManager.cancel(CALL_NOTIFICATION_ID);
        restoreFromMutedMode(ctx);
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
        restoreFromMutedMode(ctx);
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
