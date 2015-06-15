package com.althink.android.ossw.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;

/**
 * Created by krzysiek on 14/06/15.
 */
public class ExternalServiceConnection {

    private Messenger messanger;
    private final ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            messanger = new Messenger(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            messanger = null;
        }
    };

    public Messenger getMessanger() {
        return messanger;
    }

    public ServiceConnection getConnection() {
        return connection;
    }
}
