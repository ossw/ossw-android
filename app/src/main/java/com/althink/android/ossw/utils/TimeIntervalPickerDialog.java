package com.althink.android.ossw.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

import com.althink.android.ossw.R;

/**
 * Created by Pavel on 21/12/2015.
 */
public class TimeIntervalPickerDialog extends AlertDialog implements OnClickListener,
        OnTimeChangedListener {
    private static final String HOUR = "hour";
    private static final String MINUTE = "minute";

    private final TimePicker mTimePickerFrom;
    private final TimePicker mTimePickerTill;
    private final OnTimeSetListener mTimeSetListener;

    /**
     * The callback interface used to indicate the user is done filling in
     * the time (e.g. they clicked on the 'OK' button).
     */
    public interface OnTimeSetListener {
        /**
         * Called when the user is done setting a new time and the dialog has
         * closed.
         *
         * @param view the view associated with this listener
         * @param hourOfDay the hour that was set
         * @param minute the minute that was set
         */
        public void onTimeSet(TimePicker view, int hourOfDay, int minute);
    }

    /**
     * Creates a new time picker dialog.
     *
     * @param context the parent context
     * @param listener the listener to call when the time is set
     * @param hourOfDay the initial hour
     * @param minute the initial minute
     */
    public TimeIntervalPickerDialog(Context context, OnTimeSetListener listener, int hourOfDay, int minute) {
        this(context, 0, listener, hourOfDay, minute);
    }

    static int resolveDialogTheme(Context context, int resId) {
        if (resId == 0) {
            final TypedValue outValue = new TypedValue();
            context.getTheme().resolveAttribute(android.R.attr.timePickerDialogTheme, outValue, true);
            return outValue.resourceId;
        } else {
            return resId;
        }
    }

    /**
     * Creates a new time picker dialog with the specified theme.
     *
     * @param context the parent context
     * @param themeResId the resource ID of the theme to apply to this dialog
     * @param listener the listener to call when the time is set
     * @param hourOfDay the initial hour
     * @param minute the initial minute
     */
    public TimeIntervalPickerDialog(Context context, int themeResId, OnTimeSetListener listener,
                            int hourOfDay, int minute) {
        super(context, resolveDialogTheme(context, themeResId));

        mTimeSetListener = listener;

        final Context themeContext = getContext();

        final TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.timePickerDialogTheme, outValue, true);
//        final int layoutResId = outValue.resourceId;

        final LayoutInflater inflater = LayoutInflater.from(themeContext);
        final View view = inflater.inflate(R.layout.time_interval_dialog, null);
        setView(view);
        setButton(BUTTON_POSITIVE, themeContext.getString(R.string.time_interval_picker_ok), this);
        setButton(BUTTON_NEGATIVE, themeContext.getString(R.string.time_interval_picker_cancel), this);
//        setButtonPanelLayoutHint(LAYOUT_HINT_SIDE);

        mTimePickerFrom = (TimePicker) view.findViewById(R.id.timePickerFrom);
        mTimePickerFrom.setIs24HourView(true);
        mTimePickerFrom.setCurrentHour(hourOfDay);
        mTimePickerFrom.setCurrentMinute(minute);
        mTimePickerFrom.setOnTimeChangedListener(this);
        mTimePickerTill = (TimePicker) view.findViewById(R.id.timePickerTill);
        mTimePickerTill.setIs24HourView(true);
        mTimePickerTill.setCurrentHour(hourOfDay);
        mTimePickerTill.setCurrentMinute(minute);
        mTimePickerTill.setOnTimeChangedListener(this);
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        /* do nothing */
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case BUTTON_POSITIVE:
                if (mTimeSetListener != null) {
                    mTimeSetListener.onTimeSet(mTimePickerFrom, mTimePickerFrom.getCurrentHour(),
                            mTimePickerFrom.getCurrentMinute());
                }
                break;
            case BUTTON_NEGATIVE:
                cancel();
                break;
        }
    }

    /**
     * Sets the current time.
     *
     * @param hourOfDay The current hour within the day.
     * @param minuteOfHour The current minute within the hour.
     */
    public void updateTime(int hourOfDay, int minuteOfHour) {
        mTimePickerFrom.setCurrentHour(hourOfDay);
        mTimePickerFrom.setCurrentMinute(minuteOfHour);
    }

    @Override
    public Bundle onSaveInstanceState() {
        final Bundle state = super.onSaveInstanceState();
        state.putInt(HOUR, mTimePickerFrom.getCurrentHour());
        state.putInt(MINUTE, mTimePickerFrom.getCurrentMinute());
        return state;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        final int hour = savedInstanceState.getInt(HOUR);
        final int minute = savedInstanceState.getInt(MINUTE);
        mTimePickerFrom.setCurrentHour(hour);
        mTimePickerFrom.setCurrentMinute(minute);
    }

}