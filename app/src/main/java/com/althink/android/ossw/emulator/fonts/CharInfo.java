package com.althink.android.ossw.emulator.fonts;

/**
 * Created by krzysiek on 05/07/15.
 */
public class CharInfo {

    private int width;
    private int offset;

    public CharInfo(int width, int offset) {
        this.width = width;
        this.offset = offset;
    }

    public int getWidth() {
        return width;
    }

    public int getOffset() {
        return offset;
    }
}
