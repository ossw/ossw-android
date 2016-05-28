package com.althink.android.ossw.utils;

import android.content.Intent;
import android.util.Log;

import com.althink.android.ossw.OsswApp;

import java.util.Arrays;

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
        int size = data.length / 3;
        float min[] = new float[size];
        float max[] = new float[size];
        float avg[] = new float[size];
        int pos;
        for (int i = 0; i < size; i++) {
            pos = 3 * i;
            min[i] = getSleepValue(data[pos]);
            max[i] = getSleepValue(data[pos+1]);
            avg[i] = getSleepValue(data[pos+2]);
        }
        Log.d(TAG, "New sleep data, length: "+ data.length+", "+ Arrays.toString(min)+", "+Arrays.toString(max)+", "+Arrays.toString(avg));
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
