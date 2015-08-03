package com.althink.android.ossw.notifications.model;

/**
 * Created by krzysiek on 25/07/15.
 */
public class SubjectMessageItem {
    private String subject;
    private String message;

    public SubjectMessageItem(String subject, String message) {
        this.subject = subject;
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SubjectMessageItem{" +
                "subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
