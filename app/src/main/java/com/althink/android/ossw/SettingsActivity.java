package com.althink.android.ossw;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.althink.android.ossw.appcompat.AppCompatPreferenceActivity;
import com.althink.android.ossw.service.OsswService;

public class SettingsActivity extends AppCompatPreferenceActivity {

    public static final String NOTIFICATION_VIBRATION_PREFIX = "notif_vibrate";
    public static final String ALERT_VIBRATION_PREFIX = "alert_notif_vibrate";

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        mToolbar.setClickable(true);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new GeneralPreferenceFragment())
                .commit();
    }

    private static Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            String stringValue = value.toString();

            if (preference instanceof ListPreference) {
                // For list preferences, look up the correct display value in
                // the preference's 'entries' list.
                ListPreference listPreference = (ListPreference) preference;
                int index = listPreference.findIndexOfValue(stringValue);

                // Set the summary to reflect the new value.
                preference.setSummary(
                        index >= 0
                                ? listPreference.getEntries()[index]
                                : null);

            } else {
                // For all other preferences, set the summary to the value's
                // simple string representation.
                preference.setSummary(stringValue);
            }
            return true;
        }
    };

    /**
     * Binds a preference's summary to its value. More specifically, when the
     * preference's value is changed, its summary (line of text below the
     * preference title) is updated to reflect the value. The summary is also
     * immediately updated upon calling this method. The exact display format is
     * dependent on the type of preference.
     *
     * @see #sBindPreferenceSummaryToValueListener
     */
    private static void bindPreferenceSummaryToValue(Preference preference) {
        // Set the listener to watch for value changes.
        preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);

        // Trigger the listener immediately with the preference's current value.
        sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
                PreferenceManager
                        .getDefaultSharedPreferences(preference.getContext())
                        .getString(preference.getKey(), ""));
    }

    /**
     * This fragment shows general preferences only. It is used when the
     * activity is showing a two-pane settings UI.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static class GeneralPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_general);

            Preference button = findPreference("button_test_notif_vibration");
            button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    NotificationManagerCompat notifyManager = NotificationManagerCompat.from(getActivity());
                    notifyManager.cancel(OsswService.TEST_NOTIFICATION_ID);
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity());
                    builder.setContentTitle("Test notification")
                            .setContentText("")
                            .setCategory(Notification.CATEGORY_MESSAGE)
                            .setDeleteIntent(PendingIntent.getBroadcast(getActivity(), 0, new Intent(OsswService.CLOSE_FAKE_NOTIFICATION_INTENT_ACTION), 0))
                            .setSmallIcon(android.support.v7.appcompat.R.drawable.abc_btn_switch_to_on_mtrl_00001);
                    notifyManager.notify(OsswService.TEST_NOTIFICATION_ID, builder.build());
                    return true;
                }
            });
            button = findPreference("button_test_alert_vibration");
            button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    NotificationManagerCompat notifyManager = NotificationManagerCompat.from(getActivity());
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity());
                    builder.setContentTitle("Test alert")
                            .setContentText("")
                            .setPriority(2)
                            .setCategory(Notification.CATEGORY_MESSAGE)
                            .setFullScreenIntent(PendingIntent.getBroadcast(getActivity(), 0, new Intent(OsswService.FULLSCREEN_FAKE_ALARM_INTENT_ACTION), 0), false)
                            .addAction(android.support.v7.appcompat.R.drawable.abc_ic_clear_mtrl_alpha, "Close", PendingIntent.getBroadcast(getActivity(), 0, new Intent(OsswService.CLOSE_FAKE_ALARM_INTENT_ACTION), 0))
                            .setSmallIcon(android.support.v7.appcompat.R.drawable.abc_btn_switch_to_on_mtrl_00001);
                    notifyManager.notify(OsswService.TEST_ALERT_ID, builder.build());
                    return true;
                }
            });
            // Bind the summaries of EditText/List/Dialog/Ringtone preferences
            // to their values. When their values change, their summaries are
            // updated to reflect the new value, per the Android Design guidelines.
            visitPreferenceObject(getPreferenceScreen());
        }
    }

    private static void visitPreferenceObject(Preference p) {
        if (p instanceof PreferenceCategory) {
            PreferenceCategory cat = (PreferenceCategory) p;
            for (int i = 0; i < cat.getPreferenceCount(); i++) {
                visitPreferenceObject(cat.getPreference(i));
            }
        } else if (p instanceof PreferenceScreen) {
            PreferenceScreen pscr = (PreferenceScreen) p;
            for (int i = 0; i < pscr.getPreferenceCount(); i++) {
                visitPreferenceObject(pscr.getPreference(i));
            }
        } else if (p instanceof ListPreference || p instanceof EditTextPreference)
            bindPreferenceSummaryToValue(p);
    }

}
