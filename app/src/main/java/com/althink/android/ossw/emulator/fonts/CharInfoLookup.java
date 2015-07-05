package com.althink.android.ossw.emulator.fonts;

/**
 * Created by krzysiek on 05/07/15.
 */
public class CharInfoLookup {
    private char minChar;
    private char maxChar;
    private CharInfo[] charTable;

    public CharInfoLookup(char minChar, char maxChar, CharInfo[] charTable) {
        this.minChar = minChar;
        this.maxChar = maxChar;
        this.charTable = charTable;
    }

    public char getMinChar() {
        return minChar;
    }

    public char getMaxChar() {
        return maxChar;
    }

    public CharInfo[] getCharTable() {
        return charTable;
    }
}
