package com.althink.android.ossw.watchsets;

/**
 * Created by krzysiek on 29/06/15.
 */
public class KnownParseError extends RuntimeException {

    public KnownParseError(String message) {
        super(message);
    }

    public KnownParseError(String message, Exception e) {
        super(message, e);
    }
}
