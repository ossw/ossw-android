package com.althink.android.ossw;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.*;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.althink.android.ossw.drawer.NavigationDrawerCallbacks;
import com.althink.android.ossw.drawer.NavigationDrawerFragment;
import com.althink.android.ossw.home.HomeFragment;
import com.althink.android.ossw.plugins.PluginsFragment;
import com.althink.android.ossw.service.OsswService;
import com.althink.android.ossw.watchsets.WatchSetsFragment;

public class MainActivity extends AppCompatActivity implements NavigationDrawerCallbacks {
    private final static String TAG = MainActivity.class.getSimpleName();

    private OsswService mOsswBleService;

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;
    private Toolbar mBottomToolbar;

    private HomeFragment mHomeFragment;
    private WatchSetsFragment mWatchsetsFragment;
    private PluginsFragment mPluginsFragment;

    static final int SELECT_WATCH_REQUEST = 1;

    // Code to manage Service lifecycle.
    private final ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            mOsswBleService = ((OsswService.LocalBinder) service).getService();
            refreshConnectionAlert();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mOsswBleService = null;
        }
    };

    private final BroadcastReceiver mGattUpdateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Log.i(TAG, "Intent received: " + intent);
            final String action = intent.getAction();
            if (OsswService.ACTION_WATCH_CONNECTING.equals(action)) {
                showConnectionAlertBar(R.string.connecting);
                invalidateOptionsMenu();
                Log.i(TAG, "Connecting to the watch");
            } else if (OsswService.ACTION_WATCH_CONNECTED.equals(action)) {
                //updateConnectionState(R.string.connected);
                Toast.makeText(MainActivity.this, getString(R.string.toast_watch_is_connected), Toast.LENGTH_SHORT).show();
                hideConnectionAlertBar();
                invalidateOptionsMenu();
                Log.i(TAG, "Watch is connected");
            } else if (OsswService.ACTION_WATCH_DISCONNECTED.equals(action)) {
                showConnectionAlertBar(R.string.disconnected);
                invalidateOptionsMenu();
                ///clearUI();
                Log.i(TAG, "Watch is disconnected");

            }
        }
    };

    private void hideConnectionAlertBar() {
        View view = findViewById(R.id.watch_connection_alert);
        view.setVisibility(View.GONE);
    }

    private void showConnectionAlertBar(int messageId) {
        TextView tv1 = (TextView) findViewById(R.id.connectionStatus);
        tv1.setText(messageId);
        View view = findViewById(R.id.watch_connection_alert);
        view.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.i(TAG, "CREATE");

        mHomeFragment = new HomeFragment();
        mPluginsFragment = new PluginsFragment();
        mWatchsetsFragment = new WatchSetsFragment();

        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);

        getBottomToolbar().setVisibility(View.GONE);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
        // populate the navigation drawer
        // mNavigationDrawerFragment.setUserData("John Doe", "johndoe@doe.com", BitmapFactory.decodeResource(getResources(), R.drawable.avatar));

        final Context ctx = this;

        ImageButton findWatchButton = (ImageButton) findViewById(R.id.find_watch);
        findWatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(ctx, DeviceScanActivity.class);
                startActivityForResult(intent, SELECT_WATCH_REQUEST);
            }
        });

        Intent osswServiceIntent = new Intent(this, OsswService.class);
        startService(osswServiceIntent);
        bindService(osswServiceIntent, mServiceConnection, BIND_AUTO_CREATE);

        //    if (savedInstanceState == null) {
        //       onNavigationDrawerItemSelected(NavigationDrawerFragment.OPTION_WATCHSETS);
        //   }
        //Intent intent = new Intent();
        // intent.setAction("com.althink.android.ossw.plugins.musicplayer.PluginService");
        // bindService(intent, pluginServiceConnection, BIND_AUTO_CREATE);
    }

    @Override
    public void onNavigationDrawerItemSelected(int itemId) {
        switch (itemId) {
            case NavigationDrawerFragment.OPTION_HOME_SCREEN:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mHomeFragment)
                        .commit();
                break;
            case NavigationDrawerFragment.OPTION_WATCHSETS:
                setTitle(R.string.drawer_watchsets);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mWatchsetsFragment).commit();
                break;
            case NavigationDrawerFragment.OPTION_EXTENSIONS:
                setTitle(R.string.drawer_plugins);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mPluginsFragment).commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "RESUME");
        registerReceiver(mGattUpdateReceiver, makeGattUpdateIntentFilter());

        refreshConnectionAlert();
    }

    private void refreshConnectionAlert() {
        if (mOsswBleService != null) {
            int status = mOsswBleService.getStatus();
            setConnectionAlertBar(status);
        }
    }

    private void setConnectionAlertBar(int status) {
        if (status == OsswService.STATE_CONNECTED) {
            hideConnectionAlertBar();
        } else if (status == OsswService.STATE_CONNECTING || status == OsswService.STATE_SERVICE_DISCOVERING) {
            showConnectionAlertBar(R.string.connecting_to_watch);
        } else {
            showConnectionAlertBar(R.string.disconnected);
        }
    }

    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }

    private static IntentFilter makeGattUpdateIntentFilter() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(OsswService.ACTION_WATCH_CONNECTING);
        intentFilter.addAction(OsswService.ACTION_WATCH_CONNECTED);
        intentFilter.addAction(OsswService.ACTION_WATCH_DISCONNECTED);
        return intentFilter;
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mGattUpdateReceiver);
        //Log.i(TAG, "PAUSE");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Log.i(TAG, "DESTROY");
        unbindService(mServiceConnection);

//        unbindService(pluginServiceConnection);
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
                    if (address != null) {

                        //Log.i(TAG, "Connect to: " + address);
                        connectToWatch(address);
                    }
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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
        } else if (id == R.id.action_notifications) {
            Intent intent = new Intent
                    ("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            startActivity(intent);
            return true;
        } else if (id == R.id.action_settings) {
            final Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_close) {
            mOsswBleService.stopSelf();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public Toolbar getBottomToolbar() {
        if (mBottomToolbar == null) {
            mBottomToolbar = (Toolbar) findViewById(R.id.toolbar_bottom);
        }
        return mBottomToolbar;
    }

    public void resetBottomToolbar() {
        Toolbar bottomToolbar = this.getBottomToolbar();
        bottomToolbar.getMenu().clear();
        bottomToolbar.setNavigationIcon(null);
    }
}
