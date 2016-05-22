package com.althink.android.ossw.utils;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.BaseColumns;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.althink.android.ossw.OsswApp;
import com.althink.android.ossw.R;
import com.althink.android.ossw.db.OsswDatabaseHelper;
import com.althink.android.ossw.notifications.message.DialogSelectMessageBuilder;
import com.althink.android.ossw.notifications.message.NotificationMessageBuilder;
import com.althink.android.ossw.notifications.model.NotificationType;
import com.althink.android.ossw.service.CallReceiver;
import com.althink.android.ossw.service.OsswService;
import com.althink.android.ossw.watch.WatchConstants;
import com.google.common.collect.Sets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by Pavel on 25/12/2015.
 */
public class FunctionHandler {
    private final static String TAG = FunctionHandler.class.getSimpleName();
    public static final String PREFERENCE_PHONE_DISCOVERY_AUDIO = "phone_discovery_audio";
    public static final String PREFERENCE_PHONE_DISCOVERY_VIBRATE = "phone_discovery_vibrate";
    private static final long[] discoveryVibration = {200, 500};
    private static final int PHONE_NUMBER_MAX = 26;
    private static boolean phoneDiscoveryStarted = false;
    private static LinkedHashSet<String> lastNumbers = Sets.newLinkedHashSet();
    private static int sendSmsPage = 0;
    private static String sendSmsNumber;
    private static List<String> sendSmsMessages;

