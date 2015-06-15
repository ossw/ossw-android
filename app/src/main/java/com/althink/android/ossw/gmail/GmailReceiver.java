package com.althink.android.ossw.gmail;


import java.lang.reflect.Method;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;

/**
 * Created by krzysiek on 04/06/15.
 */
public class GmailReceiver extends BroadcastReceiver {

    // Log tag
    public static final String TAG = "GmailNotifier";

    // Gmail constants
    private static final Uri CONVERSATIONS_URI = Uri.parse("content://gmail-ls/conversations/");

    private static final String[] CONVERSATION_PROJECTION = {
            "_id", "subject", "snippet", "fromAddress", "date"
    };

    // Indicates whether the receiver is working or not (prevents suicide)
    // Sync not needed since it's only accessed from main thread
    static boolean sWorking = false;

    // Used to delay the process suicide
    private static Handler sHandler;

    static String[] getAccountsFromAccountManager(Context context) {
        String[] result = null;
        try {
            Class<?> cAccMgr = Class.forName("android.accounts.AccountManager");
            Class<?> cAcc = Class.forName("android.accounts.Account");
            Method mGet = cAccMgr.getMethod("get", new Class[] {
                    Context.class
            });
            Object accmgr = mGet.invoke(null, context);
            Method mGetAccountsByType = cAccMgr.getMethod("getAccountsByType", new Class[] {
                    String.class
            });
            Object[] accs = (Object[]) mGetAccountsByType.invoke(accmgr, new Object[] {
                    "com.google"
            });

            result = new String[accs.length];
            for (int i = 0; i < result.length; i++) {
                String name = (String) cAcc.getField("name").get(accs[i]);
                result[i] = name;
            }

            return result;
        } catch (ClassNotFoundException ex) {
            // Ignore. We find the account below by other means
        } catch (Exception ex) {
            Log.d(GmailReceiver.TAG, ex.toString());
        }

        return result;
    }

    // Called by Android when new mail arrives, notifications repeat or
    // notifications are cleared.
    // See receiver registration in AndroidManifest.xml
    @Override
    public void onReceive(Context context, Intent intent) {
        sWorking = true;

        String action = intent.getAction();

        if (Intent.ACTION_BOOT_COMPLETED.equals(action)) {
            // Reset "unreadcount" for each account. If accounts aren't in
            // default shared prefs, try reading them from AccountManager.
            // Reading from AccountManager isn't possible pre 2.0 so those users
            // must have launched MainActivity at least once since updating so
            // "accounts" gets populated. Who doesn't use > 2.0 these days?
            String[] accounts = null;
            String joinedAccounts = PreferenceManager.getDefaultSharedPreferences(context)
                    .getString("accounts", null);
            if (joinedAccounts != null) {
                accounts = joinedAccounts.split(";");
            } else {
                accounts = getAccountsFromAccountManager(context);
            }

            if (accounts != null) {
                for (String account : accounts) {
                    context.getSharedPreferences(account.toLowerCase(), 0).edit().putInt(
                            "unreadcount", 0).commit();
                    Log.d(TAG, "unreadcount set to 0 for " + account);
                }
            } else {
                Log.w(TAG, "No accounts configured. Notifications might be off. Run the app once.");
            }
        } else if (Intent.ACTION_PROVIDER_CHANGED.equals(action)) {
            Log.d(TAG, "ACTION_PROVIDER_CHANGED " + intent.getDataString());
            // Unread count has changed
            String account = intent.getStringExtra("account");
            String tagLabel = intent.getStringExtra("tagLabel");
            int unreadCount = intent.getIntExtra("count", 0);
            //SharedPreferences prefs = PrefsActivity.getAccountPreferences(context, account);
            //boolean isPriority = "content://gmail-ls/unread/^iim".equals(intent.getDataString());
            //boolean usePriority = prefs.getBoolean("priority", false);
            // If user has uninstalled Gmail update we force priority setting to
            // false. Otherwise no notifications at all!
            //usePriority &= PrefsActivity.supportsPriorityInbox(context);
            //if ((isPriority && usePriority) || (!isPriority && !usePriority)) {
                if (unreadCount > 0) {
                    // unreadCount > 0 means new mail
                    Log.d(TAG, "New email for " + account + " unreadCount:" + unreadCount);

                    // These properties was found by analyzing Gmail app
                    intent.setClassName("com.google.android.gm",
                            "com.google.android.gm.ConversationListActivity");
                 //   intent.addCategory(account);
                    intent.putExtra("account-shortcut", account);

                    createNotification(context, account, unreadCount, intent, tagLabel);
                } else {
                    // unreadCount == 0 means clear notification
                    Log.d(TAG, "Gmail clearing notification for " + account);
                    clearNotification(context, account);
                }
                //prefs.edit().putInt("unreadcount", unreadCount).commit();
           // } else {
           //     Log.d(TAG, "Skipping. isPriority " + isPriority + " usePriority " + usePriority);
           // }

        } else if (action.equals("REPEAT")) {
            // AlarmManager timer has ticked
            Notification n = intent.getParcelableExtra("notification");
            int interval = intent.getIntExtra("interval", 0);
            int repeats = intent.getIntExtra("repeats", 0);
            String account = intent.getDataString();
            if (n != null && !android.text.TextUtils.isEmpty(account)) {
                Log.d(TAG, "Sending repeat for " + account + " interval:" + interval + " repeats:"
                        + repeats);
                sendNotification(context, n, account, interval, repeats);
            }
        } else if (action.equals("CLEAR")) {
            // Notification cleared by "Clear all" button, or test notification
            // clicked
            String account = intent.getDataString();
            Log.d(TAG, "Clearing notification for " + account);
            clearNotification(context, account);
        } else {
            Log.d(TAG, "Unknown action: " + action);
        }

        sWorking = false;

        // Make the general public happier by not show up in task killers (ugly)
        exitAsNeeded();
    }

