package com.althink.android.ossw.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Vibrator;
import android.preference.PreferenceManager;

import com.althink.android.ossw.service.OsswService;

import java.io.IOException;

/**
 * Created by Pavel on 25/12/2015.
 */
public class FunctionHandler {
    public static final String FUNCTION_PHONE_DISCOVERY = "phone.discovery";
    public static final String PREFERENCE_PHONE_DISCOVERY_AUDIO = "phone_discovery_audio";
    public static final String PREFERENCE_PHONE_DISCOVERY_VIBRATE = "phone_discovery_vibrate";
    private static final long[] discovryVibration = {200, 500};

    public static void handleFunction(String functionId, String parameter) {
        if (FUNCTION_PHONE_DISCOVERY.equals(functionId)) {
            MediaPlayer mediaPlayer = OsswService.getMediaPlayer();
            OsswService osswService = OsswService.getInstance();
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(osswService);
            Vibrator v = (Vibrator) osswService.getSystemService(Context.VIBRATOR_SERVICE);
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                v.cancel();
            } else {
                String uriValue = sharedPref.getString(PREFERENCE_PHONE_DISCOVERY_AUDIO, null);
                if (uriValue == null)
                    return;
                Uri uri = Uri.parse(uriValue);
                mediaPlayer.reset();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(osswService.getApplicationContext(), uri);
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
                boolean vibrate = sharedPref.getBoolean(PREFERENCE_PHONE_DISCOVERY_VIBRATE, true);
                if (vibrate) {
                    v.vibrate(discovryVibration, 0);
                }
            }
        }
    }
}
