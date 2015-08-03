//package com.althink.android.ossw.notifications.model.api19;
//
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//
//import android.annotation.SuppressLint;
//import android.app.Notification;
//import android.os.Build;
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.text.TextUtils;
//import android.util.Log;
//import android.widget.RemoteViews;
//
//import com.althink.android.ossw.notifications.NotificationListener;
//
//@SuppressLint("NewApi")
//public class DefaultBigView implements MessageParser {
//    private static final String TAG = DefaultBigView.class.getName();
//
//    @Override
//    public Message parse(Notification notification) {
//        Message result = new Message();
//
//        if (notification.actions != null) {
//            for (int i = 0; i <
//                    notification.actions.length; i++) {
//                Notification.Action action = notification.actions[i];
//                Log.d(TAG, "FOUND ACTION: " + action.title + ", " + action.actionIntent);
//
//            }
//        }
//
//        try {
//            RemoteViews views = notification.bigContentView;
//            if (views == null) {
//                return null;
//            }
//            Class<?> rvClass = views.getClass();
//
//            Field field;
//
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                field = rvClass.getSuperclass().getDeclaredField("mActions");
//            } else {
//                field = rvClass.getDeclaredField("mActions");
//            }
//            field.setAccessible(true);
//
//            @SuppressWarnings("unchecked")
//            ArrayList<Parcelable> actions = (ArrayList<Parcelable>) field
//                    .get(views);
//
//            for (Parcelable action : actions) {
//                try {
//                    // create parcel from action
//                    Parcel parcel = Parcel.obtain();
//                    action.writeToParcel(parcel, 0);
//                    parcel.setDataPosition(0);
//
//                    // check if is 2 / ReflectionAction
//                    int tag = parcel.readInt();
//                    if (tag != 2)
//                        continue;
//
//                    int viewId = parcel.readInt();
//
//                    String methodName = parcel.readString();
//                    if (methodName == null || !methodName.equals("setText")) {
//                        Log.w(TAG, "# Not setText: " + methodName);
//                        continue;
//                    }
//
//                    // should be 10 / Character Sequence, here
//                    parcel.readInt();
//
//                    // Store the actual string
//                    CharSequence fromParcel = TextUtils.CHAR_SEQUENCE_CREATOR
//                            .createFromParcel(parcel);
//                    String value = fromParcel != null ? fromParcel.toString() : null;
//
//                    Log.d(TAG, "viewId is " + getViewName(viewId));
//                    Log.d(TAG, "Found value: " + value);
//
//                    if (viewId == NotificationListener.LINE_1 && value != null) {
//                        int indexDelimiter = value.indexOf(':');
//
//                        if (indexDelimiter != -1) {
//                            result.subject = value.substring(0, indexDelimiter);
//                            result.message = value
//                                    .substring(indexDelimiter + 2);
//                        }
//                    }
//
//                    parcel.recycle();
//                } catch (Exception e) {
//                    Log.e(TAG, "Error accessing object!", e);
//                }
//            }
//
//            //    if (result.subject == null || result.message == null)
//            //        return null;
//
//            return result;
//        } catch (Exception e) {
//            Log.e(TAG, "Could not access mActions!", e);
//
//            return null;
//        }
//    }
//
//    private String getViewName(int viewId) {
//        if(viewId == NotificationListener.TITLE){
//                return "TITLE";
//        }
//        if(viewId == NotificationListener.INFO){
//            return "INFO";
//        }
//        if(viewId == NotificationListener.TEXT){
//            return "TEXT";
//        }
//        if(viewId == NotificationListener.LINE_1){
//            return "LINE_1";
//        }
//        if(viewId == NotificationListener.ICON){
//            return "ICON";
//        }
//        if(viewId == NotificationListener.BIG_TEXT){
//            return "BIG_TEXT";
//        }
//        if(viewId == NotificationListener.TIME){
//            return "TIME";
//        }
//        if(viewId == NotificationListener.INBOX_MORE){
//            return "INBOX_MORE";
//        }
//        if(viewId == NotificationListener.INBOX_TEXT_0){
//            return "INBOX_TEXT_0";
//        }
//        if(viewId == NotificationListener.INBOX_TEXT_1){
//            return "INBOX_TEXT_1";
//        }
//        if(viewId == NotificationListener.INBOX_TEXT_2){
//            return "INBOX_TEXT_2";
//        }
//        if(viewId == NotificationListener.INBOX_TEXT_3){
//            return "INBOX_TEXT_3";
//        }
//        if(viewId == NotificationListener.INBOX_TEXT_4){
//            return "INBOX_TEXT_4";
//        }
//        if(viewId == NotificationListener.INBOX_TEXT_5){
//            return "INBOX_TEXT_5";
//        }
//        if(viewId == NotificationListener.INBOX_TEXT_6){
//            return "INBOX_TEXT_6";
//        }
//        return ""+viewId;
//
//    }
//}
