package com.althink.android.ossw.utils;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.althink.android.ossw.OsswApp;
import com.althink.android.ossw.R;
import com.althink.android.ossw.notifications.message.DialogSelectMessageBuilder;
import com.althink.android.ossw.notifications.message.NotificationMessageBuilder;
import com.althink.android.ossw.notifications.model.NotificationType;
import com.althink.android.ossw.service.OsswService;
import com.althink.android.ossw.watch.WatchConstants;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.client.util.Lists;
import com.google.api.client.util.Maps;
import com.google.api.client.util.Sets;
import com.google.api.services.tasks.Tasks;
import com.google.api.services.tasks.TasksScopes;
import com.google.api.services.tasks.model.Task;
import com.google.api.services.tasks.model.TaskList;
import com.google.api.services.tasks.model.TaskLists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class TasksManager {
    private final static String TAG = TasksManager.class.getSimpleName();
    private static TasksManager instance;
    private static int level = 0;
    private static int account = 0;
    private static String taskListId = "";
    private static boolean showCompleted = true;

    GoogleAccountCredential mCredential;
    private static final String[] SCOPES = {TasksScopes.TASKS};
    private static final String TASK_COMPLETED = "completed";
    private static final String TASK_NEEDS_ACTION = "needsAction";

    static final long LIST_MAX_RESULTS = 100;

    // Tasks data cache
    static ArrayList<String> accountList;
    static Map<String, List<TaskList>> taskLists = Maps.newHashMap();
    static Map<String, List<Task>> tasks = Maps.newHashMap();

    private TasksManager() {
        Context context = OsswApp.getContext();
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.GET_ACCOUNTS)
                == PackageManager.PERMISSION_GRANTED) {
//            accountList = Arrays.asList(AccountManager.get(context).getAccountsByType("com.google"));
            refreshAccounts();
            mCredential = GoogleAccountCredential.usingOAuth2(
                    context, Arrays.asList(SCOPES))
                    .setBackOff(new ExponentialBackOff());
        }
    }

    public static TasksManager getInstance() {
        if (instance == null)
            instance = new TasksManager();
        return instance;
    }

    private boolean singleAccount() {
        refreshAccounts();
        return accountList.size() == 1;
    }

    public void handle(int buttons, int item) {
        Log.d(TAG, "Handling gtasks event with parameters: " + buttons + ", " + item);
        if (accountList == null || accountList.size() < 1 || !isGooglePlayServicesAvailable() || !isDeviceOnline())
            return;
        if (level == 0 && singleAccount())
            level = 1;
        if (buttons == 0) {
            if (level == 0)
                showAccounts();
            else if (level == 1)
                showTaskLists();
            else if (level == 2)
                showTasks();
        } else {
            if (buttons == WatchConstants.BUTTON_BACK) {
                if (level == 0) {
                    FunctionHandler.closeDialog();
                } else if (level == 1) {
                    if (singleAccount())
                        FunctionHandler.closeDialog();
                    else {
                        level = 0;
                        showAccounts();
                    }
                } else if (level == 2) {
                    level = 1;
                    showTaskLists();
                }
            } else if (buttons == WatchConstants.BUTTON_SELECT) {
                Log.d(TAG, "Select button on level: " + level);
                if (level == 0) {
                    account = item;
                    level = 1;
                    showTaskLists();
                } else if (level == 1) {
                    taskListId = taskLists.get(accountList.get(account)).get(item).getId();
                    level = 2;
                    showTasks();
                } else if (level == 2) {
                    toggleTaskCompletion(item);
                }
            } else if (buttons == (WatchConstants.BUTTON_SELECT | WatchConstants.BUTTON_HOLD)) {
                if (level == 2) {
                    if (showCompleted && countNotCompletedTasks() == 0)
                        return;
                    showCompleted = !showCompleted;
                    int selItem = 0;
                    List<Task> list = tasks.get(taskListId);
                    if (showCompleted) {
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getStatus().equals(TASK_NEEDS_ACTION))
                                if (item == 0) {
                                    selItem = i;
                                    break;
                                } else
                                    item--;
                        }
                    } else {
                        int countCompleted = 0;
                        for (int i = 0; i <= item; i++)
                            if (list.get(i).getStatus().equals(TASK_COMPLETED))
                                countCompleted++;
                        selItem = item - countCompleted;
                        if (selItem < 0)
                            selItem = 0;
                    }
                    uploadTasksFromCache(taskListId, selItem);
                }
            }
        }
    }

    private Task getTaskFromList(int item) {
        List<Task> list = tasks.get(taskListId);
        if (showCompleted) {
            return list.get(item);
        } else {
            int notCompleted = 0;
            for (Task t : list) {
                if (!t.getStatus().equals(TASK_COMPLETED) && item == notCompleted++) {
                    return t;
                }
            }
        }
        return new Task();
    }

    private int countNotCompletedTasks() {
        List<Task> list = tasks.get(taskListId);
        int notCompleted = 0;
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).getStatus().equals(TASK_NEEDS_ACTION))
                notCompleted++;
        return notCompleted;
    }

    public void toggleTaskCompletion(int item) {
        Log.d(TAG, "Toggle task completed status: item #" + item);
        DateTime dateTime = new DateTime(new Date());
        final Task task = getTaskFromList(item);
        if (task.getStatus().equals(TASK_COMPLETED)) {
            task.setStatus(TASK_NEEDS_ACTION).setCompleted(null);
        } else {
            task.setStatus(TASK_COMPLETED).setCompleted(dateTime);
            if (!showCompleted) {
                if (countNotCompletedTasks() == 0)
                    showCompleted = true;
                uploadTasksFromCache(taskListId, item);
            }
        }
        mCredential.setSelectedAccountName(accountList.get(account));
        new MakeRequestTask<Boolean>(mCredential) {
            @Override
            protected Boolean getDataFromApi(Tasks mService) throws IOException {
                Log.d(TAG, "Patching task status: " + task);
                mService.tasks().update(taskListId, task.getId(), task).execute();
                return true;
            }
        }.execute();
    }

    public void refreshAccounts() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(OsswApp.getContext());
        accountList = new ArrayList<>(sharedPref.getStringSet("google_tasks_accounts", new HashSet<String>()));
        if (account >= accountList.size())
            account = 0;
    }

    public void showAccounts() {
        List<String> items = new ArrayList<>(accountList);
        Log.d(TAG, "Choose an account: " + items.toString());
        NotificationMessageBuilder builder = new DialogSelectMessageBuilder(OsswApp.getContext().getString(R.string.tasks_accounts_title), items, account, WatchConstants.PHONE_FUNCTION_GTASKS, 0);
        OsswService.getInstance().uploadNotification(0, NotificationType.DIALOG_SELECT, builder.build(), 0, 0, null);
    }

    private void uploadTaskListsFromCache(String currentAccount) {
        List<TaskList> result = taskLists.get(currentAccount);
        if (result == null || result.size() == 0)
            return;
        List<String> items = new ArrayList<>();
        int selItem = 0;
        for (TaskList list : result) {
            if (list.getId().equals(taskListId))
                selItem = items.size();
            items.add(list.getTitle());
        }
        Log.d(TAG, "Choose a tasks list: " + items.toString());
        NotificationMessageBuilder builder = new DialogSelectMessageBuilder(OsswApp.getContext().getString(R.string.tasks_lists_title), items, selItem, WatchConstants.PHONE_FUNCTION_GTASKS, 0);
        OsswService.getInstance().uploadNotification(0, NotificationType.DIALOG_SELECT, builder.build(), 0, 0, null);
    }

    private boolean refreshTaskLists(String key, List<TaskList> result) {
        List<TaskList> list = taskLists.get(key);
        if (list != null) {
            HashSet<TaskList> cachedLists = Sets.newHashSet();
            cachedLists.addAll(list);
            HashSet<TaskList> newLists = Sets.newHashSet();
            newLists.addAll(result);
            if (newLists.equals(cachedLists))
                return false;
        }
        taskLists.put(key, result);
        return true;
    }

    public void showTaskLists() {
        final String currentAccount = accountList.get(account);
        uploadTaskListsFromCache(currentAccount);
        mCredential.setSelectedAccountName(currentAccount);
        new MakeRequestTask<List<TaskList>>(mCredential) {
            @Override
            protected List<TaskList> getDataFromApi(Tasks mService) throws IOException {
                TaskLists result = mService.tasklists().list().setFields("items(id,title)")
                        .setMaxResults(LIST_MAX_RESULTS)
                        .execute();
                return result.getItems();
            }

            protected void onPostExecute(List<TaskList> result) {
                if (refreshTaskLists(currentAccount, result))
                    uploadTaskListsFromCache(currentAccount);
            }

            protected void onCancelled() {
                super.onCancelled();
                if (level > 0)
                    level--;
            }
        }.execute();
    }

    private void uploadTasksFromCache(String taskListKey, int selectedItem) {
        List<Task> ref = tasks.get(taskListKey);
        if (ref == null || ref.size() == 0)
            return;
        List<Task> result;
        if (showCompleted) {
            result = new ArrayList<>(ref);
        } else {
            result = Lists.newArrayList();
            for (Task t : ref) {
                if (!t.getStatus().equals(TASK_COMPLETED))
                    result.add(t);
            }
        }
        int itemsSize = result.size();
        if (itemsSize == 0)
            return;
        if (selectedItem >= itemsSize)
            selectedItem = itemsSize - 1;
        ArrayList<String> items = new ArrayList<>();
        int bitSetLength = itemsSize >> 3;
        if ((itemsSize & 7) > 0)
            bitSetLength++;
        byte[] bitset = new byte[bitSetLength];
        int bitCount = 0;
        for (Task task : result) {
            String title = task.getTitle();
            if (title.length() > 30)
                title = title.substring(0, 30);
            if (task.getParent() != null && !task.getParent().isEmpty())
                title = "> " + title;
            if (showCompleted && task.getStatus().equals(TASK_COMPLETED)) {
                bitset[bitCount >> 3] |= 1 << (bitCount & 7);
            }
            bitCount++;
            items.add(title);
        }
        Log.d(TAG, "Choose a task: " + items.toString());
        NotificationMessageBuilder builder = new DialogSelectMessageBuilder(OsswApp.getContext().getString(R.string.tasks_title), items, selectedItem,
                WatchConstants.PHONE_FUNCTION_GTASKS, WatchConstants.STYLE_CHECK_BOX | WatchConstants.STYLE_STRIKE, bitset);
        OsswService.getInstance().uploadNotification(0, NotificationType.DIALOG_SELECT, builder.build(), 0, 0, null);

    }

    private boolean refreshTasks(String key, List<Task> result) {
        List<Task> list = tasks.get(key);
        if (list != null) {
            HashSet<Task> cachedTasks = Sets.newHashSet();
            cachedTasks.addAll(list);
            HashSet<Task> newTasks = Sets.newHashSet();
            newTasks.addAll(result);
            if (newTasks.equals(cachedTasks))
                return false;
        }
        tasks.put(key, result);
        return true;
    }

    public void showTasks() {
        String currentAccount = accountList.get(account);
        uploadTasksFromCache(taskListId, 0);
        mCredential.setSelectedAccountName(currentAccount);
        new MakeRequestTask<List<Task>>(mCredential) {
            @Override
            protected List<Task> getDataFromApi(Tasks mService) throws IOException {
                com.google.api.services.tasks.model.Tasks result =
                        mService.tasks().list(taskListId).setFields("items(id,title,status,parent)")
                                .setShowCompleted(showCompleted)
                                .setMaxResults(LIST_MAX_RESULTS)
                                .execute();
                return result.getItems();
            }

            protected void onPostExecute(List<Task> result) {
                if (refreshTasks(taskListId, result))
                    uploadTasksFromCache(taskListId, 0);
            }

            protected void onCancelled() {
                super.onCancelled();
                if (level > 0)
                    level--;
            }
        }.execute();
    }

    /**
     * Checks whether the device currently has a network connection.
     *
     * @return true if the device has a network connection, false otherwise.
     */
    private boolean isDeviceOnline() {
        ConnectivityManager connMgr =
                (ConnectivityManager) OsswApp.getContext().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    /**
     * Check that Google Play services APK is installed and up to date.
     *
     * @return true if Google Play Services is available and up to
     * date on this device; false otherwise.
     */
    private boolean isGooglePlayServicesAvailable() {
        GoogleApiAvailability apiAvailability =
                GoogleApiAvailability.getInstance();
        final int connectionStatusCode =
                apiAvailability.isGooglePlayServicesAvailable(OsswApp.getContext().getApplicationContext());
        return connectionStatusCode == ConnectionResult.SUCCESS;
    }


    /**
     * An asynchronous task that handles the Google Tasks API call.
     * Placing the API calls in their own task ensures the UI stays responsive.
     */
    abstract private class MakeRequestTask<Result> extends AsyncTask<Void, Void, Result> {
        private com.google.api.services.tasks.Tasks mService = null;
        private Exception mLastError = null;

        public MakeRequestTask(GoogleAccountCredential credential) {
            HttpTransport transport = AndroidHttp.newCompatibleTransport();
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
            mService = new com.google.api.services.tasks.Tasks.Builder(
                    transport, jsonFactory, credential)
                    .setApplicationName("Google Tasks API")
                    .build();
        }

        /**
         * Background task to call Google Tasks API.
         *
         * @param params no parameters needed for this task.
         */
        @Override
        protected Result doInBackground(Void... params) {
            try {
                return getDataFromApi(mService);
            } catch (Exception e) {
                mLastError = e;
                cancel(true);
                return null;
            }
        }

        abstract protected Result getDataFromApi(com.google.api.services.tasks.Tasks mService) throws IOException;

        @Override
        protected void onCancelled() {
            if (mLastError != null) {
                if (mLastError instanceof UserRecoverableAuthIOException) {
                    Intent recover = ((UserRecoverableAuthIOException) mLastError).getIntent();
                    recover.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    OsswApp.getContext().startActivity(recover);
                } else
                    Log.e(TAG, mLastError.toString());
            } else {
                Log.e(TAG, "Request cancelled.");
            }
        }
    }
}