    public static boolean createNotification(Context context, String account, int unreadCount,
                                             Intent clickIntent, String tagLabel) {
        if (!PreferenceManager.getDefaultSharedPreferences(context).getBoolean("enabled", true)) {
            Log.i(TAG, "Notifications are disabled, ignoring");
            clearNotification(context, account);
            return true;
        }
        boolean result = false;
        try {
            Notification n = null;
            if (account == null) {
                // Should never happen. Could only happen if account loading
                // failed in MainActivity. I safety mechanism to prevent FC's.
             //   account = PrefsActivity.TEST_ACCOUNT;
            }

            // Load preferences from file, falling back on hard coded defaults
            //SharedPreferences prefs = PrefsActivity.getAccountPreferences(context, account);
            //PrefsActivity.upgradePreferences(prefs);

            Log.i(TAG, "unreadCount: " + unreadCount);
            //int lastUnreadCount = prefs.getInt("unreadcount", 0);
    /*        if (unreadCount != -1 && unreadCount < lastUnreadCount) {
                // Ignore. Typically the user read a message with another Gmail
                // client. Should be safe...
                Log.d(TAG, "Ignoring. unreadCount " + unreadCount + " lastUnreadCount "
                        + lastUnreadCount);
                return true;
            }*/
/*            boolean visible = prefs.getBoolean("visible", true);
            String ledMode = prefs.getString("ledmode", "blink");
            String ledColor = prefs.getString("ledcolor", "green");
            String vibrationMode = prefs.getString("vibrationmode", "default");
            String ringtoneUri = prefs.getString("ringtone",
                    "content://settings/system/notification_sound");
            String nicon = prefs.getString("nicon", "nicon_20");
            boolean gmstylefirst = prefs.getBoolean("gmstylefirst", true);
            boolean gmstylefirstm = prefs.getBoolean("gmstylefirstm", true);
            int interval = Integer.valueOf(prefs.getString("interval", "0"));
            int repeats = Integer.valueOf(prefs.getString("repeats", "10"));
            int schedule = PrefsActivity.getScheduledProperties(prefs);
            // Apply scheduled properties
            if (((schedule & PrefsActivity.DISABLE_LED) != 0)) {
                ledMode = "none";
            }
            if (((schedule & PrefsActivity.DISABLE_RINGTONE) != 0)) {
                ringtoneUri = null;
            }
            if (((schedule & PrefsActivity.DISABLE_VIBRATION) != 0)) {
                vibrationMode = "off";
            }

            // Construct the Gmail style notification
            SpannableStringBuilder from = null;
            StringBuilder subject = null;
            if (gmstylefirst && ((unreadCount == 1) || (gmstylefirstm && unreadCount > 1))) {
                from = new SpannableStringBuilder();
                subject = new StringBuilder();
                if (!formatGmailStyle(context, account, unreadCount, tagLabel, from, subject)) {
                    // If case of errors, fall back
                    from = null;
                    subject = null;
                }
            }

            if (visible) {
                // Create Notification
                n = new Notification(getIconId(nicon), context
                        .getString(R.string.notificationticker), System.currentTimeMillis());

                // When clicked, the notification should cancel itself
                n.flags |= Notification.FLAG_AUTO_CANCEL;

                // Set LED mode
                ledColor = setLED(n, ledMode, ledColor);

                // Intent fired when user clicks the notification
                PendingIntent pending = null;

                if (clickIntent == null) {
                    // This is a test. Set up dummy values to just clear
                    // notification.

                    clickIntent = new Intent(context, GmailReceiver.class);
                    clickIntent.setAction("CLEAR");
                    clickIntent.setData(Uri.parse(account));

                    pending = PendingIntent.getBroadcast(context, -1, clickIntent, 0);

                    // Set text
                    n.setLatestEventInfo(context, context
                            .getString(R.string.notificationtitle_test), account + " ("
                            + context.getString(R.string.unreadcount) + ")", pending);
                } else {
                    // The real deal.
                    pending = PendingIntent.getActivity(context, -1, clickIntent, 0);

                    if (gmstylefirst && subject != null && from != null) {
                        n.setLatestEventInfo(context, subject, from, pending);
                    } else {
                        n.setLatestEventInfo(context,
                                context.getString(R.string.notificationtitle), account + " ("
                                        + unreadCount + ")", pending);
                    }
                }
            } else
                n = new Notification(); // Invisible. Create with defaults.

            // Intent fired when user clicks "Clear all" button. We want to
            // cancel repeats then.
            Intent deleteIntent = new Intent(context, GmailReceiver.class);
            deleteIntent.setAction("CLEAR");
            deleteIntent.setData(Uri.parse(account));
            n.deleteIntent = PendingIntent.getBroadcast(context, -1, deleteIntent, 0);

            setVibration(n, vibrationMode);

            // Set ringtone
            if (TextUtils.isEmpty(ringtoneUri)) {
                // No ringtone (silent)
                n.sound = null;
                ringtoneUri = "null";
            } else
                n.sound = Uri.parse(ringtoneUri);

            // Debug logging
            StringBuilder sb = new StringBuilder();
            sb.append("Notifying");
            sb.append(" account:");
            sb.append(account);
            sb.append(" schedule:");
            sb.append(schedule);
            sb.append(" interval:");
            sb.append(interval);
            sb.append(" repeats:");
            sb.append(repeats);
            sb.append(" visible:");
            sb.append(visible);
            sb.append(" nicon:");
            sb.append(nicon);
            sb.append(" ledmode:");
            sb.append(ledMode);
            sb.append(" ledcolor:");
            sb.append(ledColor);
            sb.append(" vibrationmode:");
            sb.append(vibrationMode);
            sb.append(" ringtoneUri:");
            sb.append(ringtoneUri);
            sb.append(" gmstylefirst:");
            sb.append(gmstylefirst);

            Log.d(TAG, sb.toString());

            // Fire away
            sendNotification(context, n, account, interval, repeats);
            result = true;
*/
        } catch (Exception e) {
            Log.e(TAG, "Notification error: " + e.toString());
        }

        return true;
    }

