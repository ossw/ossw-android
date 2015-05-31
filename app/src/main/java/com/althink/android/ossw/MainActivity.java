package com.althink.android.ossw;

import android.app.Activity;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.althink.android.ossw.R;
import com.iforpowell.android.ipantmanapi.IpAntManApi;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    private final static String TAG = MainActivity.class.getSimpleName();

    private String mDeviceAddress;
    private OsswBleService mOsswBleService;

    static final int SELECT_WATCH_REQUEST = 1;

    // Code to manage Service lifecycle.
    private final ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            mOsswBleService = ((OsswBleService.LocalBinder) service).getService();
            if (!mOsswBleService.initialize()) {
                Log.e(TAG, "Unable to initialize Bluetooth");
                finish();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mOsswBleService = null;
        }
    };

    // Handles various events fired by the Service.
    // ACTION_GATT_CONNECTED: connected to a GATT server.
    // ACTION_GATT_DISCONNECTED: disconnected from a GATT server.
    // ACTION_GATT_SERVICES_DISCOVERED: discovered GATT services.
    // ACTION_DATA_AVAILABLE: received data from the device.  This can be a result of read
    //                        or notification operations.
    private final BroadcastReceiver mGattUpdateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Log.i(TAG, "Intent received: " + intent);
            final String action = intent.getAction();
            if (OsswBleService.ACTION_WATCH_CONNECTED.equals(action)) {
                updateConnectionState(R.string.connected);
                invalidateOptionsMenu();
                Log.i(TAG, "Watch is connected");
            } else if (OsswBleService.ACTION_WATCH_DISCONNECTED.equals(action)) {
                updateConnectionState(R.string.disconnected);
                invalidateOptionsMenu();
                ///clearUI();
                Log.i(TAG, "Watch is disconnected");

            }
        }
    };

    BroadcastReceiver receiver;

    protected void updateConnectionState(int messageId) {
        TextView tv1 = (TextView)findViewById(R.id.connectionStatus);
        tv1.setText(messageId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "CREATE");
        setContentView(R.layout.activity_main);

        Intent gattServiceIntent = new Intent(this, OsswBleService.class);
        bindService(gattServiceIntent, mServiceConnection, BIND_AUTO_CREATE);

        registerWithIpSensorMan();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "RESUME");
        registerReceiver(mGattUpdateReceiver, makeGattUpdateIntentFilter());
    /*    if (mOsswBleService != null) {
            final boolean result = mOsswBleService.connect(mDeviceAddress);
            Log.d(TAG, "Connect request result=" + result);
        }*/
        if(mOsswBleService != null) {
            int status = mOsswBleService.getStatus();
            updateConnectionState(status == OsswBleService.STATE_CONNECTED ? R.string.connected : R.string.disconnected);
        } else {
            updateConnectionState(R.string.disconnected);
        }

    }

    private static IntentFilter makeGattUpdateIntentFilter() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(OsswBleService.ACTION_WATCH_CONNECTED);
        intentFilter.addAction(OsswBleService.ACTION_WATCH_DISCONNECTED);
        return intentFilter;
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mGattUpdateReceiver);
        Log.i(TAG, "PAUSE");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "DESTROY");
        unbindService(mServiceConnection);

        if(receiver != null) {
             unregisterReceiver(receiver);
        }
    }

    private void connectToWatch(String address) {
        mOsswBleService.connect(address);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case SELECT_WATCH_REQUEST:
                if (resultCode == RESULT_OK) {
                    String address = data.getStringExtra("watch_ble_address");
                    if(address != null) {

                        Log.i(TAG, "Connect to: " + address);
                        connectToWatch(address);
                    }
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_find_watch) {
            final Intent intent = new Intent(this, DeviceScanActivity.class);
            startActivityForResult(intent, SELECT_WATCH_REQUEST);
            return true;
        } else if (id == R.id.action_settings) {
            final Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private float speed;


    private float cadence;

    public void registerWithIpSensorMan() {
        Intent intent;
        intent = new Intent(IpAntManApi.REGISTER_ANT_ACTION);
        intent.setClassName("com.iforpowell.android.ipantman", "com.iforpowell.android.ipantman.MainService");
        intent.putExtra(IpAntManApi.NAME, getString(R.string.app_name));
        ComponentName comp = startService(intent);

        Intent hr_intent = new Intent(IpAntManApi.START_SENSOR_TYPE_ACTION);
        hr_intent.setClassName("com.iforpowell.android.ipantman", "com.iforpowell.android.ipantman.MainService");
        hr_intent.putExtra(IpAntManApi.DEVICE_TYPE, IpAntManApi.DEVICE_TYPE_HR);
        hr_intent.putExtra(IpAntManApi.DEVICE_ID, IpAntManApi.KNOWN_SENSORS);
        startService(hr_intent);

        IntentFilter filter = new IntentFilter();
        filter.addAction(IpAntManApi.NEW_SENSOR_EVENT);
        filter.addAction(IpAntManApi.HR_EVENT);
        filter.addAction(IpAntManApi.BIKE_SPEED_EVENT);
        filter.addAction(IpAntManApi.BIKE_CADENCE_EVENT);

        if(receiver == null) {

            receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {

/*
                    * int COUNT with the number of beats for this update
                            * int TIME with the time in 1/1024 seconds for this event.
                            * int AMOUNT with the last heart rate as transmitted by the sensor.
                    * int RR integer array of RR data. optional. Normally just one from good ANT reception can be bigger with bad reception and BT and BTLE may also have multiple.  Oldest to newest order
                    * int DB_ID database ID for this unique sensor
                    */
                    Log.i("BroadcastReceiver", "Action: " + intent.getAction());

                    if (IpAntManApi.HR_EVENT.equals(intent.getAction())) {
                        int value = intent.getIntExtra(IpAntManApi.AMOUNT, 0);
                       // Log.i("BroadcastReceiver", "HR: " + value);
                        if (mOsswBleService != null) {
                            mOsswBleService.sendTestParam(1, value);
                        }
                    } else if (IpAntManApi.BIKE_SPEED_EVENT.equals(intent.getAction())) {
                        int count = intent.getIntExtra(IpAntManApi.COUNT, 0);
                        int time = intent.getIntExtra(IpAntManApi.TIME, 0);
                        Log.i(TAG, "Speed event, count: " + count + ", time: " + time);

                                speed = (count) * 2.149f / (time / 1024.f) * 3.6f;
                                Log.i(TAG, "Speed: " + speed);

                        mOsswBleService.sendTestParam(2, (int)speed);


                    } else if (IpAntManApi.BIKE_CADENCE_EVENT.equals(intent.getAction())) {
                        int count = intent.getIntExtra(IpAntManApi.COUNT, 0);
                        int time = intent.getIntExtra(IpAntManApi.TIME, 0);
                        Log.i(TAG, "Cadence event, count: " + count + ", time: " + time);

                                cadence = (count) / (time/1024.f) * 60 ;
                                Log.i(TAG, "Cadence: " + cadence);

                        mOsswBleService.sendTestParam(3, (int)cadence);
                    }
                }
            };
        }
        registerReceiver(receiver, filter);
    }
}
