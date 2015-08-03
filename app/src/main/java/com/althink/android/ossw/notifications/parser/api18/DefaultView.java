//package com.althink.android.ossw.notifications.model.api19;
//
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//
//import android.app.Notification;
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.text.TextUtils;
//import android.util.Log;
//import android.widget.RemoteViews;
//
//import com.althink.android.ossw.notifications.NotificationListener;
//
//public class DefaultView implements MessageParser {
//	private static final String TAG = DefaultView.class.getName();
//
//	@Override
//	public Message parse(Notification notification) {
//		Message result = new Message();
//
//		try {
//			RemoteViews views = notification.contentView;
//			Class<?> rvClass = views.getClass();
//
//			Field field = rvClass.getDeclaredField("mActions");
//			field.setAccessible(true);
//
//			@SuppressWarnings("unchecked")
//			ArrayList<Parcelable> actions = (ArrayList<Parcelable>) field
//					.get(views);
//
//			for (Parcelable action : actions) {
//				try {
//					// create parcel from action
//					Parcel parcel = Parcel.obtain();
//					action.writeToParcel(parcel, 0);
//					parcel.setDataPosition(0);
//
//					// check if is 2 / ReflectionAction
//					int tag = parcel.readInt();
//					if (tag != 2)
//						continue;
//
//					int viewId = parcel.readInt();
//
//					String methodName = parcel.readString();
//					if (methodName == null || !methodName.equals("setText")) {
//						Log.w(TAG, "# Not setText: " + methodName);
//						continue;
//					}
//
//					// should be 10 / Character Sequence, here
//					parcel.readInt();
//
//					// Store the actual string
//					CharSequence value = TextUtils.CHAR_SEQUENCE_CREATOR
//							.createFromParcel(parcel);
//
//					Log.d(TAG, "viewId is " + viewId);
//					Log.d(TAG, "Found value: " + value.toString());
//
//					if (viewId == NotificationListener.TITLE)
//						result.subject = value.toString();
//					else if (viewId == NotificationListener.TEXT)
//						result.message = value.toString();
//
//					parcel.recycle();
//				} catch (Exception e) {
//					Log.e(TAG, "Error accessing object!", e);
//				}
//			}
//
//			if (result.subject == null || result.message == null)
//				return null;
//
//			return result;
//		} catch (Exception e) {
//			Log.e(TAG, "Could not access mActions!", e);
//
//			return null;
//		}
//	}
//}
