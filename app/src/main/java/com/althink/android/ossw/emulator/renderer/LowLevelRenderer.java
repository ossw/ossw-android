package com.althink.android.ossw.emulator.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.althink.android.ossw.emulator.fonts.BigRegular;
import com.althink.android.ossw.emulator.fonts.CharInfo;
import com.althink.android.ossw.emulator.fonts.CharInfoLookup;
import com.althink.android.ossw.emulator.fonts.FontInfo;
import com.althink.android.ossw.emulator.fonts.FontUtils;
import com.althink.android.ossw.emulator.fonts.NormalBold;
import com.althink.android.ossw.emulator.fonts.NormalRegular;
import com.althink.android.ossw.emulator.fonts.OptionsBig;
import com.althink.android.ossw.emulator.fonts.OptionsNormal;
import com.althink.android.ossw.emulator.fonts.SmallBold;
import com.althink.android.ossw.emulator.fonts.SmallRegular;
import com.althink.android.ossw.watch.WatchConstants;

/**
 * Created by krzysiek on 14/06/15.
 */
public class LowLevelRenderer {

    private final static int BACKLIGHT_COLOR = 0xFF00308f;

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Canvas canvas;
    private int scale;
    private boolean inverted;
    private boolean backlight;

    public LowLevelRenderer(Canvas canvas) {
        this.canvas = canvas;
        scale = canvas.getWidth() / WatchConstants.SCREEN_WIDTH;
    }

    public void setMode(boolean inverted, boolean backlight) {
        this.inverted = inverted;
        this.backlight = backlight;
    }

    public void drawRect(int x, int y, int width, int height) {
        paint.setColor(getForegroundColor());
        canvas.drawRect(x * scale, y * scale, (x + width) * scale, (y + height) * scale, paint);
    }

    public void clearRect(int x, int y, int width, int height) {
        paint.setColor(getBackgroundColor());
        canvas.drawRect(x * scale, y * scale, (x + width) * scale, (y + height) * scale, paint);
    }

    public void drawDigit(int digit, int x, int y, int width, int height, int thickness) {
        if (digit != 1 && digit != 4) {
            drawRect(x, y, width, thickness);
        }

        if (digit != 5 && digit != 6) {
            drawRect(x + width - thickness, y, thickness, (height + 1) / 2);
        }

        if (digit != 2) {
            drawRect(x + width - thickness, y + height / 2, thickness, (height + 1) / 2);
        }

        if (digit != 1 && digit != 4 && digit != 7) {
            drawRect(x, y + height - thickness, width, thickness);
        }

        if (digit == 2 || digit == 6 || digit == 8 || digit == 0) {
            drawRect(x, y + height / 2, thickness, (height + 1) / 2);
        }

        if (digit != 1 && digit != 2 && digit != 3 && digit != 7) {
            drawRect(x, y, thickness, (height + 1) / 2);
        }

        if (digit != 1 && digit != 7 && digit != 0) {
            drawRect(x, y + ((height - thickness) / 2), width, thickness);
        }
    }

    public void clearScreen() {
        clearRect(0, 0, WatchConstants.SCREEN_WIDTH, WatchConstants.SCREEN_HEIGHT);
    }

    private int getBackgroundColor() {
        if (backlight) {
            return inverted ? Color.WHITE : BACKLIGHT_COLOR;
        } else {
            return inverted ? Color.WHITE : Color.BLACK;
        }
    }

    private int getForegroundColor() {

        if (backlight) {
            return inverted ? BACKLIGHT_COLOR : Color.WHITE;
        } else {
            return inverted ? Color.BLACK : Color.WHITE;
        }
    }

    public void drawText(String text, int startX, int startY, int width, int height, int fontType, int fontAlignment) {
        paint.setColor(getForegroundColor());

        FontInfo fontInfo = FontUtils.resolveFont(fontType);
        if (text != null) {

            int ptr = 0;
            int prevPtr = 0;
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
                lastLine = !multiline || (y + 2 * fontInfo.getHeight() + fontInfo.getCharSpace() > maxY);

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

                    x += drawChar(c, x, y, maxX - x, maxY - y, fontInfo);
                    x += fontInfo.getCharSpace();
                    prevPtr = ptr;
                }
                if (ptr == text.length()) {
                    lastLine = true;
                }

                x = startX;
                y += fontInfo.getHeight() + (c == 11 ? fontInfo.getHeight() / 2 : fontInfo.getCharSpace());
            } while (!lastLine);
        }
    }

    private int drawChar(char c, int x, int y, int width, int height, FontInfo fontInfo) {
        if (c == ' ') {
            return fontInfo.getSpaceSize();
        }

        CharInfo charInfo = FontUtils.resolveCharInfo(c, fontInfo);

        if (charInfo == null) {
            return fontInfo.getSpaceSize();
        }

        int charWidth = charInfo.getWidth() > width ? width : charInfo.getWidth();
        int charHeight = fontInfo.getHeight() > height ? height : fontInfo.getHeight();
        drawBitmap(fontInfo.getFontBitmaps(), charInfo.getOffset(), x, y, charWidth, charHeight, charInfo.getWidth());

        return charWidth;
    }

    private void drawBitmap(byte[] bitmap, int offset, int posX, int posY, int width, int height, int bitmapWidth) {
        int bitmapByteWidth = (bitmapWidth + 7) / 8;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                boolean val = ((bitmap[offset + (bitmapByteWidth * y) + (x / 8)] >> (7 - (x % 8))) & 0x1) != 0;
                if (val) {
                    int targetX = (posX + x) * scale;
                    int targetY = (posY + y) * scale;
                    paint.setColor(getForegroundColor());
                    canvas.drawRect(targetX, targetY, targetX + scale, targetY + scale, paint);
                }
//                paint.setColor(val ? getForegroundColor() : getBackgroundColor());
//                canvas.drawRect(targetX, targetY, targetX + scale, targetY + scale, paint);
            }
        }
    }
}
