package com.althink.android.ossw.emulator.fonts;

/**
 * Created by krzysiek on 05/07/15.
 */
public class FontInfo {
    int height;
    char minChar;
    char maxChar;
    int charSpace;
    int spaceSize;
    CharInfoLookup[] charInfoLookup;
    byte[] fontBitmaps;

    public FontInfo(int height, char minChar, char maxChar, int charSpace, int spaceSize, CharInfoLookup[] charInfoLookup, byte[] fontBitmaps) {
        this.height = height;
        this.minChar = minChar;
        this.maxChar = maxChar;
        this.charSpace = charSpace;
        this.spaceSize = spaceSize;
        this.charInfoLookup = charInfoLookup;
        this.fontBitmaps = fontBitmaps;
    }

    public int getHeight() {
        return height;
    }

    public char getMinChar() {
        return minChar;
    }

    public char getMaxChar() {
        return maxChar;
    }

    public int getCharSpace() {
        return charSpace;
    }

    public int getSpaceSize() {
        return spaceSize;
    }

    public CharInfoLookup[] getCharInfoLookup() {
        return charInfoLookup;
    }

    public byte[] getFontBitmaps() {
        return fontBitmaps;
    }
}
