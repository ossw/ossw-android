package com.althink.android.ossw.emulator.fonts;

import com.althink.android.ossw.watch.WatchConstants;

/**
 * Created by krzysiek on 07/08/15.
 */
public class FontUtils {

    public static FontInfo resolveFont(int fontType) {
        switch (fontType & 0x1F) {
            case WatchConstants.FONT_OPTION_NORMAL:
                return new OptionsNormal().getFontInfo();
            case WatchConstants.FONT_OPTION_BIG:
                return new OptionsBig().getFontInfo();
            case WatchConstants.FONT_SMALL_BOLD:
                return new SmallBold().getFontInfo();
            case WatchConstants.FONT_SMALL_REGULAR:
                return new SmallRegular().getFontInfo();
            case WatchConstants.FONT_NORMAL_BOLD:
                return new NormalBold().getFontInfo();
            case WatchConstants.FONT_NORMAL_REGULAR:
                return new NormalRegular().getFontInfo();
            case WatchConstants.FONT_BIG_REGULAR:
                return new BigRegular().getFontInfo();
        }
        return new NormalRegular().getFontInfo();
    }

    public static CharInfo resolveCharInfo(char c, FontInfo fontInfo) {
        if ((c < fontInfo.getMinChar()) || (c > fontInfo.getMaxChar())) {
            return null;
        }

        CharInfoLookup lookupTable = null;
        for (CharInfoLookup lookup : fontInfo.getCharInfoLookup()) {
            if (c >= lookup.getMinChar() && c <= lookup.getMaxChar()) {
                lookupTable = lookup;
            }
        }
        if (lookupTable == null) {
            return null;
        }
        int charIndex = c - lookupTable.getMinChar();
        return lookupTable.getCharTable()[charIndex];
    }

    public static int calcTextWidth(String value, int ptr, FontInfo fontInfo, boolean splitWords, int maxWidth) {
        int width = 0;
        int lastNonSpace = 0;
        int lastWordEnd = 0;

        char c;
        while (ptr < value.length()) {
            c = value.charAt(ptr++);
            if (width > 0) {
                width += fontInfo.getCharSpace();
            } else if (isWhitespace(c)) {
                continue;
            }

            if (isNewLine(c)) {
                break;
            }

            width += calcCharWidth(c, fontInfo);

            if (width > maxWidth) {
                width = (splitWords || lastWordEnd == 0) ? lastNonSpace : lastWordEnd;
                break;
            }

            if (isWhitespace(c)) {
                lastWordEnd = lastNonSpace;
            } else {
                lastNonSpace = width;
            }

        }
        return width > WatchConstants.SCREEN_WIDTH ? WatchConstants.SCREEN_WIDTH : width;
    }

    public static String calcTextToDraw(String text, int ptr, int startX, int startY, int width, int height, int fontType, int fontAlignment) {
        FontInfo fontInfo = FontUtils.resolveFont(fontType);
        int initPtr = ptr;
        if (text != null) {
            int prevPtr = ptr;
            int x = startX;
            int y = startY;
            if (width == 0) {
                width = WatchConstants.SCREEN_WIDTH - x;
            }
            if (height == 0) {
                height = WatchConstants.SCREEN_HEIGHT - y;
            }
            boolean multiline = (fontAlignment & WatchConstants.TEXT_FLAGS_MULTILINE) != 0;
            boolean splitWord = (fontAlignment & WatchConstants.TEXT_FLAGS_SPLIT_WORD) != 0;

            int maxY = y + height;
            boolean lastLine;
            do {
                lastLine = !multiline || (y + 2 * fontInfo.getHeight() > maxY);

                int textWidth = FontUtils.calcTextWidth(text, ptr, fontInfo, splitWord || !multiline, width);

                if ((fontAlignment & WatchConstants.HORIZONTAL_ALIGN_CENTER) != 0) {
                    x += (width - textWidth) / 2;
                } else if ((fontAlignment & WatchConstants.HORIZONTAL_ALIGN_RIGHT) != 0) {
                    x += (width - textWidth);
                }
                int maxX = x + textWidth;

                boolean firstChar = true;
                char c = 0;
                while (ptr < text.length()) {
                    c = text.charAt(ptr++);
                    if (firstChar && FontUtils.isWhitespace(c)) {
                        continue;
                    }
                    firstChar = false;
                    int charWidth = FontUtils.calcCharWidth(c, fontInfo);
                    if (x + charWidth > maxX) {
                        //overflow
                        ptr = prevPtr;
                        break;
                    }

                    x += charWidth;
                    x += fontInfo.getCharSpace();
                    prevPtr = ptr;
                }
                if (ptr == text.length()) {
                    lastLine = true;
                }

                x = startX;
                y += fontInfo.getHeight() + (c == 11 ? fontInfo.getHeight() / 4 : 0);
            } while (!lastLine);
            return text.substring(initPtr, ptr);
        }
        return "";
    }

    public static int calcCharWidth(char c, FontInfo fontInfo) {
        if (c == ' ' || c == '\t') {
            return fontInfo.getSpaceSize();
        }
        CharInfo charInfo = resolveCharInfo(c, fontInfo);
        if (charInfo == null) {
            return fontInfo.getSpaceSize();
        }
        return charInfo.getWidth();
    }

    public static boolean isWhitespace(char c) {
        return c == ' ' || c == '\t' || isNewLine(c);
    }

    public static boolean isNewLine(char c) {
        return c == 10 || c == 13 || c == 11 /*vertical tab*/;
    }

    public static int calcTextHeight(String text, int startX, int startY, int width, int height, int fontType, int fontAlignment) {
        FontInfo fontInfo = FontUtils.resolveFont(fontType);
        int ptr = 0;
        int prevPtr = ptr;
        int x = startX;
        int y = startY;

        if (width == 0) {
            width = WatchConstants.SCREEN_WIDTH - x;
        }
        if (height == 0) {
            height = WatchConstants.SCREEN_HEIGHT - y;
        }
        boolean multiline = (fontAlignment & WatchConstants.TEXT_FLAGS_MULTILINE) != 0;
        boolean splitWord = (fontAlignment & WatchConstants.TEXT_FLAGS_SPLIT_WORD) != 0;

        int maxY = y + height;
        boolean lastLine;
        do {
            lastLine = !multiline || (y + 2 * fontInfo.getHeight() > maxY);
            int textWidth = FontUtils.calcTextWidth(text, ptr, fontInfo, splitWord || !multiline, width);

            if ((fontAlignment & WatchConstants.HORIZONTAL_ALIGN_CENTER) != 0) {
                x += (width - textWidth) / 2;
            } else if ((fontAlignment & WatchConstants.HORIZONTAL_ALIGN_RIGHT) != 0) {
                x += (width - textWidth);
            }
            int maxX = x + textWidth;

            boolean firstChar = true;
            char c = 0;
            while (ptr < text.length()) {
                c = text.charAt(ptr++);
                if (firstChar && FontUtils.isWhitespace(c)) {
                    continue;
                }
                firstChar = false;
                int charWidth = FontUtils.calcCharWidth(c, fontInfo);
                if (x + charWidth > maxX) {
                    //overflow
                    ptr = prevPtr;
                    break;
                }

                x += charWidth;
                x += fontInfo.getCharSpace();
                prevPtr = ptr;
            }
            if (ptr == text.length()){
                lastLine = true;
            }

            x = startX;
            y += fontInfo.getHeight();
            if (!lastLine) {
                y += (c == 11 ? fontInfo.getHeight() / 4 : 0);
            }
        } while (!lastLine);

        return y - startY;
    }
}
