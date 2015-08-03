//package com.althink.android.ossw.notifications.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//
//import android.app.Service;
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.content.SharedPreferences.Editor;
//import android.util.Log;
//
//public class MessageStore {
//	private static final String TAG = MessageStore.class.getName();
//
//	private static MessageStore _instance = null;
//
//	public static synchronized MessageStore getInstance(Context context) {
//		if (_instance == null)
//			_instance = new MessageStore(context);
//
//		return _instance;
//	}
//
//	// --------
//
//	private static final int MAX_COUNT = 20;
//
//	private SharedPreferences preferences = null;
//	private List<Message> messages = null;
//	private MessageListener listener = null;
//
//	public MessageStore(Context context) {
//		this.preferences = context.getSharedPreferences("data",
//				Service.MODE_PRIVATE);
//
//		this.messages = new ArrayList<Message>();
//
//		try {
//			JSONArray array = new JSONArray(this.preferences.getString(
//					"messages", "[]"));
//
//			for (int i = 0; i < array.length(); i++) {
//				Message message = Message.fromJSON(array.getJSONObject(i));
//				this.messages.add(message);
//			}
//		} catch (JSONException e) {
//			Log.e(TAG, "Could not restore messages!", e);
//		}
//	}
//
//	public void addMessage(Message message) {
//		this.messages.add(0, message);
//
//		if (this.messages.size() > MAX_COUNT)
//			this.messages.remove(this.messages.size() - 1);
//
//		if (this.listener != null)
//			this.listener.onMessage(message);
//
//		try {
//			Editor editor = this.preferences.edit();
//
//			JSONArray array = new JSONArray();
//			for (Message current : this.messages) {
//				array.put(current.toJSON());
//			}
//
//			editor.putString("messages", array.toString());
//			editor.commit();
//		} catch (JSONException e) {
//			Log.e(TAG, "Could not store messages persistent!", e);
//		}
//	}
//
//	public void clear() {
//		this.messages.clear();
//
//		Editor editor = this.preferences.edit();
//		editor.clear();
//		editor.commit();
//	}
//
//	public List<Message> getMessages() {
//		return this.messages;
//	}
//
//	public void setListener(MessageListener listener) {
//		this.listener = listener;
//	}
//}
