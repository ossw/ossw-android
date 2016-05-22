package com.althink.android.ossw.utils;

import android.util.Log;

/**
 * Created by pavel on 19/05/2016.
 */
public class Accelerometer {
    private final static String TAG = Accelerometer.class.getSimpleName();
    public final static double g = 9.81;
    private static Accelerometer instance;

    private Accelerometer() { }

    public static Accelerometer getInstance() {
        if (instance == null)
            instance = new Accelerometer();
        return instance;
    }

    public void handle(byte[] data) {
        int bytes = 3;
        int len = data.length / bytes;
        for (int i = 0; i < len; i++) {
//            int x = (data[bytes*i] << 8 | data[bytes*i+1]&0xff) >> 4;
//            int y = (data[bytes*i+2] << 8 | data[bytes*i+3]&0xff) >> 4;
//            int z = (data[bytes*i+4] << 8 | data[bytes*i+5]&0xff) >> 4;
//            double xf = 9.81*x/1024;
//            double yf = 9.81*y/1024;
//            double zf = 9.81*z/1024;
            double xf = getAcceleration(data[bytes*i]);
            double yf = getAcceleration(data[bytes*i+1]);
            double zf = getAcceleration(data[bytes*i+2]);
//            Log.d(TAG, "New data x: "+data[bytes*i]+", y: "+data[bytes*i+1]+", z: "+data[bytes*i+2]);
            Log.d(TAG, "New accelerometer value #"+i+": "+xf+", "+yf+", "+zf);
        }
    }

    public static double getAcceleration(byte val) {
        return g*val/64;
    }
}
