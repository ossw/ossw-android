package com.althink.android.ossw.utils;

import android.util.Log;

import com.althink.android.ossw.OsswApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Created by pavel on 19/05/2016.
 */
public class Accelerometer {
    private final static String TAG = Accelerometer.class.getSimpleName();
    private final static String DIR = "ossw";
    private final static String FILE = "accelerometer.csv";
    public final static double g = 9.81;
    private static Accelerometer instance;

    private Accelerometer() {
    }

    public static Accelerometer getInstance() {
        if (instance == null)
            instance = new Accelerometer();
        return instance;
    }

    public void handle(byte[] data) {
        int bytes = 3;
        int len = data.length / bytes;
        BufferedWriter bw = null;
        try {
            File path = OsswApp.getContext().getExternalFilesDir(null);
            File file = new File(path, FILE);
            boolean writeHeader = false;
            if (!file.exists()) {
                file.createNewFile();
                writeHeader = true;
            }
            Log.d(TAG, file.getAbsolutePath());
            bw = new BufferedWriter(new FileWriter(file, true));
            if (writeHeader)
                bw.write("accX,accY,accZ\n");
            DecimalFormat df = new DecimalFormat("0.000");
            for (int i = 0; i < len; i++) {
//            int x = (data[bytes*i] << 8 | data[bytes*i+1]&0xff) >> 4;
//            int y = (data[bytes*i+2] << 8 | data[bytes*i+3]&0xff) >> 4;
//            int z = (data[bytes*i+4] << 8 | data[bytes*i+5]&0xff) >> 4;
//            double xf = 9.81*x/1024;
//            double yf = 9.81*y/1024;
//            double zf = 9.81*z/1024;
                byte x = data[bytes * i];
                byte y = data[bytes * i + 1];
                byte z = data[bytes * i + 2];
                double xf = getAcceleration(x);
                double yf = getAcceleration(y);
                double zf = getAcceleration(z);
//            Log.d(TAG, "New data x: "+data[bytes*i]+", y: "+data[bytes*i+1]+", z: "+data[bytes*i+2]);
                Log.d(TAG, "New accelerometer value #" + i + ": " + xf + ", " + yf + ", " + zf);
                bw.write(String.valueOf(x) + ',' + String.valueOf(y) + ',' + String.valueOf(z) + '\n');
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (bw != null) try {
                bw.close();
            } catch (IOException ioex) {
                ioex.printStackTrace();
            }
        }
    }

    public static double getAcceleration(byte val) {
        return g * val / 64;
    }
}
