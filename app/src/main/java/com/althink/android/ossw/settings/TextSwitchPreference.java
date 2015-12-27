package com.althink.android.ossw.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.PreferenceViewHolder;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.althink.android.ossw.R;

/**
 * Created by Pavel on 26/12/2015.
 */
public class TextSwitchPreference extends EditTextPreference {
    SwitchCompat switchCompat;
    public static final String KEY_SUFFIX = "_switch";

    public TextSwitchPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        switchCompat = (SwitchCompat) holder.itemView.findViewById(R.id.switch_button);
        final SharedPreferences shPref = PreferenceManager.getDefaultSharedPreferences(getContext());
        try {
            boolean checked = shPref.getBoolean(getKey() + KEY_SUFFIX, false);
            switchCompat.setChecked(checked);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                shPref.edit().putBoolean(getKey() + KEY_SUFFIX, isChecked).apply();
            }
        });
//        LinearLayout ll = (LinearLayout) holder.itemView.findViewById(android.R.id.widget_frame);
//        ll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                enabled = !enabled;
//                shPref.getString(getKey() + KEY_SUFFIX, String.valueOf(enabled));
//            }
//        });
    }
}
