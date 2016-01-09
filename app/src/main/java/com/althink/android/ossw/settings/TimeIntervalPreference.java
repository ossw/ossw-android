package com.althink.android.ossw.settings;

/**
 * Created by Pavel on 23/12/2015.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.preference.DialogPreference;
import android.util.AttributeSet;

public class TimeIntervalPreference extends DialogPreference {

    int fromLastHour;
    int fromLastMinute;
    int tillLastHour;
    int tillLastMinute;

    public TimeIntervalPreference(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        setPositiveButtonText(ctx.getString(android.R.string.ok));
        setNegativeButtonText(ctx.getString(android.R.string.cancel));
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return a.getString(index);
    }

    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        String time;
        if (restoreValue) {
            if (defaultValue == null)
                defaultValue = "00:00-23:59";
            try {
                time = getPersistedString(defaultValue.toString());
            } catch (ClassCastException e) {
                e.printStackTrace();
                time = defaultValue.toString();
            }
        } else {
            time = defaultValue.toString();
        }
        String[] times = time.split("-");
        if (times.length == 2) {
            fromLastHour = getHour(times[0], 0);
            fromLastMinute = getMinute(times[0], 0);
            tillLastHour = getHour(times[1], 23);
            tillLastMinute = getMinute(times[1], 59);
        } else {
            fromLastHour = 0;
            fromLastMinute = 0;
            tillLastHour = 23;
            tillLastMinute = 59;
        }
        setSummary(getSummary());
    }

    public static int getHour(String time, int defaultVal) {
        String[] pieces = time.split(":");
        int result = defaultVal;
        try {
            if (pieces.length == 2)
                result = Integer.parseInt(pieces[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int getMinute(String time, int defaultVal) {
        String[] pieces = time.split(":");
        int result = defaultVal;
        try {
            if (pieces.length == 2)
                result = Integer.parseInt(pieces[1]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public CharSequence getSummary() {
        return padded(fromLastHour) + ':' + padded(fromLastMinute) + '-'
                + padded(tillLastHour) + ':' + padded(tillLastMinute);
    }

    public static String padded(int i) {
        String s = String.valueOf(i);
        return (i < 10) ? "0" + s : s;
    }

    public void persistStringValue(String value) {
        persistString(value);
    }
}