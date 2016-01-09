package com.althink.android.ossw.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;

import com.althink.android.ossw.service.OsswService;

import java.io.IOException;

/**
 * Created by Pavel on 25/12/2015.
 */
public class FunctionHandler {
    private final static String TAG = FunctionHandler.class.getSimpleName();
    public static final String FUNCTION_PHONE_DISCOVERY = "phone.discovery";
    public static final String PREFERENCE_PHONE_DISCOVERY_AUDIO = "phone_discovery_audio";
    public static final String PREFERENCE_PHONE_DISCOVERY_VIBRATE = "phone_discovery_vibrate";
    private static final long[] discoveryVibration = {200, 500};
    private static boolean phoneDiscoveryStarted = false;

    public static void handleFunction(String functionId, String parameter) {
        if (FUNCTION_PHONE_DISCOVERY.equals(functionId)) {
            MediaPlayer mediaPlayer = OsswService.getMediaPlayer();
            OsswService osswService = OsswService.getInstance();
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(osswService);
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
        }
    }
}
