//package com.althink.android.ossw.notifications.model.api19;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class Message {
//    public interface MessageListener {
//        public void onMessage(Message message);
//    }
//
//    public NotificationType type = null;
//    public String app = null;
//    public String time = null;
//    public String subject = null;
//    public String message = null;
//    public boolean aggregated = false;
//    public int count;
//    public List<MessageInfo> messages = new LinkedList<>();
//
//    @Override
//    public String toString() {
//        if (aggregated) {
//            StringBuilder sb = new StringBuilder();
//            sb.append(type).append(", ").append(time).append(", count: ").append(count).append(":\n");
//            for (MessageInfo message : messages) {
//                sb.append(message.subject).append(" -- ").append(message.info).append("\n");
//            }
//            return sb.toString();
//        } else {
//            return type + ", "+time+", sent from " + this.subject + ": " + this.message;
//        }
//    }
//}
