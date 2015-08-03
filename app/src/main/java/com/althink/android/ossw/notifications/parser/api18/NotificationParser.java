//package com.althink.android.ossw.notifications.model.api19;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;
//
//import android.app.Notification;
//import android.util.Log;
//
//public enum NotificationParser {
//	SMS("com.android.mms", new DefaultTicker()),
//    GMAIL("com.google.android.gm", new EmailBigView()),
//    EMAIL("com.android.email", new EmailBigView()),
//    MISSED_CALL("com.android.phone", new MissedCallBigView()),
//    MISSED_CALL_5("com.android.server.telecom", new MissedCallBigView()),
//    THREEMA("ch.threema.app", new DefaultView()),
//	TEXTSECURE("org.thoughtcrime.securesms", new DefaultView()),
//	HANGOUTS("com.google.android.talk",	new DefaultView()),
//	FACEBOOK("com.facebook.orca", new DefaultView()),
//	SYKPE("com.skype.raider", new DefaultView()),
//	WHATSAPP("com.whatsapp", new DefaultBigView()),
//	CHADDER("com.etransfr.chadder", new DefaultView()),
//	SAYHEY("de.simyo.app.sayhey", new DefaultView()),
//	TELEGRAM("org.telegram.messenger", new DefaultView());
//
//	private static final String TAG = NotificationParser.class.getName();
//
//	private String packageName;
//	private MessageParser parser;
//
//	NotificationParser(String packageName, MessageParser parser) {
//		this.packageName = packageName.toLowerCase(Locale.ENGLISH);
//		this.parser = parser;
//	}
//
//	public static Message getMessage(String packageName, Notification notification) {
//		String notificationPackage = packageName.toLowerCase(
//				Locale.ENGLISH);
//
//		for (NotificationParser messenger : NotificationParser.values()) {
//			if (!messenger.packageName.equals(notificationPackage))
//				continue;
//
//			Log.d(TAG, "Found matching messenger: " + messenger.packageName);
//
//			Message result = messenger.parser.parse(notification);
//
//			if (result == null)
//				return null;
//
//			result.app = packageName;
//			result.time = new SimpleDateFormat("yyy-MM-dd HH:mm", Locale.US).format(new Date());
//
//			return result;
//		}
//
//		return null;
//	}
//}
