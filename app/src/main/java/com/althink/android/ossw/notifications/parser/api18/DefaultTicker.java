//package com.althink.android.ossw.notifications.model.api19;
//
//import android.app.Notification;
//
//public class DefaultTicker implements MessageParser {
//	@Override
//	public Message parse(Notification notification) {
//		Message result = new Message();
//
//		String ticker = notification.tickerText.toString();
//
//		int indexDelimiter = ticker.indexOf(':');
//
//		if (indexDelimiter == -1)
//			return null;
//
//		result.subject = ticker.substring(0, indexDelimiter);
//		result.message = ticker.substring(indexDelimiter + 2);
//
//		return result;
//	}
//}
