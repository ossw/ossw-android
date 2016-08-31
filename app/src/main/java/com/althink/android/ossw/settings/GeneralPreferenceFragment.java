package com.althink.android.ossw.settings;

/**
 * Created by Pavel on 22/12/2015.
 */

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v14.preference.MultiSelectListPreference;
import android.support.v14.preference.PreferenceFragment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.PreferenceScreen;
import android.util.Log;
import android.view.View;

import com.althink.android.ossw.R;
import com.althink.android.ossw.service.OsswService;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.fitness.Fitness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This fragment shows general preferences only. It is used when the
 * activity is showing a two-pane settings UI.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class GeneralPreferenceFragment extends PreferenceFragment {
    public static final String TAG = GeneralPreferenceFragment.class.getSimpleName();
    static final int REQUEST_PERMISSION_GET_ACCOUNTS = 100;
    public static final int SELECT_AUDIO_TRACK = 1;

    @Override
    public void onCreatePreferences(Bundle bundle, String rootKey) {
        setPreferencesFromResource(R.xml.pref_general, rootKey);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Set the default white background in the view so as to avoid transparency
        view.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.background_material_light));
        prepareSettings();
    }

    private void prepareSettings() {
        PreferenceScreen pscr = getPreferenceScreen();
        for (int i = 0; i < pscr.getPreferenceCount(); i++) {
            visitPreferenceObject(pscr.getPreference(i));
        }

        if ("notification_screen".equals(getPreferenceScreen().getKey())) {
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
                            .setSmallIcon(R.drawable.ic_watch_dial);
                    notifyManager.notify(OsswService.TEST_NOTIFICATION_ID, builder.build());
                    return true;
                }
            });
            // Application list for choosing notification sources
            final MultiSelectListPreference notificationApps = (MultiSelectListPreference) findPreference("notification_applications");
            Runnable loadInstalledApps = new Runnable() {
                @Override
                public void run() {
                    String osswPackageName = getActivity().getPackageName();
                    PackageManager pm = getActivity().getPackageManager();
                    Intent intentFilter = new Intent(Intent.ACTION_MAIN, null);
                    intentFilter.addCategory(Intent.CATEGORY_LAUNCHER);
                    List<ResolveInfo> appList = pm.queryIntentActivities(intentFilter, PackageManager.MATCH_ALL);
                    Collections.sort(appList, new ResolveInfo.DisplayNameComparator(pm));
                    List<CharSequence> entries = new ArrayList<CharSequence>();
                    List<CharSequence> entryValues = new ArrayList<CharSequence>();
                    for (ResolveInfo info : appList) {
                        if (!osswPackageName.equals(info.activityInfo.packageName)) {
                            entryValues.add(info.activityInfo.packageName);
                            entries.add(info.loadLabel(pm).toString());
                        }
                    }
                    notificationApps.setEntries(entries.toArray(new CharSequence[entries.size()]));
                    notificationApps.setEntryValues(entryValues.toArray(new CharSequence[entryValues.size()]));
                    Log.d(TAG, "Notification apps list refreshed");
                }
            };
            new Thread(loadInstalledApps).start();
        }
        if ("preference_screen".equals(getPreferenceScreen().getKey())) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.GET_ACCOUNTS)
                    == PackageManager.PERMISSION_GRANTED) {
                refreshGoogleTaskAccounts();
            } else {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.GET_ACCOUNTS},
                        REQUEST_PERMISSION_GET_ACCOUNTS);
            }
        }

        if ("alert_screen".equals(getPreferenceScreen().getKey())) {
            Preference button = findPreference("button_test_alert_vibration");
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
                            .addAction(android.R.drawable.ic_menu_close_clear_cancel, "Close", PendingIntent.getBroadcast(getActivity(), 0, new Intent(OsswService.CLOSE_FAKE_ALARM_INTENT_ACTION), 0))
                            .setSmallIcon(R.drawable.ic_watch_dial);
                    notifyManager.notify(OsswService.TEST_ALERT_ID, builder.build());
                    return true;
                }
            });
        }

        if ("phone_discovery_screen".equals(getPreferenceScreen().getKey())) {
            Preference pref = findPreference("phone_discovery_audio");
            pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT).setType("audio/*");
                    startActivityForResult(i, SELECT_AUDIO_TRACK);
                    return true;
                }
            });
        }
    }

    public void refreshGoogleTaskAccounts() {
        List<Account> accountList = Arrays.asList(AccountManager.get(getActivity()).getAccountsByType("com.google"));
        MultiSelectListPreference accountPref = (MultiSelectListPreference) findPreference("google_tasks_accounts");
        List<CharSequence> entries = new ArrayList<>();
        for (Account acc : accountList) {
            entries.add(acc.name);
        }
        CharSequence[] ent = entries.toArray(new CharSequence[entries.size()]);
        accountPref.setEntries(ent);
        accountPref.setEntryValues(ent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SELECT_AUDIO_TRACK:
                if (resultCode == Activity.RESULT_OK && data != null) {
                    Uri audioUri = data.getData();
                    AudioPickerPreference pref = (AudioPickerPreference) findPreference("phone_discovery_audio");
                    String newValue = audioUri.toString();
                    if (pref.callChangeListener(newValue))
                        pref.setUriValue(newValue);
                }
        }
    }

    static void visitPreferenceObject(Preference p) {
        if (p instanceof PreferenceCategory) {
            PreferenceCategory cat = (PreferenceCategory) p;
            for (int i = 0; i < cat.getPreferenceCount(); i++) {
                visitPreferenceObject(cat.getPreference(i));
            }
        } else if (p instanceof ListPreference || p instanceof EditTextPreference
                || p instanceof AudioPickerPreference || p instanceof TextSwitchPreference)
            bindPreferenceSummaryToValue(p);
    }

    static void bindPreferenceSummaryToValue(Preference preference) {
        // Set the listener to watch for value changes.
        preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);

        // Trigger the listener immediately with the preference's current value.
        sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
                PreferenceManager
                        .getDefaultSharedPreferences(preference.getContext())
                        .getString(preference.getKey(), ""));
    }

    static Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener() {
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

    @Override
    public void onDisplayPreferenceDialog(Preference preference) {
        DialogFragment dialogFragment = null;
        if (preference instanceof TimeIntervalPreference) {
            dialogFragment = TimeIntervalPreferenceFragment.newInstance(preference.getKey());
        }

        if (dialogFragment != null) {
            dialogFragment.setTargetFragment(this, 0);
            dialogFragment.show(this.getFragmentManager(), "android.support.v7.preference.PreferenceFragment.DIALOG");
        } else {
            super.onDisplayPreferenceDialog(preference);
        }
    }

    /**
     *  Build a {@link GoogleApiClient} that will authenticate the user and allow the application
     *  to connect to Fitness APIs. The scopes included should match the scopes your app needs
     *  (see documentation for details). Authentication will occasionally fail intentionally,
     *  and in those cases, there will be a known resolution, which the OnConnectionFailedListener()
     *  can address. Examples of this include the user never having signed in before, or having
     *  multiple accounts on the device and needing to specify which account to use, etc.
     */
//    private void buildFitnessClient() {
//        if (mClient == null && checkPermissions()) {
//            mClient = new GoogleApiClient.Builder(this)
//                    .addApi(Fitness.SENSORS_API)
//                    .addScope(new Scope(Scopes.FITNESS_LOCATION_READ))
//                    .addConnectionCallbacks(
//                            new GoogleApiClient.ConnectionCallbacks() {
//                                @Override
//                                public void onConnected(Bundle bundle) {
//                                    Log.i(TAG, "Connected!!!");
//                                    // Now you can make calls to the Fitness APIs.
//                                    findFitnessDataSources();
//                                }
//
//                                @Override
//                                public void onConnectionSuspended(int i) {
//                                    // If your connection to the sensor gets lost at some point,
//                                    // you'll be able to determine the reason and react to it here.
//                                    if (i == GoogleApiClient.ConnectionCallbacks.CAUSE_NETWORK_LOST) {
//                                        Log.i(TAG, "Connection lost.  Cause: Network Lost.");
//                                    } else if (i
//                                            == GoogleApiClient.ConnectionCallbacks.CAUSE_SERVICE_DISCONNECTED) {
//                                        Log.i(TAG,
//                                                "Connection lost.  Reason: Service Disconnected");
//                                    }
//                                }
//                            }
//                    )
//                    .enableAutoManage(this, 0, new GoogleApiClient.OnConnectionFailedListener() {
//                        @Override
//                        public void onConnectionFailed(ConnectionResult result) {
//                            Log.i(TAG, "Google Play services connection failed. Cause: " +
//                                    result.toString());
//                            Snackbar.make(
//                                    MainActivity.this.findViewById(R.id.main_activity_view),
//                                    "Exception while connecting to Google Play services: " +
//                                            result.getErrorMessage(),
//                                    Snackbar.LENGTH_INDEFINITE).show();
//                        }
//                    })
//                    .build();
//        }
//    }
}
