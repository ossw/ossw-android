package com.althink.android.ossw.settings;

/**
 * Created by Pavel on 23/12/2015.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TimePicker;

public class TimePreference extends DialogPreference {

    private int lastHour;
    private int lastMinute;
    private TimePicker picker;

    public TimePreference(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        setPositiveButtonText(ctx.getString(android.R.string.ok));
        setNegativeButtonText(ctx.getString(android.R.string.cancel));
    }

    @Override
    protected View onCreateDialogView() {
        picker = new TimePicker(getContext());
        picker.setIs24HourView(true);
        return picker;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onBindDialogView(View v) {
        super.onBindDialogView(v);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            picker.setCurrentHour(lastHour);
            picker.setCurrentMinute(lastMinute);
        } else {
            picker.setHour(lastHour);
            picker.setHour(lastMinute);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);
        if (positiveResult) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                lastHour = picker.getCurrentHour();
                lastMinute = picker.getCurrentMinute();
            } else {
                lastHour = picker.getHour();
                lastMinute = picker.getMinute();
            }
            String time = String.valueOf(getSummary());
            if (callChangeListener(time)) {
                persistString(time);
            }
            setSummary(getSummary());
        }
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
                defaultValue = "00:00";
            try {
                time = getPersistedString(defaultValue.toString());
            } catch (ClassCastException e) {
                e.printStackTrace();
                time = defaultValue.toString();
            }
        } else {
            time = defaultValue.toString();
        }
        lastHour = getHour(time);
        lastMinute = getMinute(time);
        setSummary(getSummary());
    }

    public static int getHour(String time) {
        String[] pieces = time.split(":");
        int result = 0;
        try {
            if (pieces.length == 2)
                result = Integer.parseInt(pieces[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int getMinute(String time) {
        String[] pieces = time.split(":");
        int result = 0;
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
        return String.valueOf(lastHour) + ':' + String.valueOf(lastMinute);
    }
}