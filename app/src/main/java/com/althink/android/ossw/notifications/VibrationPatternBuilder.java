package com.althink.android.ossw.notifications;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import com.althink.android.ossw.R;
import com.althink.android.ossw.settings.SettingsActivity;

/**
 * Created by krzysiek on 05/11/15.
 */
public class VibrationPatternBuilder {

    public static int getNotificationVibrationPattern(Context ctx) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ctx);
        Resources resources = ctx.getResources();
        String patternString = getNotificationVibrationStringPattern(sharedPref, resources);
        int duration = getNotificationVibrationPatternDuration(sharedPref, resources) / patternString.length();
        int pattern = (Integer.parseInt(patternString, 2));
        return buildBinaryPattern(duration, pattern, patternString.length());
    }

    public static int getNotificationVibrationLength(Context ctx) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ctx);
        Resources resources = ctx.getResources();
        int repeatNo = Integer.parseInt(sharedPref.getString(SettingsActivity.NOTIFICATION_VIBRATION_PREFIX + "_repeat", resources.getString(R.string.default_notification_vibration_repeat_no)));
        String patternString = getNotificationVibrationStringPattern(sharedPref, resources);
        int duration = 0x3FF & (getNotificationVibrationPatternDuration(sharedPref, resources) / patternString.length());
        return patternString.length() * duration * repeatNo - 10;
    }

    public static int getAlertVibrationPattern(Context ctx) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ctx);
        Resources resources = ctx.getResources();
        String patternString = getAlertVibrationStringPattern(sharedPref, resources);
        int duration = getAlertVibrationPatternDuration(sharedPref, resources) / patternString.length();
        int pattern = Integer.parseInt(patternString, 2);
        return buildBinaryPattern(duration, pattern, patternString.length());
    }

    private static int buildBinaryPattern(int duration, int pattern, int stepsNo) {
        return ((stepsNo > 15 ? 0 : stepsNo) << 26) | ((0x3FF & duration) << 16) | (0xFFFF & pattern)<< (16 - stepsNo);
    }

    private static int getNotificationVibrationPatternDuration(SharedPreferences sharedPref, Resources resources) {
        return Integer.parseInt(sharedPref.getString(SettingsActivity.NOTIFICATION_VIBRATION_PREFIX + "_duration", resources.getString(R.string.default_notification_vibration_duration)));
    }

    private static String getNotificationVibrationStringPattern(SharedPreferences sharedPref, Resources resources) {
        return sharedPref.getString(SettingsActivity.NOTIFICATION_VIBRATION_PREFIX + "_pattern", resources.getString(R.string.default_notification_vibration_pattern));
    }

    private static int getAlertVibrationPatternDuration(SharedPreferences sharedPref, Resources resources) {
        return Integer.parseInt(sharedPref.getString(SettingsActivity.ALERT_VIBRATION_PREFIX + "_duration", resources.getString(R.string.default_alert_vibration_duration)));
    }

    private static String getAlertVibrationStringPattern(SharedPreferences sharedPref, Resources resources) {
        return sharedPref.getString(SettingsActivity.ALERT_VIBRATION_PREFIX + "_pattern", resources.getString(R.string.default_alert_vibration_pattern));
    }
}
