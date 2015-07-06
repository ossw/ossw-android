package com.althink.android.ossw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by krzysiek on 05/06/15.
 */
public class NotificationListener  extends NotificationListenerService {

    private String TAG = this.getClass().getSimpleName();

    private int ICON;
    private int TITLE;
    private int BIG_TEXT;
    private int TEXT;
    private int BIG_PIC;
    private int EMAIL_0;
    private int EMAIL_1;
    private int EMAIL_2;
    private int EMAIL_3;
    private int EMAIL_4;
    private int EMAIL_5;
    private int EMAIL_6;
    private int INBOX_MORE;

    Handler handler = new Handler(Looper.getMainLooper());

    //  private NLServiceReceiver nlservicereciver;
    @Override
    public void onCreate() {
        super.onCreate();
       /* nlservicereciver = new NLServiceReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.kpbird.nlsexample.NOTIFICATION_LISTENER_SERVICE_EXAMPLE");
        registerReceiver(nlservicereciver,filter);*/

        Resources resources = null;
        try {
            PackageManager pkm = getPackageManager();
            resources = pkm.getResourcesForApplication("com.google.android.gm");
        } catch (Exception ex){
            //Log.e(TAG, "Failed to initialize ids: " + ex.getMessage());
        }
        if (resources == null)
            return;

        ICON = resources.getIdentifier("android:id/icon", null, null);
        TITLE = resources.getIdentifier("android:id/title", null, null);
        BIG_TEXT = resources.getIdentifier("android:id/big_text", null, null);
        TEXT = resources.getIdentifier("android:id/text", null, null);
        BIG_PIC = resources.getIdentifier("android:id/big_picture", null, null);
        EMAIL_0 = resources.getIdentifier("android:id/inbox_text0", null, null);
        EMAIL_1 = resources.getIdentifier("android:id/inbox_text1", null, null);
        EMAIL_2 = resources.getIdentifier("android:id/inbox_text2", null, null);
        EMAIL_3 = resources.getIdentifier("android:id/inbox_text3", null, null);
        EMAIL_4 = resources.getIdentifier("android:id/inbox_text4", null, null);
        EMAIL_5 = resources.getIdentifier("android:id/inbox_text5", null, null);
        EMAIL_6 = resources.getIdentifier("android:id/inbox_text6", null, null);
        INBOX_MORE = resources.getIdentifier("android:id/inbox_more", null, null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //unregisterReceiver(nlservicereciver);
    }

    @Override
    public void onNotificationPosted(final StatusBarNotification sbn) {

        //Log.i(TAG,"**********  onNotificationPosted");
        //Log.i(TAG,"ID :" + sbn.getId() + "t" + sbn.getNotification().tickerText + "t" + sbn.getPackageName());
        //Intent i = new  Intent("com.kpbird.nlsexample.NOTIFICATION_LISTENER_EXAMPLE");
        //i.putExtra("notification_event","onNotificationPosted :" + sbn.getPackageName() + "n");
        //sendBroadcast(i);
        /* Re-create a 'local' view group from the info contained in the remote view */


        handler.postDelayed(new Runnable() {
            public void run() {

         /*       RemoteViews views = (RemoteViews) sbn.getNotification().bigContentView;
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                ViewGroup localView = (ViewGroup) inflater.inflate(views.getLayoutId(), null);
                views.reapply(getApplicationContext(), localView);

                logViewText("TITLE:", TITLE, localView);
                logViewText("BIG_TEXT:", BIG_TEXT, localView);
                logViewText("TEXT:", TEXT, localView);
                logViewText("EMAIL_0:", EMAIL_0, localView);
                logViewText("EMAIL_1:", EMAIL_1, localView);
                logViewText("EMAIL_2:", EMAIL_2, localView);
                logViewText("EMAIL_3:", EMAIL_3, localView);
                logViewText("EMAIL_4:", EMAIL_4, localView);
                logViewText("EMAIL_5:", EMAIL_5, localView);
                logViewText("EMAIL_6:", EMAIL_6, localView);
                logViewText("INBOX_MORE:", INBOX_MORE, localView);*/
            }
        }, 1000 );

    }

    private void logViewText( String name, int key, ViewGroup localView){
        TextView tv = ((TextView) localView.findViewById(key));
        if(tv == null) {
            return;
        }
        //Log.d(TAG, name + " " + tv.getText());
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        //Log.i(TAG,"********** onNOtificationRemoved");
        //Log.i(TAG,"ID :" + sbn.getId() + "t" + sbn.getNotification().tickerText +"t" + sbn.getPackageName());
        //Intent i = new  Intent("com.kpbird.nlsexample.NOTIFICATION_LISTENER_EXAMPLE");
        //i.putExtra("notification_event","onNotificationRemoved :" + sbn.getPackageName() + "n");

        //sendBroadcast(i);
    }

    class NLServiceReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, "Command: " + intent.getStringExtra("command"));

            /*if(intent.getStringExtra("command").equals("clearall")){
                NotificationListener.this.cancelAllNotifications();
            }
            else if(intent.getStringExtra("command").equals("list")){
                Intent i1 = new  Intent("com.kpbird.nlsexample.NOTIFICATION_LISTENER_EXAMPLE");
                i1.putExtra("notification_event","=====================");
                sendBroadcast(i1);
                int i=1;
                for (StatusBarNotification sbn : NLService.this.getActiveNotifications()) {
                    Intent i2 = new  Intent("com.kpbird.nlsexample.NOTIFICATION_LISTENER_EXAMPLE");
                    i2.putExtra("notification_event",i +" " + sbn.getPackageName() + "n");
                    sendBroadcast(i2);
                    i++;
                }
                Intent i3 = new  Intent("com.kpbird.nlsexample.NOTIFICATION_LISTENER_EXAMPLE");
                i3.putExtra("notification_event","===== Notification List ====");
                sendBroadcast(i3);

            }*/

        }
    }

}