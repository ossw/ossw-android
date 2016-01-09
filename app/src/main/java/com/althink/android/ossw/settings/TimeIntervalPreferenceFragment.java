package com.althink.android.ossw.settings;

/**
 * Created by Pavel on 23/12/2015.
 */

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v14.preference.PreferenceDialogFragment;
import android.support.v7.preference.DialogPreference;
import android.support.v7.preference.Preference;
import android.view.View;
import android.widget.TimePicker;

import com.althink.android.ossw.R;

public class TimeIntervalPreferenceFragment extends PreferenceDialogFragment implements DialogPreference.TargetFragment {

    private TimePicker fromPicker;
    private TimePicker tillPicker;

    public static TimeIntervalPreferenceFragment newInstance(String key) {
        final TimeIntervalPreferenceFragment
                fragment = new TimeIntervalPreferenceFragment();
        final Bundle b = new Bundle(1);
        b.putString("key", key);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    protected View onCreateDialogView(Context context) {
        View view = View.inflate(context, R.layout.time_interval_dialog, null);
        fromPicker = (TimePicker) view.findViewById(R.id.fromTimePicker);
        fromPicker.setIs24HourView(true);
        tillPicker = (TimePicker) view.findViewById(R.id.tillTimePicker);
        tillPicker.setIs24HourView(true);
        return view;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onBindDialogView(View v) {
        super.onBindDialogView(v);
        TimeIntervalPreference pref = (TimeIntervalPreference) getPreference();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            fromPicker.setCurrentHour(pref.fromLastHour);
            fromPicker.setCurrentMinute(pref.fromLastMinute);
            tillPicker.setCurrentHour(pref.tillLastHour);
            tillPicker.setCurrentMinute(pref.tillLastMinute);
        } else {
            fromPicker.setHour(pref.fromLastHour);
            fromPicker.setHour(pref.fromLastMinute);
            tillPicker.setHour(pref.tillLastHour);
            tillPicker.setHour(pref.tillLastMinute);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onDialogClosed(boolean positiveResult) {
        if (positiveResult) {
            TimeIntervalPreference pref = (TimeIntervalPreference) getPreference();
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                pref.fromLastHour = fromPicker.getCurrentHour();
                pref.fromLastMinute = fromPicker.getCurrentMinute();
                pref.tillLastHour = tillPicker.getCurrentHour();
                pref.tillLastMinute = tillPicker.getCurrentMinute();
            } else {
                pref.fromLastHour = fromPicker.getHour();
                pref.fromLastMinute = fromPicker.getMinute();
                pref.tillLastHour = tillPicker.getHour();
                pref.tillLastMinute = tillPicker.getMinute();
            }
            String time = String.valueOf(pref.getSummary());
            if (pref.callChangeListener(time)) {
                pref.persistStringValue(time);
            }
            pref.setSummary(pref.getSummary());
        }
    }

    @Override
    public Preference findPreference(CharSequence charSequence)
    {
        return getPreference();
    }
}