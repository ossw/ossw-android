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

import com.althink.android.ossw.notifications.DialogSelectHandler;
import com.althink.android.ossw.notifications.message.DialogSelectMessageBuilder;
import com.althink.android.ossw.notifications.message.NotificationMessageBuilder;
import com.althink.android.ossw.notifications.model.NotificationType;
import com.althink.android.ossw.service.CallReceiver;
import com.althink.android.ossw.service.OsswService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pavel on 25/12/2015.
 */
public class FunctionHandler {
    private final static String TAG = FunctionHandler.class.getSimpleName();
    public static final String FUNCTION_PHONE_DISCOVERY = "phone.discovery";
    public static final String FUNCTION_SEND_SMS = "send.sms";
    public static final String PREFERENCE_PHONE_DISCOVERY_AUDIO = "phone_discovery_audio";
    public static final String PREFERENCE_PHONE_DISCOVERY_VIBRATE = "phone_discovery_vibrate";
    private static final long[] discoveryVibration = {200, 500};
    private static boolean phoneDiscoveryStarted = false;

    public static void handleFunction(String functionId, String parameter) {
        if (FUNCTION_PHONE_DISCOVERY.equals(functionId)) {
            MediaPlayer mediaPlayer = OsswService.getMediaPlayer();
            OsswService osswService = OsswService.getInstance();
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(osswService.getApplicationContext());
            Vibrator v = (Vibrator) osswService.getSystemService(Context.VIBRATOR_SERVICE);
            if (phoneDiscoveryStarted) {
                Log.i(TAG, "Phone discovery: " + phoneDiscoveryStarted + ", stopping");
                phoneDiscoveryStarted = false;
                if (mediaPlayer.isPlaying())
                    mediaPlayer.stop();
                v.cancel();
            } else {
                Log.i(TAG, "Phone discovery: " + phoneDiscoveryStarted + ", starting");
                phoneDiscoveryStarted = true;
                String uriValue = sharedPref.getString(PREFERENCE_PHONE_DISCOVERY_AUDIO, null);
                if (uriValue != null) {
                    Uri uri = Uri.parse(uriValue);
                    mediaPlayer.reset();
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    try {
                        mediaPlayer.setDataSource(osswService.getApplicationContext(), uri);
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
        } else if (FUNCTION_SEND_SMS.equals(functionId)) {
            selectCallLogNumber(new DialogSelectHandler() {
                @Override
                public void handleFunction(int position) {
                    if (position == 0xff)
                        return;
                    final String number = getItem(position);
                    Log.d(TAG, "Number selected: " + number + ", position: " + position);
                    selectSms(new DialogSelectHandler() {
                        @Override
                        public void handleFunction(int position) {
                            if (position == 0xff)
                                return;
                            closeDialog();
                            final String sms = getItem(position);
                            Log.d(TAG, "SMS selected: " + sms + ", position: " + position);
                            CallReceiver.sendSMS(number, sms);
                        }
                    });
                }
            });
        }
    }

    public static void closeDialog() {
        Log.i(TAG, "Closing dialog");
        OsswService.getInstance().uploadNotification(0, NotificationType.DIALOG_CLOSE, new byte[0], 0, 0, null);
    }

    public static void selectSms(DialogSelectHandler dsHandler) {
        OsswService osswService = OsswService.getInstance();
        SharedPreferences shPref = PreferenceManager.getDefaultSharedPreferences(osswService.getApplicationContext());
        final String message = shPref.getString("pref_reject_call_message", "");
        List<String> items = new ArrayList<>();
        if (message.contains("|"))
            items = Arrays.asList(message.split("\\|"));
        else
            items.add(message);

        if (items.size() == 0)
            return;
        dsHandler.setItems(items);
        if (items.size() == 1) {
            dsHandler.handleFunction(0);
            return;
        }
        Log.d(TAG, "Choose between several predefined SMS: " + items.toString());
        NotificationMessageBuilder builder = new DialogSelectMessageBuilder("Choose SMS", items);
        osswService.uploadNotification(0, NotificationType.DIALOG_SELECT, builder.build(), 0, 0, dsHandler);
    }

    public static void selectCallLogNumber(DialogSelectHandler dsHandler) {
        //Fetches the complete call log in descending order. i.e recent calls appears first.
        String[] projection = new String[]{
                CallLog.Calls._ID,
                CallLog.Calls.NUMBER,
                CallLog.Calls.DATE,
                CallLog.Calls.DURATION,
                CallLog.Calls.TYPE
        };
        Context context = OsswService.getInstance().getApplicationContext();
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Cursor c = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, projection, null,
                null, CallLog.Calls.DATE + " DESC");
        List<String> numbers = new ArrayList<>();
        if (c.getCount() > 0) {
            c.moveToFirst();
            do {
                String callerNumber = c.getString(c.getColumnIndex(CallLog.Calls.NUMBER));
                if (!numbers.contains(callerNumber))
                    numbers.add(callerNumber);
            } while (c.moveToNext());
            if (numbers.size() == 0)
                return;
            List<String> items = new ArrayList<>();
            for (String number : numbers) {
                if (items.size() >= 10)
                    break;
                items.add(getContactDisplayNameByNumber(context, number) + " " + number);
            }
            dsHandler.setItems(items);
            if (items.size() == 1) {
                dsHandler.handleFunction(0);
                return;
            }
            Log.d(TAG, "Choose between numbers in call log: " + items.toString());
            NotificationMessageBuilder builder = new DialogSelectMessageBuilder("Choose contact", items);
            OsswService.getInstance().uploadNotification(0, NotificationType.DIALOG_SELECT, builder.build(), 0, 0, dsHandler);
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
