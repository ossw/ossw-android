package com.althink.android.ossw;

import android.app.Application;
import android.content.Context;

/**
 * Created by Pavel Vasilyev on 13/04/2016.
 */
public class OsswApp extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}