    public static void handleFunction(int functionId, byte[] data) {
//        Log.d(TAG, "Function handler, id: " + functionId + ", data" + data);
        switch (functionId) {
            case WatchConstants.PHONE_FUNCTION_PHONE_DISCOVERY: {
                MediaPlayer mediaPlayer = OsswService.getMediaPlayer();
                OsswService osswService = OsswService.getInstance();
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(osswService.getApplicationContext());
                Vibrator v = (Vibrator) osswService.getSystemService(Context.VIBRATOR_SERVICE);
                if (phoneDiscoveryStarted) {
                    Log.d(TAG, "Phone discovery: " + phoneDiscoveryStarted + ", stopping");
                    phoneDiscoveryStarted = false;
                    if (mediaPlayer.isPlaying())
                        mediaPlayer.stop();
                    v.cancel();
                } else {
                    Log.d(TAG, "Phone discovery: " + phoneDiscoveryStarted + ", starting");
                    phoneDiscoveryStarted = true;
                    String uriValue = sharedPref.getString(PREFERENCE_PHONE_DISCOVERY_AUDIO, null);
                    if (uriValue != null && !uriValue.isEmpty()) {
                        Uri uri = Uri.parse(uriValue);
                        Log.d(TAG, "Phone discovery, audio track: " + uri);
                        mediaPlayer.reset();
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        try {
                            mediaPlayer.setDataSource(OsswApp.getContext(), uri);
                            mediaPlayer.prepare();
                            mediaPlayer.start();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    boolean vibrate = sharedPref.getBoolean(PREFERENCE_PHONE_DISCOVERY_VIBRATE, true);
                    if (vibrate) {
                        v.vibrate(discoveryVibration, 0);
                    }
                }
                break;
            }
            case WatchConstants.PHONE_FUNCTION_REJECT_SMS: {
                int buttons = 0;
                int item = 0;
                if (data.length == 2) {
                    buttons = data[0];
                    item = data[1];
                    closeDialog();
                    if ((buttons & WatchConstants.BUTTON_SELECT) != 0) {
                        CallReceiver.sendSMS(sendSmsNumber, sendSmsMessages.get(item));
                    }
                }
                break;
            }
            case WatchConstants.PHONE_FUNCTION_SEND_SMS: {
                int buttons = 0;
                int item = 0;
                if (data.length == 2) {
                    buttons = data[0];
                    item = data[1];
                    if ((buttons & WatchConstants.BUTTON_SELECT) != 0) {
                        if (sendSmsPage == 0) {
                            sendSmsNumber = new ArrayList<>(lastNumbers).get(item);
                            Log.d(TAG, "Number selected: " + sendSmsNumber + ", position: " + item);
                            selectPredefinedSms(WatchConstants.PHONE_FUNCTION_SEND_SMS);
                            sendSmsPage = 1;
                        } else if (sendSmsPage == 1) {
                            closeDialog();
                            CallReceiver.sendSMS(sendSmsNumber, sendSmsMessages.get(item));
                        }
                    } else if ((buttons & WatchConstants.BUTTON_BACK) != 0) {
                        if (sendSmsPage == 0) {
                            closeDialog();
                        } else if (sendSmsPage == 1) {
                            sendSmsPage = 0;
                            selectCallLogNumber(WatchConstants.PHONE_FUNCTION_SEND_SMS);
                        }
                    }
                } else {
                    sendSmsPage = 0;
                    selectCallLogNumber(WatchConstants.PHONE_FUNCTION_SEND_SMS);
                }
                break;
            }
            case WatchConstants.PHONE_FUNCTION_CALL_CONTACT: {
                int buttons = 0;
                int item = 0;
                Log.d(TAG, "Call contact function, buttons: " + buttons + ", position: " + item);
                if (data.length == 2) {
                    buttons = data[0];
                    item = data[1];
                    closeDialog();
                    if ((buttons & WatchConstants.BUTTON_SELECT) != 0) {
                        String number = new ArrayList<>(lastNumbers).get(item);
                        Log.d(TAG, "Number selected: " + number + ", position: " + item);
                        CallReceiver.callNumber(number);
                    }
                } else
                    selectCallLogNumber(WatchConstants.PHONE_FUNCTION_CALL_CONTACT);
                break;
            }
            case WatchConstants.PHONE_FUNCTION_GTASKS: {
                int buttons = 0;
                int item = 0;
                if (data.length == 2) {
                    buttons = data[0];
                    item = data[1];
                }
                TasksManager.getInstance().handle(buttons, item);
                break;
            }
            case WatchConstants.PHONE_FUNCTION_ACCELEROMETER: {
                Accelerometer.getInstance().handle(data);
                break;
            }
            case WatchConstants.PHONE_FUNCTION_SLEEP_AS_ANDROID: {
                SleepAsAndroid.getInstance().handle(data);
                break;
            }
        }
    }

    private static String extractNumber(String contact) {
        String[] ss = contact.split("\\s+");
        return ss[ss.length - 1];
    }

    public static void closeDialog() {
        Log.d(TAG, "Closing dialog");
        OsswService.getInstance().uploadNotification(0, NotificationType.DIALOG_CLOSE, new byte[0], 0, 0, null);
    }

    public static void selectPredefinedSmsSend(String number) {
        sendSmsNumber = number;
        selectPredefinedSms(WatchConstants.PHONE_FUNCTION_REJECT_SMS);
    }

    public static void selectPredefinedSms(int token) {
        OsswService osswService = OsswService.getInstance();
        sendSmsMessages = OsswDatabaseHelper.getInstance(osswService.getApplicationContext()).getPredefinedMessages();
        if (sendSmsMessages == null || sendSmsMessages.size() == 0)
            return;
        Log.d(TAG, "Choose between several predefined SMS: " + sendSmsMessages.toString());
        NotificationMessageBuilder builder = new DialogSelectMessageBuilder(OsswApp.getContext().getString(R.string.sms_title), sendSmsMessages, 0, token, 0);
        osswService.uploadNotification(0, NotificationType.DIALOG_SELECT, builder.build(), 0, 0, null);
    }

    public static void selectCallLogNumber(int token) {
        // Fetches the complete call log in descending order. i.e recent calls appears first.
        String[] projection = new String[]{CallLog.Calls.NUMBER, CallLog.Calls.DATE};
        Context context = OsswService.getInstance().getApplicationContext();
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Cursor c = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, projection, null,
                null, CallLog.Calls.DATE + " DESC");
        lastNumbers.clear();
        if (c.getCount() > 0) {
            c.moveToFirst();
            int count = 0;
            int colIndex = c.getColumnIndex(CallLog.Calls.NUMBER);
            do {
                String callerNumber = c.getString(colIndex);
                if (lastNumbers.add(callerNumber))
                    count++;
            } while (c.moveToNext() && count < PHONE_NUMBER_MAX);
            if (lastNumbers.size() == 0)
                return;
            List<String> items = new ArrayList<>();
            for (String number : lastNumbers) {
                items.add(getContactDisplayNameByNumber(context, number) + " " + number);
            }
            Log.d(TAG, "Choose between numbers in call log: " + items.toString());
            NotificationMessageBuilder builder = new DialogSelectMessageBuilder(OsswApp.getContext().getString(R.string.contact_title), items, 0, token, 0);
            OsswService.getInstance().uploadNotification(0, NotificationType.DIALOG_SELECT, builder.build(), 0, 0, null);
        }
    }

    public static String getContactDisplayNameByNumber(Context context, String number) {
        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(number));
        String name = "?";

        ContentResolver contentResolver = context.getContentResolver();
        Cursor contactLookup = contentResolver.query(uri, new String[]{BaseColumns._ID,
                ContactsContract.PhoneLookup.DISPLAY_NAME}, null, null, null);

        try {
            if (contactLookup != null && contactLookup.getCount() > 0) {
                contactLookup.moveToNext();
                name = contactLookup.getString(contactLookup.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
                //String contactId = contactLookup.getString(contactLookup.getColumnIndex(BaseColumns._ID));
            }
        } finally {
            if (contactLookup != null) {
                contactLookup.close();
            }
        }

        return name;
    }
}
