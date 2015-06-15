package com.althink.android.ossw;

import android.content.Context;
import android.util.Log;

import java.util.Date;

/**
 * Created by krzysiek on 31/05/15.
 */
public class CallReceiver extends BaseCallReceiver {
    private final static String TAG = CallReceiver.class.getSimpleName();

    @Override
    protected void onIncomingCallStarted(Context ctx, String number, Date start) {
        Log.i(TAG, "incoming call started: " + number);
    }

    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start) {
    }

    @Override
    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end) {
        Log.i(TAG, "incoming call ended: " + number);
    }

    @Override
    protected void onOutgoingCallEnded(Context ctx, String number, Date start, Date end) {
    }

    @Override
    protected void onMissedCall(Context ctx, String number, Date start) {
        Log.i(TAG, "missed call: " + number);
    }

}