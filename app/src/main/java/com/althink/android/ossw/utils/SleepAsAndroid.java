package com.althink.android.ossw.utils;

import android.content.Intent;
import android.util.Log;

import com.althink.android.ossw.OsswApp;

/**
 * Created by pavel on 19/05/2016.
 */
public class SleepAsAndroid {
    private final static String TAG = SleepAsAndroid.class.getSimpleName();
    private final static String updateIntent = "com.urbandroid.sleep.watch.DATA_UPDATE";
    private static SleepAsAndroid instance;

    private SleepAsAndroid() { }

    public static SleepAsAndroid getInstance() {
        if (instance == null)
            instance = new SleepAsAndroid();
        return instance;
    }

    public void handle(byte[] data) {
//        Log.d(TAG, "New data, min: "+(data[0]&0xff)+", max: "+(data[1]&0xff)+", avg: "+(data[2]&0xff));
        float min[] = {getSleepValue(data[0])};
        float max[] = {getSleepValue(data[1])};
        float avg[] = {getSleepValue(data[2])};
        Log.d(TAG, "New sleep data: "+min+", "+max+", "+avg);
        Intent i = new Intent(updateIntent);
        i.putExtra("MIN_DATA", min);
        i.putExtra("MAX_DATA", max);
        i.putExtra("AVG_DATA", avg);
        OsswApp.getContext().sendBroadcast(i);
    }

    public static float getSleepValue(byte val) {
        return (float) (Accelerometer.g*(val&0xff)/64);
    }
}
