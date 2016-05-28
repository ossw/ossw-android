package com.althink.android.ossw.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.widget.Toast;

import com.althink.android.ossw.MainActivity;
import com.althink.android.ossw.R;
import com.althink.android.ossw.UploadDataType;
import com.althink.android.ossw.db.OsswDatabaseHelper;
import com.althink.android.ossw.notifications.NotificationHandler;
import com.althink.android.ossw.notifications.NotificationListener;
import com.althink.android.ossw.notifications.model.NotificationType;
import com.althink.android.ossw.plugins.PluginDefinition;
import com.althink.android.ossw.plugins.PluginFunctionDefinition;
import com.althink.android.ossw.plugins.PluginManager;
import com.althink.android.ossw.plugins.PluginPropertyDefinition;
import com.althink.android.ossw.service.ble.BleConnectionStatus;
import com.althink.android.ossw.service.ble.BleConnectionStatusHandler;
import com.althink.android.ossw.service.ble.BleDeviceService;
import com.althink.android.ossw.service.ble.CharacteristicChangeHandler;
import com.althink.android.ossw.service.ble.ReadCharacteristicHandler;
import com.althink.android.ossw.utils.FunctionHandler;
import com.althink.android.ossw.utils.StringNormalizer;
import com.althink.android.ossw.watch.WatchConstants;
import com.althink.android.ossw.watchsets.DataSourceType;
import com.althink.android.ossw.watchsets.WatchSetType;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OsswService extends Service {
    private final static String TAG = OsswService.class.getSimpleName();

    public final static UUID OSSW_SERVICE_UUID = UUID.fromString("58C60001-20B7-4904-96FA-CBA8E1B95702");
    public final static int NOTIFICATION_ID = 777;

    public static final int TEST_NOTIFICATION_ID = 0x10;
    public static final int TEST_ALERT_ID = 0x11;

    public static final String BASE_ID = "com.althink.android.ossw";
    public static final String FULLSCREEN_FAKE_ALARM_INTENT_ACTION = "com.althink.android.ossw.test.alert.fullScreen";
    public static final String CLOSE_FAKE_ALARM_INTENT_ACTION = "com.althink.android.ossw.test.alert.close";
    public static final String CLOSE_FAKE_NOTIFICATION_INTENT_ACTION = "com.althink.android.ossw.test.notification.close";

    private static final long[] disconnectPattern = {0, 100, 50, 100, 50, 100, 50, 200, 50, 200};
    private static boolean manualDisconnect = false;
    public final static String ACTION_WATCH_CONNECTING =
            "com.althink.android.ossw.ACTION_WATCH_CONNECTING";
    public final static String ACTION_WATCH_CONNECTED =
            "com.althink.android.ossw.ACTION_WATCH_CONNECTED";
    public final static String ACTION_WATCH_DISCONNECTED =
            "com.althink.android.ossw.ACTION_WATCH_DISCONNECTED";
    public final static String ACTION_WATCH_AUTO_RECONNECT =
            "com.althink.android.ossw.ACTION_WATCH_AUTO_RECONNECT";

    private final static int FILE_UPLOAD_NOTIFICATION_ID = 1;
    public static final int MAX_COMMAND_SIZE = 256;
    public static final String LAST_WATCH_ADDRESS = "last_watch_address";

    private static OsswService INSTANCE;

    private static MediaPlayer mediaPlayer;

    public static MediaPlayer getMediaPlayer() {
        if (mediaPlayer == null)
            mediaPlayer = new MediaPlayer();
        return mediaPlayer;
    }

    private boolean started = false;

    private NotificationHandler lastNotificationHandler = null;

    private BleDeviceService bleService;

    private WatchOperationContext watchContext;

    private Handler pluginPropertyHandler = new Handler();

    private List<PluginDefinition> plugins;

    private Map<String, ContentObserver> contentObservers = new HashMap<>();

    private Handler toastHandler = new Handler();

    private final HashMap<String, ExternalServiceConnection> externalServiceConnections = new HashMap<>();

    private AtomicInteger commandAck = new AtomicInteger();

    private boolean dataSynced = true;

    private ConcurrentHashMap<Integer, Object> extParamsToSend = new ConcurrentHashMap<>();
    private Map<Integer, Object> sentExtParamsCache = new HashMap<>();

    private ExecutorService extParamUploadExecutor = new ThreadPoolExecutor(1, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.DiscardPolicy());

    private CharacteristicChangeHandler characteristicChangeHandler = new CharacteristicChangeHandler() {
        @Override
        public void handleCharacteristicChange(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            byte[] value = characteristic.getValue();
            //Log.i(TAG, "onCharacteristicChanged: " + characteristic.getUuid() + ", " + Arrays.toString(value));
            if (value.length > 0) {
//                Log.d(TAG, "Handle command: " + Arrays.toString(value));
                switch (value[0]) {
                    case WatchConstants.OSSW_RX_COMMAND_SET_WATCH_SET_ID:
                        int watchSetId = value[1] << 24 | value[2] << 16 | value[3] << 8 | value[4] & 0xFF;
                        WatchOperationContext ctx = OsswDatabaseHelper.getInstance(getApplicationContext()).getWatchContextByExtWatchSetId(watchSetId);
                        setWatchOperationContext(ctx);
                        if (ctx != null) {
                            sendAllExternalParamsValues();
                        }
                        break;
                    case WatchConstants.OSSW_RX_COMMAND_INVOKE_EXTERNAL_FUNCTION:
                        invokeExtensionFunction(value[1]);
                        break;
                    case WatchConstants.OSSW_RX_COMMAND_INVOKE_NOTIFICATION_FUNCTION:
                        invokeNotificationFunction(value[1], Arrays.copyOfRange(value, 2, value.length));
                        break;
                    case WatchConstants.OSSW_RX_COMMAND_COMMAND_ACK:
                        synchronized (commandAck) {
                            commandAck.set(value[1] & 0xFF);
                            commandAck.notify();
                        }
                        break;
                }
            }
        }
    };

    private final BroadcastReceiver fakeAlertReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            NotificationManagerCompat notifyManager = NotificationManagerCompat.from(getApplicationContext());
            notifyManager.cancel(OsswService.TEST_ALERT_ID);
        }
    };

    private final BroadcastReceiver packageChangeReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            try {
                String action = intent.getAction();

                Uri uri = intent.getData();
                String pkg = uri != null ? uri.getSchemeSpecificPart() : null;
                //Log.i(TAG, "Package change filter: " + action + ", " + pkg);

                if (pkg == null) {
                    return;
                }

                //Log.i(TAG, "Remove all plugins from package: " + pkg);

                Iterator<PluginDefinition> i = plugins.iterator();
                while (i.hasNext()) {
                    PluginDefinition plugin = i.next();

                    if (pkg.equals(plugin.getPackageName())) {
                        i.remove();
                        disconnectFromPlugin(plugin);
                    }
                }

                if (!Intent.ACTION_PACKAGE_REMOVED.equals(action)) {
                    List<PluginDefinition> newPlugins = new PluginManager(context).findPlugins(pkg);
                    for (PluginDefinition plugin : newPlugins) {
                        //Log.i(TAG, "Found plugin: " + plugin.getPluginId());
                        connectToPlugin(plugin);
                    }
                    plugins.addAll(newPlugins);
                }
            } catch (Exception e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
    };

    private void sendAllExternalParamsValues() {
        int paramId = 0;
        for (WatchExtensionProperty property : watchContext.getExternalParameters()) {
            Object value = getPropertyFromExtension(property.getPluginId(), property.getPropertyId());
            if (value != null) {
                extParamsToSend.put(paramId, value);
            }
            paramId++;
        }
        scheduleExtParamUpdate();
    }

    private void resetSentExtParamsCache() {
        sentExtParamsCache.clear();
    }

    private void broadcastUpdate(final String action) {
        final Intent intent = new Intent(action);
        //Log.i(TAG, "Send Intent: " + intent);
        sendBroadcast(intent);
    }

    //  public int onStartCommand(Intent intent, int flags, int startId) {
    //      return START_STICKY;
    //  }

    public void setWatchOperationContext(WatchOperationContext watchContext) {
        this.watchContext = watchContext;
        resetSentExtParamsCache();
    }

    public void createOrUpdateWatchSet(WatchSetType type, String name, String source, WatchOperationContext watchContext, int id) {
        OsswDatabaseHelper.getInstance(getApplicationContext()).addWatchSet(type, name, source, watchContext, id);
    }

    public void extendAlertNotification(int notificationId, int timeout) {
        new NotificationRelatedAsyncTask().execute(NotificationOperation.EXTEND_ALERT, notificationId, timeout);
    }

    public void closeAlertNotification(int notificationId) {
        new NotificationRelatedAsyncTask().execute(NotificationOperation.CLOSE_ALERT, notificationId);
    }

    public void uploadNotification(int notificationId, NotificationType type, byte[] data, int vibrationPattern, int timeout, NotificationHandler handler) {
        new NotificationRelatedAsyncTask().execute(NotificationOperation.UPLOAD, notificationId, type, data, vibrationPattern, timeout, handler);
    }

    private class NotificationRelatedAsyncTask extends AsyncTask<Object, Void, Void> {

        @Override
        protected Void doInBackground(Object... params) {

            if (params[0] == NotificationOperation.UPLOAD) {
            }

            switch ((NotificationOperation) params[0]) {
                case UPLOAD:
                    internalUploadNotification((int) params[1], (NotificationType) params[2], (byte[]) params[3], (int) params[4], (int) params[5], (NotificationHandler) params[6]);
                    break;
                case EXTEND_ALERT:
                    sendOsswCommand(new byte[]{0x43, (byte) (((int) params[1]) >> 8), (byte) (((int) params[1]) & 0xFF), (byte) (((int) params[2]) >> 8), (byte) (((int) params[2]) & 0xFF)});
                    break;
                case CLOSE_ALERT:
                    //Log.i(TAG, "Close notification");
                    sendOsswCommand(new byte[]{0x44, (byte) (((int) params[1]) >> 8), (byte) (((int) params[1]) & 0xFF)});
                    break;
            }

            return null;
        }
    }

    private void writeDescriptor(BluetoothGattDescriptor descriptor) {
        bleService.writeDescriptor(descriptor);
    }

    private void writeCharacteristic(BluetoothGattCharacteristic characteristic, byte[] data) {
        bleService.writeCharacteristic(characteristic, data);
    }

    private enum NotificationOperation {
        UPLOAD, EXTEND_ALERT, CLOSE_ALERT
    }

    private void internalUploadNotification(int notificationId, NotificationType type, byte[] data, int vibrationPattern, int timeout, NotificationHandler handler) {

        if (type == NotificationType.UPDATE || type == NotificationType.INFO) {
            dataSynced = false;
        }

        if (!bleService.isConnected()) {
            return;
        }

        switch (type) {
            case ALERT:
                data = arrayConcatenate(new byte[]{
                                (byte) type.getValue(),
                                (byte) (notificationId >> 8),
                                (byte) (notificationId & 0xFF),
                                (byte) ((vibrationPattern >> 24) & 0xFF),
                                (byte) ((vibrationPattern >> 16) & 0xFF),
                                (byte) ((vibrationPattern >> 8) & 0xFF),
                                (byte) (vibrationPattern & 0xFF),
                                (byte) (timeout >> 8),
                                (byte) (timeout & 0xFF)},
                        data);
                break;
            case INFO:
                data = arrayConcatenate(new byte[]{
                                (byte) type.getValue(),
                                (byte) ((vibrationPattern >> 24) & 0xFF),
                                (byte) ((vibrationPattern >> 16) & 0xFF),
                                (byte) ((vibrationPattern >> 8) & 0xFF),
                                (byte) (vibrationPattern & 0xFF),
                                (byte) (timeout >> 8),
                                (byte) (timeout & 0xFF)},
                        data);
                break;
            case UPDATE:
            case DIALOG_SELECT:
            case DIALOG_OPTIONS:
            case DIALOG_CLOSE:
            case SLEEP_START:
            case SLEEP_STOP:
            case SLEEP_BATCH_SIZE:
                data = arrayConcatenate(new byte[]{
                                (byte) type.getValue()},
                        data);
                break;
        }
        int size = data.length;

        Log.d(TAG, "Notification data to upload: " + Arrays.toString(data));

        boolean allow;

        //Log.i(TAG, "Request notification upload permission");

        allow = sendOsswCommand(new byte[]{0x40, (byte) ((size >> 8) & 0xFF), (byte) (size & 0xFF)}) == 0;
        if (!allow) {
            //Log.i(TAG, "Upload NOT allowed, skip notification upload");
            return;
        } else {
            //Log.i(TAG, "Upload ALLOWED");
        }

        int sizeLeft = data.length;

        int dataPtr = 0;
        byte[] dataCommand = new byte[MAX_COMMAND_SIZE];
        dataCommand[0] = 0x41;
        while (sizeLeft > 0) {
            int dataInPacket = sizeLeft > (MAX_COMMAND_SIZE - 1) ? (MAX_COMMAND_SIZE - 1) : sizeLeft;

            for (int i = 0; i < dataInPacket; i++) {
                dataCommand[i + 1] = data[dataPtr++];
            }

            if (sendOsswCommand(dataCommand, dataInPacket + 1) < 0) {
                return;
            }

            sizeLeft -= (MAX_COMMAND_SIZE - 1);
        }
        if (sendOsswCommand(new byte[]{0x42}) < 0) {
            return;
        }
        //Log.i(TAG, "Commit notification");

        if (NotificationType.ALERT == type || NotificationType.DIALOG_SELECT == type || NotificationType.DIALOG_OPTIONS == type) {
            lastNotificationHandler = handler;
        } else {
            dataSynced = true;
        }
    }

    private static byte[] arrayConcatenate(byte[] first, byte[] second) {
        byte[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public class LocalBinder extends Binder {
        public OsswService getService() {
            return OsswService.this;
        }
    }

    public Object getPropertyFromExtension(String pluginId, String property) {
        PluginPropertyDefinition propertyDefinition = getPropertyDefinition(pluginId, property);
        if (propertyDefinition == null) {
            return null;
        }

        Cursor query = getContentResolver().query(Uri.parse("content://" + pluginId + "/properties"), new String[]{property}, null, null, null);
        if (query == null) {
            return null;
        }
        Object value = null;
        try {
            query.moveToNext();
            switch (propertyDefinition.getType()) {
                case ENUM:
                case INTEGER:
                    value = query.getInt(query.getColumnIndex(property));
                    break;
                case FLOAT:
                    value = query.getFloat(query.getColumnIndex(property));
                    break;
                case STRING:
                    value = query.getString(query.getColumnIndex(property));
                    break;
            }
        } finally {
            query.close();
        }
        return value;
    }

    private class PluginPropertyObserver extends ContentObserver {
        private final String TAG = "PluginPropertyObserver";
        private String pluginId;

        public PluginPropertyObserver(Handler handler, String pluginId) {
            super(handler);
            this.pluginId = pluginId;
        }

        @Override
        public void onChange(boolean selfChange) {
            //Log.d(TAG, "onChange: " + selfChange + ", plugin: " + pluginId);

            if (watchContext == null || watchContext.getExternalParameters() == null) {
                return;
            }

            int propertyId = 0;
            for (WatchExtensionProperty property : watchContext.getExternalParameters()) {
                if (property.getPluginId().equals(pluginId)) {
                    handleExternalPropertyChange(propertyId, property);
                }
                propertyId++;
            }
        }

        private void handleExternalPropertyChange(int propertyId, WatchExtensionProperty property) {
            Object value = getPropertyFromExtension(property.getPluginId(), property.getPropertyId());
            if (value != null) {
                extParamsToSend.put(propertyId, value);
                scheduleExtParamUpdate();
            }
        }
    }

    private PluginPropertyDefinition getPropertyDefinition(String pluginId, String propertyId) {
        for (PluginDefinition plugin : plugins) {
            if (plugin.getPluginId().equals(pluginId)) {
                for (PluginPropertyDefinition propertyDef : plugin.getProperties()) {
                    if (propertyDef.getName().equals(propertyId)) {
                        return propertyDef;
                    }
                }
            }
        }
        return null;
    }

    private Notification getCompatNotification(String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(getApplicationContext(), MainActivity.class), 0);
        int image = R.drawable.ic_watch_off;
        if (bleService != null && bleService.getConnectionStatus() == BleConnectionStatus.CONNECTED)
            image = R.drawable.ic_watch_dial;
        builder.setSmallIcon(image)
                .setContentTitle(getString(R.string.title_main))
                .setContentText(message)
                .setContentIntent(pendingIntent);
        return builder.build();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.i(TAG, "StartCommand called");

        synchronized (this) {

            if (!started) {
                startForeground(NOTIFICATION_ID, getCompatNotification("Starting"));
                Log.i(TAG, "Initialize service");
                bleService = new BleDeviceService(getApplicationContext(), new BleConnectionStatusHandler() {
                    @Override
                    public void handleConnectionStatusChange(BleConnectionStatus status) {
                        Log.i(TAG, "handleConnectionStatusChange: " + status);
                        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        switch (status) {
                            case DISCONNECTED:
                                broadcastUpdate(ACTION_WATCH_DISCONNECTED);
                                clearPendingCommands();
                                mNotificationManager.notify(NOTIFICATION_ID, getCompatNotification(getString(R.string.disconnected)));
                                SharedPreferences shPref = PreferenceManager.getDefaultSharedPreferences(OsswService.this);
                                boolean disconnectAlert = shPref.getBoolean("disconnect_alert", true);
                                if (disconnectAlert && !manualDisconnect) {
                                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                                    v.vibrate(disconnectPattern, -1);
                                }
                                break;
                            case CONNECTING:
                                broadcastUpdate(ACTION_WATCH_CONNECTING);
                                mNotificationManager.notify(NOTIFICATION_ID, getCompatNotification(getString(R.string.connecting)));
                                break;
                            case CONNECTED:
                                manualDisconnect = false;
                                resetSentExtParamsCache();
                                broadcastUpdate(ACTION_WATCH_CONNECTED);
                                mNotificationManager.notify(NOTIFICATION_ID, getCompatNotification(getString(R.string.connected)));

//                        // check version
                                Log.i(TAG, "Check FW version");
                                BluetoothGattService devInfoSrv = bleService.getService(UUID.fromString("0000180A-0000-1000-8000-00805F9B34FB"));
                                if (devInfoSrv == null) {
                                    disconnect();
                                }
                                BluetoothGattCharacteristic fwVerChar = devInfoSrv.getCharacteristic(UUID.fromString("00002A26-0000-1000-8000-00805F9B34FB"));
                                if (fwVerChar != null) {
                                    bleService.readCharacteristic(fwVerChar, new ReadCharacteristicHandler() {
                                        @Override
                                        public void handleValue(byte[] data) {
                                            Log.i(TAG, "FW version: " + new String(data));

                                            if (isFirmwareTooOld(new String(data))) {
                                                handleTooOldFirmware();
                                            } else {
                                                // supported firmware
                                                sendConnectionConfirmation();
                                            }
                                        }
                                    });
//                            //Log.i(TAG, "FW version: "+new String(fwVerChar.getUriValue()));
                                } else {
                                    Log.i(TAG, "Firmware version check not possible, too old firmware");
                                    handleTooOldFirmware();
                                }

                                bleService.setCharacteristicNotification(getOsswRxCharacteristic(), true);

                                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(OsswService.this);
                                boolean syncTime = sharedPref.getBoolean("synchronize_time", true);

                                if (syncTime) {
                                    sendCurrentTime();
                                }

                                if (!dataSynced) {
                                    NotificationListener.getInstance().sendNotifications();
                                }
                                break;
                            case AUTO_RECONNECT:
                                broadcastUpdate(ACTION_WATCH_AUTO_RECONNECT);
                                break;
                        }
                    }
                }, characteristicChangeHandler);

                plugins = new PluginManager(getApplicationContext()).findPlugins();
                for (PluginDefinition plugin : plugins) {
                    connectToPlugin(plugin);
                }

                IntentFilter filter = new IntentFilter();
                filter.addAction(Intent.ACTION_PACKAGE_ADDED);
                filter.addAction(Intent.ACTION_PACKAGE_REPLACED);
                filter.addAction(Intent.ACTION_PACKAGE_RESTARTED);
                filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
                filter.addDataScheme("package");
                registerReceiver(packageChangeReceiver, filter);
                registerReceiver(fakeAlertReceiver, new IntentFilter(CLOSE_FAKE_ALARM_INTENT_ACTION));
                registerReceiver(declineCallReceiver, new IntentFilter(CallReceiver.DECLINE_CALL_INTENT_ACTION));
                registerReceiver(muteCallReceiver, new IntentFilter(CallReceiver.MUTE_CALL_INTENT_ACTION));

                started = true;
                INSTANCE = this;
            }

            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            String address = sharedPref.getString(OsswService.LAST_WATCH_ADDRESS, null);
//            Log.i(TAG, "Last known device: " + address);
//            Log.i(TAG, "Connected: " + bleService.isConnected());
            if (address != null && !bleService.isConnected()) {
                Log.i(TAG, "Connect to last known device: " + address);
                bleService.connect(address, true);
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

    private final BroadcastReceiver declineCallReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            CallReceiver.declineCall();
            SharedPreferences shPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            boolean enabled = shPref.getBoolean("pref_reject_call_message", false);
            if (enabled) {
                Log.d(TAG, "Send an SMS after call declined.");
                final Bundle extras = intent.getExtras();
                if (extras != null) {
                    final String number = extras.getString(CallReceiver.INCOMING_CALL_NUMBER);
                    FunctionHandler.selectPredefinedSmsSend(number);
                }
            }
        }
    };

    private final BroadcastReceiver muteCallReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            PhoneCallReceiver.setMutedMode(context);
        }
    };

    private void sendConnectionConfirmation() {
        if (!bleService.isConnected()) {
            return;
        }

        BluetoothGattCharacteristic txCharact = getOsswTxCharacteristic();
        if (txCharact == null) {
            return;
        }

        writeCharacteristic(txCharact, new byte[]{0x01});
    }

    private void connectToPlugin(PluginDefinition plugin) {
        //Log.i(TAG, "Connect to plugin: " + plugin.getPluginId());
        ExternalServiceConnection connection = new ExternalServiceConnection();

        // bind plugin service
        Intent serviceIntent = new Intent();
        serviceIntent.setAction(plugin.getPluginId());
        serviceIntent.setPackage(plugin.getPluginId());
        bindService(serviceIntent, connection.getConnection(), BIND_AUTO_CREATE);
        externalServiceConnections.put(plugin.getPluginId(), connection);

        // listen on plugin property change
        PluginPropertyObserver observer = new PluginPropertyObserver(pluginPropertyHandler, plugin.getPluginId());
        Uri contentUri = Uri.parse("content://" + plugin.getPluginId() + "/properties");
        //Log.i(TAG, "Register pluginPropertyHandler for uri: " + contentUri);
        getApplicationContext().getContentResolver().registerContentObserver(contentUri, false, observer);
        contentObservers.put(plugin.getPluginId(), observer);
    }

    private void disconnectFromPlugin(PluginDefinition plugin) {
        //Log.i(TAG, "Disconnect from plugin: " + plugin.getPluginId());
        ExternalServiceConnection extConn = externalServiceConnections.remove(plugin.getPluginId());
        if (extConn != null) {
            unbindService(extConn.getConnection());
        }
        ContentObserver contentObserver = contentObservers.remove(plugin.getPluginId());
        if (contentObserver != null) {
            getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    private void clearPendingCommands() {
    }

    private boolean isFirmwareTooOld(String version) {
        String[] parts = version.split("\\.");
        if (Integer.parseInt(parts[0]) == 0 && Integer.parseInt(parts[1]) >= 4) {
            return false;
        }
        return Integer.parseInt(parts[0]) == 0;
    }

    private void handleTooOldFirmware() {
        Log.i(TAG, "Firmware is too old!");

        toastHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), getString(R.string.toast_not_supported_firmware), Toast.LENGTH_SHORT).show();
            }
        });

        disconnect();
    }

    private void invokeNotificationFunction(int functionId, byte[] data) {
        NotificationListener nl = NotificationListener.getInstance();
        switch (functionId) {
            case WatchConstants.NOTIFICATIONS_FUNCTION_ALERT_DISMISS:
            case WatchConstants.NOTIFICATIONS_FUNCTION_ALERT_OPTION_1:
            case WatchConstants.NOTIFICATIONS_FUNCTION_ALERT_OPTION_2:
                if (lastNotificationHandler != null) {
                    lastNotificationHandler.handleFunction(functionId);
                    lastNotificationHandler = null;
                }
                break;
            case WatchConstants.DIALOG_RESULT:
                if (lastNotificationHandler != null) {
                    lastNotificationHandler.handleFunction((int) 0xff & data[1]);
                    lastNotificationHandler = null;
                }
                break;
            case WatchConstants.NOTIFICATIONS_SHOW_FIRST:
                //Log.i(TAG, "NOTIFICATIONS_FIRST");

                if (nl != null) {
                    nl.sendFirstNotification();
                }
                break;
            case WatchConstants.NOTIFICATIONS_NEXT_PART:
                //Log.i(TAG, "NOTIFICATIONS_NEXT_PART");

                if (nl != null) {
                    int notificationId = data[0] << 8 | data[1];
                    int part = data[2] & 0xFF;
                    nl.sendNotificationPart(notificationId, part + 1);
                }
                break;
            case WatchConstants.NOTIFICATIONS_PREV_PART:
                //Log.i(TAG, "NOTIFICATIONS_PREV_PART");

                if (nl != null) {
                    int notificationId = data[0] << 8 | data[1];
                    int part = data[2] & 0xFF;
                    nl.sendNotificationPart(notificationId, part - 1);
                }
                break;

            case WatchConstants.NOTIFICATIONS_NEXT:
                //Log.i(TAG, "NOTIFICATIONS_NEXT");

                if (nl != null) {
                    int notificationId = data[0] << 8 | data[1];
                    nl.sendNextNotification(notificationId);
                }
                break;

            case WatchConstants.NOTIFICATIONS_OPEN:
                //Log.i(TAG, "NOTIFICATIONS_NEXT");

                if (nl != null) {
                    int notificationId = data[0] << 8 | data[1];
                    nl.openNotification(notificationId);
                }
                break;

            case WatchConstants.NOTIFICATIONS_FUNCTION_RESEND:
                if (nl != null) {
                    nl.openNotificationsScreen();
                }
                break;
            default:
                FunctionHandler.handleFunction(functionId, data);
        }
    }

    private void invokeExtensionFunction(int extFunctionId) {
        if (watchContext == null || extFunctionId < 0 || watchContext.getExternalFunctions() == null || watchContext.getExternalFunctions().size() <= extFunctionId) {
            return;
        }
        WatchExtensionFunction function = watchContext.getExternalFunctions().get(extFunctionId);
        Log.i(TAG, "Function invoked: " + function);
        invokeExtensionFunction(function.getPluginId(), function.getFunctionId(), function.getParameter());
    }

    public void invokeExtensionFunction(String extensionId, String functionName, String parameter) {
        ExternalServiceConnection connection = externalServiceConnections.get(extensionId);
        if (connection == null) {
            //Log.e(TAG, "Service " + extensionId + " is not connected");
            return;
        }
        try {
            Integer functionId = findFunctionId(extensionId, functionName);
            if (functionId != null) {
                Message message = Message.obtain(null, functionId, 0, 0);
                Bundle b = new Bundle();
                b.putString("parameter", parameter);
                message.setData(b);
                connection.getMessanger().send(message);
            }
        } catch (Exception e) {
            //Log.e(TAG, e.getMessage(), e);
        }
    }

    private Integer findFunctionId(String extensionId, String functionName) {
        for (PluginDefinition def : plugins) {
            if (def.getPluginId().equals(extensionId)) {
                for (PluginFunctionDefinition func : def.getFunctions()) {
                    if (func.getName().equals(functionName)) {
                        return func.getId();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public IBinder onBind(Intent intent) {
        //Log.i(TAG, "Service bind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        //Log.i(TAG, "Service unbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Service destroyed");
        // After using a given device, you should make sure that BluetoothGatt.close() is called
        // such that resources are cleaned up properly.  In this particular example, close() is
        // invoked when the UI is disconnected from the Service.
        for (ExternalServiceConnection connection : externalServiceConnections.values()) {
            unbindService(connection.getConnection());
        }
        externalServiceConnections.clear();
        for (ContentObserver observer : contentObservers.values()) {
            getContentResolver().unregisterContentObserver(observer);
        }
        contentObservers.clear();
        unregisterReceiver(packageChangeReceiver);
        unregisterReceiver(fakeAlertReceiver);
        unregisterReceiver(declineCallReceiver);
        unregisterReceiver(muteCallReceiver);
        close();
        started = false;
        INSTANCE = null;
        NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nManager.cancel(NOTIFICATION_ID);
        super.onDestroy();
    }

    private final IBinder mBinder = new LocalBinder();

    public static class BluetoothDeviceSummary {
        String name = "Unknown";
        String address = "";
        //        String sync = "";
        int rssi = 0;

        public BluetoothDeviceSummary(String name, String address, /*String sync, */int rssi) {
            this.name = name;
            this.address = address;
//            this.sync = sync;
            this.rssi = rssi;
        }

        public String getAddress() {
            return address;
        }

        public String getName() {
            return name;
        }

        public BleConnectionStatus getSync() {
            return INSTANCE.getStatus(address);
        }

        public int getRSSI() {
            return rssi;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof BluetoothDeviceSummary) {
                if (address.equals(((BluetoothDeviceSummary) o).address))
                    return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return address.hashCode();
        }
    }

    // Get the list of synchronized devices
    public List<BluetoothDeviceSummary> getBondedDevices() {
        // TODO: add support for multiple simultaneous devices (for now the last one is returned)
        List<BluetoothDeviceSummary> bleDevices = new ArrayList<>();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(OsswService.this);
        String address = sharedPref.getString(LAST_WATCH_ADDRESS, "");
        if (address.isEmpty())
            return bleDevices;
//        String sync = bleService.isConnected() ?
//                getString(R.string.connected) : getString(R.string.disconnected);
        BluetoothDeviceSummary bd = new BluetoothDeviceSummary(
                bleService.getBluetoothDevice().getName(), address, /*sync,*/ 0);
        bleDevices.add(bd);
        return bleDevices;
    }

    public BleConnectionStatus getStatus(String address) {
        return bleService.getStatus(address);
    }

    /**
     * Connects to the GATT server hosted on the Bluetooth LE device.
     *
     * @param address The device address of the destination device.
     * @return Return true if the connection is initiated successfully. The connection result
     * is reported asynchronously through the
     * {@code BluetoothGattCallback#onConnectionStateChange(android.bluetooth.BluetoothGatt, int, int)}
     * callback.
     */
    public boolean connect(final String address) {
        Log.i(TAG, "Connect");

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(OsswService.this);
        sharedPref.edit().putString(LAST_WATCH_ADDRESS, address).apply();
        return bleService.connect(address, true);
    }

    /**
     * Disconnects an existing connection or cancel a pending connection. The disconnection result
     * is reported asynchronously through the
     * {@code BluetoothGattCallback#onConnectionStateChange(android.bluetooth.BluetoothGatt, int, int)}
     * callback.
     */
    public void disconnect() {
        Log.i(TAG, "Disconnect");
        manualDisconnect = true;
        // we don't want to automatically connect to the watch that was disconnected by the user
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(OsswService.this);
        sharedPref.edit().remove(LAST_WATCH_ADDRESS).apply();
        bleService.disconnect();
    }

    /**
     * After using a given BLE device, the app must call this method to ensure resources are
     * released properly.
     */
    public void close() {
        Log.i(TAG, "Close ble service");
        bleService.close();
    }

    public BleConnectionStatus getStatus() {
        return bleService.getConnectionStatus();
    }

    private class UploadDataToWatch extends AsyncTask<Object, Void, Void> {

        @Override
        protected Void doInBackground(Object... params) {
            internalUploadData((UploadDataType) params[0], (String) params[1], (byte[]) params[2]);
            return null;
        }
    }

    public void uploadData(UploadDataType type, String fileName, byte[] data) {
        new UploadDataToWatch().execute(type, fileName, data);
    }

    private void internalUploadData(UploadDataType type, String fileName, byte[] data) {

        if (!bleService.isConnected()) {
            Log.i(TAG, "BLE is not connected, cancel upload");
            handleUploadFailed();
            return;
        }

        NotificationManagerCompat notifyManager = NotificationManagerCompat.from(getApplicationContext());
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Watchset upload")
                .setContentText("Upload in progress")
                .setSmallIcon(R.drawable.ic_file_upload_black_18dp);
        notifyManager.notify(FILE_UPLOAD_NOTIFICATION_ID, builder.build());

        String path = "";
        switch (type) {
            case APPLICATION:
                path = "a/";
                break;
            case WATCH_FACE:
                path = "f/";
                break;
            case UTILITY:
                path = "u/";
                break;
        }
        byte[] filePath = cutToBytes(path + fileName, 31);
        int size = data.length;
        Log.i(TAG, "Init file upload: " + type + ", size: " + size);
        if (sendOsswCommand(concat(new byte[]{0x20, (byte) ((size >> 16) & 0xFF), (byte) ((size >> 8) & 0xFF), (byte) (size & 0xFF)}, concat(filePath, new byte[]{0}))) != 0) {
            handleUploadFailed();
            return;
        }

        List<byte[]> chunks = divideArray(data, 255);

        int chunkNo = 0;
        for (byte[] chunk : chunks) {
            byte[] commandData = concat(new byte[]{0x21}, chunk);

            //Log.i(TAG, "Send data chunk");

            builder.setProgress(100, 100 * chunkNo / chunks.size(), false);
            notifyManager.notify(FILE_UPLOAD_NOTIFICATION_ID, builder.build());

            if (sendOsswCommand(commandData) != 0) {
                handleUploadFailed();
                return;
            }
            chunkNo++;
        }

        if (sendOsswCommand(new byte[]{0x22}) == 0) {
            //Log.i(TAG, "Data uploaded successfully");
            toastHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), getString(R.string.toast_file_uploaded_successfully), Toast.LENGTH_SHORT).show();
                }
            });

            notifyManager.cancel(FILE_UPLOAD_NOTIFICATION_ID);
        } else {
            handleUploadFailed();
        }

    }

    private void handleUploadFailed() {
        Log.e(TAG, "Last command failed, cancel data upload");

        NotificationManagerCompat notifyManager = NotificationManagerCompat.from(getApplicationContext());
        notifyManager.cancel(FILE_UPLOAD_NOTIFICATION_ID);

        toastHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), getString(R.string.toast_file_upload_failed), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public int sendOsswCommand(byte[] commandData) {
        return sendOsswCommand(commandData, commandData.length);
    }

    public int sendOsswCommand(byte[] commandData, int length) {
        //Log.i(TAG, "Send command: " + bytesToHex(commandData));

        if (!bleService.isConnected()) {
            return -1;
        }

        int dataPtr = 0;
        int sizeLeft = length;


        BluetoothGattCharacteristic txCharact = getOsswTxCharacteristic();
        if (txCharact == null) {
            return -2;
        }

        while (sizeLeft > 0) {
            int dataInPacket = sizeLeft > 19 ? 19 : sizeLeft;
            byte[] bleData = new byte[dataInPacket + 1];

            if (sizeLeft <= 19) {
                if (sizeLeft == length) {
                    //only chunk (both first and last)
                    bleData[0] = 0x43;
                } else {
                    //last chunk
                    bleData[0] = 0x42;
                }
            } else if (sizeLeft == length) {
                //first chunk
                bleData[0] = 0x40;
            } else {
                //central chunk
                bleData[0] = 0x41;
            }

            for (int i = 0; i < dataInPacket; i++) {
                bleData[i + 1] = commandData[dataPtr++];
            }

            writeCharacteristic(txCharact, bleData);

            sizeLeft -= 19;
        }

        return waitForCommandAck();
    }

    public static byte[] concat(byte[] first, byte[] second) {
        byte[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    private int waitForCommandAck() {
        try {
            synchronized (commandAck) {
                commandAck.set(-1);
                commandAck.wait(10000);
                return commandAck.get();
            }
        } catch (InterruptedException e) {
            Log.e(TAG, "Failed to receive command ACK");
            return -1;
        }
    }

    private static List<byte[]> divideArray(byte[] source, int chunksize) {

        List<byte[]> result = new ArrayList<>();
        int start = 0;
        while (start < source.length) {
            int end = Math.min(source.length, start + chunksize);
            result.add(Arrays.copyOfRange(source, start, end));
            start += chunksize;
        }

        return result;
    }

    private void sendCurrentTime() {

        if (!bleService.isConnected()) {
            return;
        }

        BluetoothGattCharacteristic txCharact = getOsswTxCharacteristic();
        if (txCharact == null) {
            return;
        }

        SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));
        SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

        try {
            Date date = dateFormatGmt.parse(dateFormatLocal.format(new Date()));
            int currentTime = (int) (date.getTime() / 1000);
            //Log.i(TAG, "Set current time");
            writeCharacteristic(txCharact, new byte[]{0x10, (byte) (currentTime >> 24), (byte) ((currentTime >> 16) & 0xFF), (byte) ((currentTime >> 8) & 0xFF), (byte) (currentTime & 0xFF)});
        } catch (Exception e) {
            // do nothing
        }

    }

    private BluetoothGattCharacteristic getOsswTxCharacteristic() {
        BluetoothGattService service = bleService.getService(OSSW_SERVICE_UUID);
        if (service == null) {
            return null;
        }
        return service
                .getCharacteristic(UUID.fromString("58C60002-20B7-4904-96FA-CBA8E1B95702"));
    }

    private BluetoothGattCharacteristic getOsswRxCharacteristic() {
        BluetoothGattService service = bleService.getService(OSSW_SERVICE_UUID);
        if (service == null) {
            return null;
        }
        return service
                .getCharacteristic(UUID.fromString("58C60003-20B7-4904-96FA-CBA8E1B95702"));
    }

    public static OsswService getInstance() {
        return INSTANCE;
    }

    public void scheduleExtParamUpdate() {
        extParamUploadExecutor.submit(new Runnable() {
            @Override
            public void run() {
                sendExternalParamsToWatch();
            }
        });
    }

    private int calcExternalPropertySize(DataSourceType type, int range) {
        switch (type) {
            case NUMBER:
                return range >> 5;
            case STRING:
                return range + 1;
        }
        return 0;
    }

    private void sendExternalParamsToWatch() {

        WatchOperationContext ctx = watchContext;
        if (ctx == null || ctx.getExternalParameters() == null) {
            //       return;
        }

        if (!bleService.isConnected()) {
            return;
        }

        //Log.i(TAG, "Update property: " + property.getPropertyId() + " with value " + value);

        HashMap<Integer, Object> paramsCopy = new HashMap<>(extParamsToSend);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        os.write(0x30); // command id

        for (Map.Entry<Integer, Object> entry : paramsCopy.entrySet()) {

            byte paramId = entry.getKey().byteValue();
            Object value = entry.getValue();
            if (entry.getValue() == null || entry.getValue().equals(sentExtParamsCache.get(entry.getKey())) || paramId >= ctx.getExternalParameters().size()) {
                extParamsToSend.remove(entry.getKey(), value);
                //Log.i(TAG, "Skip param: " + paramId);
                continue;
            }
            //Log.i(TAG, "Send param: " + paramId);
            WatchExtensionProperty property = ctx.getExternalParameters().get(paramId);

            switch (property.getType()) {
                case NUMBER:
                    Integer intValue = buildIntValue(value, property.getRange());
                    int fieldSize = calcExternalPropertySize(property.getType(), property.getRange());

                    if (os.size() + 2 + fieldSize > MAX_COMMAND_SIZE) {
                        // no more space in command
                        break;
                    }

                    os.write(paramId);
                    os.write(fieldSize);
                    switch (fieldSize) {
                        case 4:
                            os.write((intValue) >> 24 & 0xFF);
                        case 3:
                            os.write((intValue) >> 16 & 0xFF);
                        case 2:
                            os.write((intValue) >> 8 & 0xFF);
                        case 1:
                            os.write((intValue) & 0xFF);
                    }
                    break;
                case STRING:
                    String v = (String) value;
                    v = StringNormalizer.removeAccents(v);
                    byte[] data = cutToBytes(v, property.getRange());

                    if (os.size() + 2 + data.length > MAX_COMMAND_SIZE) {
                        // no more space in command
                        break;
                    }

                    os.write(paramId);
                    os.write(data.length);
                    os.write(data, 0, data.length);
                    break;
            }
            sentExtParamsCache.put(entry.getKey(), value);
            extParamsToSend.remove(entry.getKey(), value);
        }

        if (os.size() > 1) {
            // at least one parameter was set
            sendOsswCommand(os.toByteArray());
        }

        //  Log.i(TAG, "Write: " + value + ", result: " + status);
    }

    private byte[] cutToBytes(String s, int charLimit) {
        byte[] utf8 = s.getBytes();
        if (utf8.length <= charLimit) {
            return utf8;
        }
        if ((utf8[charLimit] & 0x80) == 0) {
            // the limit doesn't cut an UTF-8 sequence
            return Arrays.copyOf(utf8, charLimit);
        }
        int i = 0;
        while ((utf8[charLimit - i - 1] & 0x80) > 0 && (utf8[charLimit - i - 1] & 0x40) == 0) {
            ++i;
        }
        if ((utf8[charLimit - i - 1] & 0x80) > 0) {
            // we have to skip the starter UTF-8 byte
            return Arrays.copyOf(utf8, charLimit - i - 1);
        } else {
            // we passed all UTF-8 bytes
            return Arrays.copyOf(utf8, charLimit - i);
        }
    }

    private Integer buildIntValue(Object value, int range) {
        if (value instanceof Integer) {
            return ((Integer) value) * pow(10, range & 0xF);
        } else if (value instanceof Float) {
            BigDecimal decimal = new BigDecimal(((float) value) * pow(10, range & 0xF));
            return decimal.setScale(0, RoundingMode.HALF_UP).intValue();
        }
        return 0;
    }

    private Integer pow(int x, int n) {
        int val = 1;
        for (int i = 0; i < n; i++) {
            val *= x;
        }
        return val;
    }

    private String buildCachePropertyKey(String pluginId, String propertyId) {
        return pluginId + ":" + propertyId;
    }

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 3];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 3] = hexArray[v >>> 4];
            hexChars[j * 3 + 1] = hexArray[v & 0x0F];
            hexChars[j * 3 + 2] = ' ';
        }
        return new String(hexChars);
    }
}