    public static void sendNotification(Context context, Notification notification, String account,
                                        int interval, int repeats) {

        clearNotification(context, account);

        if (!PreferenceManager.getDefaultSharedPreferences(context).getBoolean("enabled", true)) {
            Log.i(TAG, "Notifications are disabled, ignoring");
            return;
        }

        if (interval > 0) {
            if (repeats > 0) {
                // Decrease repeats
                repeats--;

                // Repeating active, set up AlarmManager to call us when it's
                // time
                Intent intent = new Intent(context, GmailReceiver.class);
                intent.setAction("REPEAT");
                intent.putExtra("notification", notification);
                intent.putExtra("interval", interval);
                intent.putExtra("repeats", repeats);
                intent.setData(Uri.parse(account));

                PendingIntent sender = PendingIntent.getBroadcast(context, account.toLowerCase()
                        .hashCode(), intent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, java.lang.System.currentTimeMillis() + interval,
                        sender);
            }
        }

   //     SharedPreferences prefs = PrefsActivity.getAccountPreferences(context, account);
    //    boolean vibrateOnCall = prefs.getBoolean("vibrateoncall", true);
        boolean vibrateOnCall = false;
        if (!vibrateOnCall) {
            // Try to detect phone state
            boolean onCall = false;
            try {
                onCall = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE))
                        .getCallState() != TelephonyManager.CALL_STATE_IDLE;
            } catch (Exception e) {
                Log.e(TAG, "Error reading phone state: " + e.toString());
            }
            if (onCall) {
                Log.d(TAG, "Disabling vibrate since on call");
                notification.vibrate = null;
                notification.defaults &= ~Notification.DEFAULT_VIBRATE;
            }
        }

        // Send the actual notification to Android
        NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(account.toLowerCase().hashCode(), notification);
    }

    public static void clearNotification(Context context, String account) {
        // Cancel (remove) notification
        NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        nm.cancel(account.toLowerCase().hashCode());

        // Cancel repeats
        Intent intent = new Intent(context, GmailReceiver.class);
        intent.setAction("REPEAT");
        intent.setData(Uri.parse(account));
        PendingIntent sender = PendingIntent.getBroadcast(context,
                account.toLowerCase().hashCode(), intent, 0);

        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.cancel(sender);
    }

    private static boolean formatGmailStyle(Context context, String account, int unreadCount,
                                            String tagLabel, SpannableStringBuilder from, StringBuilder subject) {
        boolean success = false;
        Cursor cursor = null;
        try {
            // Get sender & subject
            ContentResolver resolver = context.getContentResolver();
            cursor = resolver.query(Uri.withAppendedPath(CONVERSATIONS_URI, account),
                    CONVERSATION_PROJECTION, "label:" + tagLabel, null, null);
            int fromIndex = cursor.getColumnIndexOrThrow("fromAddress");
            int subjectIndex = cursor.getColumnIndexOrThrow("subject");
            cursor.moveToFirst();
            String fromAddress = cursor.getString(fromIndex);
            subject.append(cursor.getString(subjectIndex));
            cursor.close();

            // Beware, dragons ahead.
            // Call Gmail code for formatting. This is really
            // hacky. Thanks to JesusFreke for baksmali.
            Class<?> gm;
            try {
                gm = Class.forName("android.provider.Gmail");
            } catch (Exception e) {
                Context foreignContext = context.createPackageContext("com.google.android.gm",
                        Context.CONTEXT_INCLUDE_CODE | Context.CONTEXT_IGNORE_SECURITY);
                gm = foreignContext.getClassLoader().loadClass(
                        "com.google.android.gm.provider.Gmail");
            }

            // Set up parameters
            String instructions = fromAddress;
            int maxChars = 0x19;
            StyleSpan unreadStyle = new StyleSpan(Typeface.BOLD);
            ForegroundColorSpan draftsStyle = new ForegroundColorSpan(Color.RED);
            String meString = "me";//context.getString(R.string.me);
            String draftString = "draft";//context.getString(R.string.draft);
            String draftPluralString = "drafts";//context.getString(R.string.draftplural);
            String sendingString = "sending";//context.getString(R.string.sending);
            String sendFailedString = "sendFailed";//context.getString(R.string.sendingfailed);
            boolean forceAllUnread = false;
            boolean forceAllRead = false;

            boolean found = false;
            Method[] ms = gm.getMethods();
            for (int i = 0; i < ms.length; i++) {
                if (ms[i].getName().contains("getSenderSnippet")) {
                    Class<?>[] params = ms[i].getParameterTypes();
                    if (params.length == 13) {
                        // Gmail in Android 2.2 and up
                        ms[i].invoke(null, instructions, from, new SpannableStringBuilder(),
                                maxChars, unreadStyle, draftsStyle, meString, draftString,
                                draftPluralString, sendingString, sendFailedString, forceAllUnread,
                                forceAllRead);
                    } else {
                        // Earlier versions
                        ms[i].invoke(null, instructions, from, maxChars, unreadStyle, draftsStyle,
                                meString, draftString, draftPluralString, sendingString,
                                sendFailedString, forceAllUnread, forceAllRead);
                    }
                    // Add unread count if configured
                    if (unreadCount > 1) {
                        from.insert(0, "(" + unreadCount + ") ");
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new Exception("getSenderSnippet not found");
            }
            success = true;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        } finally {
            if (cursor != null)
                cursor.close();
        }

        return success;
    }

    private static int getIconId(String setting) {
   /*     int id = R.drawable.nicon_20;
        try {
            id = R.drawable.class.getField(setting).getInt(null);
        } catch (Exception e) {
            Log.e(TAG, "Error loading icon " + setting + ": " + e.toString());
            id = R.drawable.nicon_20;
        }*/
        return 0;
    }

    private static String setLED(Notification n, String ledMode, String ledColor) {
        if ("off".equals(ledMode)) {
            n.ledOnMS = 0;
            n.ledOffMS = 0;
            ledColor = "none";
        } else if ("on".equals(ledMode)) {
            n.flags |= Notification.FLAG_SHOW_LIGHTS;
            n.ledOnMS = 1;
            n.ledOffMS = 0;
        } else if ("blink".equals(ledMode)) {
            n.flags |= Notification.FLAG_SHOW_LIGHTS;
            n.ledOnMS = 500;
            n.ledOffMS = 2000;
        } else if ("blinkfast".equals(ledMode)) {
            n.flags |= Notification.FLAG_SHOW_LIGHTS;
            n.ledOnMS = 500;
            n.ledOffMS = 500;
        }

        // Set LED color
        if ("blue".equals(ledColor))
            n.ledARGB = Color.BLUE;
        else if ("cyan".equals(ledColor))
            n.ledARGB = Color.CYAN;
        else if ("green".equals(ledColor))
            n.ledARGB = Color.GREEN;
        else if ("magenta".equals(ledColor))
            n.ledARGB = Color.MAGENTA;
        else if ("red".equals(ledColor))
            n.ledARGB = Color.RED;
        else if ("yellow".equals(ledColor))
            n.ledARGB = Color.YELLOW;
        else if ("none".equals(ledColor))
            n.ledARGB = Color.TRANSPARENT;
        return ledColor;
    }

    private static void setVibration(Notification n, String vibrationMode) {
        // Vibration mode. Patterns syntax is
        // pause,active,pause,active,pause..... (in ms)
        if ("off".equals(vibrationMode)) {
            // Do nothing. Default is off
        } else if ("default".equals(vibrationMode)) {
            // Use system default
            n.defaults |= Notification.DEFAULT_VIBRATE;
        } else if ("shorter".equals(vibrationMode)) {
            long[] pattern = {
                    100, 300
            };
            n.vibrate = pattern;
        } else if ("short".equals(vibrationMode)) {
            long[] pattern = {
                    100, 300, 100, 300
            };
            n.vibrate = pattern;
        } else if ("medium".equals(vibrationMode)) {
            long[] pattern = {
                    300, 700, 300, 700
            };
            n.vibrate = pattern;
        } else if ("long".equals(vibrationMode)) {
            long[] pattern = {
                    300, 700, 300, 700, 300, 700, 300, 700
            };
            n.vibrate = pattern;
        } else if ("extra".equals(vibrationMode)) {
            long[] pattern = {
                    300, 700, 300, 700, 300, 700, 300, 700, 300, 700, 300, 700, 300, 700
            };
            n.vibrate = pattern;
        }
    }

    // Call this so that our process commits suicide if GUI isn't showing and
    // receiver isn't working.
    // This is completely against Android conventions but so many users
    // freak out when they see the process in their pointless task killers :-/
    public static void exitAsNeeded() {
        /*if (!MainActivity.sStarted && !PrefsActivity.sStarted && !sWorking) {
            if (sHandler == null) {
                sHandler = new Handler();
            }
            sHandler.removeCallbacks(doKill);
            sHandler.postDelayed(doKill, 2000);
        }*/
    }

    private static Runnable doKill = new Runnable() {
        public void run() {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    };
}