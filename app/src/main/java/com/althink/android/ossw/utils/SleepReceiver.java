package com.althink.android.ossw.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SleepReceiver extends BroadcastReceiver {
    private final static String TAG = SleepReceiver.class.getSimpleName();
    private final static String CHECK_CONNECTION = "com.urbandroid.sleep.watch.CHECK_CONNECTED";
    private final static String CONFIRM_CONNECTION = "com.urbandroid.sleep.watch.CONFIRM_CONNECTED";
    private final static String START_TRACKING = "com.urbandroid.sleep.watch.START_TRACKING";
    private final static String STOP_TRACKING = "com.urbandroid.sleep.watch.STOP_TRACKING";
    private final static String SET_BATCH_SIZE = "com.urbandroid.sleep.watch.SET_BATCH_SIZE";
    private final static String SET_SUSPENDED = "com.urbandroid.sleep.watch.SET_SUSPENDED";

    public SleepReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d(TAG, action);
        if (CHECK_CONNECTION.equals(action)) {
            Intent i = new Intent(CONFIRM_CONNECTION);
            context.sendBroadcast(i);
        } else if (START_TRACKING.equals(action)) {
        } else if (STOP_TRACKING.equals(action)) {
        } else if (SET_BATCH_SIZE.equals(action)) {
            long size = intent.getLongExtra("SIZE", 1);
            Log.d(TAG, String.valueOf(size));
        } else if (SET_SUSPENDED.equals(action)) {
            boolean suspend = intent.getBooleanExtra("SUSPENDED", false);
            Log.d(TAG, String.valueOf(suspend));
        }
    }
}
