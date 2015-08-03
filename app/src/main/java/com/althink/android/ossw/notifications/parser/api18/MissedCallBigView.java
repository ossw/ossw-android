//package com.althink.android.ossw.notifications.model.api19;
//
//import android.annotation.SuppressLint;
//import android.app.Notification;
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.text.TextUtils;
//import android.util.Log;
//import android.widget.RemoteViews;
//
//import com.althink.android.ossw.notifications.NotificationListener;
//
//import java.lang.reflect.Field;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//
//@SuppressLint("NewApi")
//public class MissedCallBigView implements MessageParser {
//    private static final String TAG = MissedCallBigView.class.getName();
//
//    @Override
//    public Message parse(Notification notification) {
//        Message result = new Message();
//        result.type = NotificationType.MISSED_CALL;
//        result.time = new SimpleDateFormat("HH:mm").format(new java.util.Date(notification.when));
//
//        try {
//            RemoteViews views = notification.bigContentView;
//            if (views == null) {
//                views = notification.contentView;
//            }
//
//            Class<?> rvClass = views.getClass();
//
//            Field field = rvClass.getDeclaredField("mActions");
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
//
//
//                    if (methodName != null && methodName.equals("setTime")) {
//
//                        //should be 5
//                        parcel.readInt();
//
//                        if (viewId == NotificationListener.TIME) {
//                            //sender when one mail / number of messages when multiple
//                            //                  result.time =
//                            Log.i(TAG, "TIME: " + new java.util.Date(parcel.readLong()) + " " + parcel);
//                        }
//                    }
//
//                    if (methodName != null && methodName.equals("setText")) {
//
//
//                        // should be 10 /
//                        parcel.readInt();
//
//                        // Store the actual string
//                        String value = TextUtils.CHAR_SEQUENCE_CREATOR
//                                .createFromParcel(parcel).toString();
//
//                        Log.d(TAG, "viewId is " + viewId);
//                        Log.d(TAG, "Found value: " + value);
//
//                        if (viewId == NotificationListener.TITLE) {
//                            //sender when one mail / number of messages when multiple
//                            result.message = value;
//                            Log.i(TAG, "TITLE: " + value);
//                        }
//
//                        if (viewId == NotificationListener.TEXT) {
//                            // title + content when one mail only
//                            result.subject = value;
//                            Log.i(TAG, "BIG_TEXT: " + value);
//                        }
//
//                        if (viewId == NotificationListener.INFO) {
//                            result.count = Integer.parseInt(value);
//                        }
//
//
//                        if (
//                                viewId == NotificationListener.INBOX_TEXT_0 ||
//                                        viewId == NotificationListener.INBOX_TEXT_1 ||
//                                        viewId == NotificationListener.INBOX_TEXT_2 ||
//                                        viewId == NotificationListener.INBOX_TEXT_3 ||
//                                        viewId == NotificationListener.INBOX_TEXT_4 ||
//                                        viewId == NotificationListener.INBOX_TEXT_5 ||
//                                        viewId == NotificationListener.INBOX_TEXT_6) {
//                            // sender + content when multiple
//
//                            int indexDelimiter = value.indexOf("  ");
//
//                            result.aggregated = true;
//                            if (indexDelimiter != -1) {
//                                MessageInfo messageInfo = new MessageInfo();
//                                messageInfo.subject = value.substring(0, indexDelimiter);
//                                messageInfo.info = value
//                                        .substring(indexDelimiter + 2);
//
//                                result.messages.add(messageInfo);
//                            }
//                            //result.message += "\n" + value;
//                        }
//
//                        parcel.recycle();
//                    }
//                } catch (Exception e) {
//                    Log.e(TAG, "Error accessing object!", e);
//                }
//            }
//
//            if (result.message == null) {
//                return null;
//            }
//
//            return result;
//        } catch (Exception e) {
//            Log.e(TAG, "Could not access mActions!", e);
//
//            return null;
//        }
//    }
//}
