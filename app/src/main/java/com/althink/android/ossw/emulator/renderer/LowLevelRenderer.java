package com.althink.android.ossw.emulator.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.althink.android.ossw.emulator.fonts.CharInfo;
import com.althink.android.ossw.emulator.fonts.FontInfo;
import com.althink.android.ossw.emulator.fonts.FontUtils;
import com.althink.android.ossw.watch.WatchConstants;

/**
 * Created by krzysiek on 14/06/15.
 */
public class LowLevelRenderer {

    private final static int BACKLIGHT_COLOR = 0xFF00308f;

    private Paint paint = new Paint();
    private Canvas canvas;
    private boolean inverted;
    private boolean backlight;
    private Bitmap bitmap;
    private int[] frameBuffer;

    public LowLevelRenderer(Canvas canvas, int[] frameBuffer, Bitmap bitmap) {
        this.canvas = canvas;
        this.bitmap = bitmap;
        this.frameBuffer = frameBuffer;
    }

    public void setMode(boolean inverted, boolean backlight) {
        this.inverted = inverted;
        this.backlight = backlight;
    }

    public void drawRect(int startX, int startY, int width, int height) {
        if (startX + width >= WatchConstants.SCREEN_WIDTH) {
            width = WatchConstants.SCREEN_WIDTH - startX;
        }
        if (startY + height >= WatchConstants.SCREEN_HEIGHT) {
            height = WatchConstants.SCREEN_HEIGHT - startY;
        }
        int foregroundColor = getForegroundColor();
        for (int y = 0; y < height; y++) {
            int p = (startY + y) * WatchConstants.SCREEN_WIDTH + startX;
            for (int x = 0; x < width; x++) {
                frameBuffer[p] = foregroundColor;
                p++;
            }
        }
    }

    public void drawEmptyRect(int x, int y, int width, int height, int thickness) {
        if (thickness <= 0) {
            return;
        }
        drawRect(x, y, width, thickness);
        drawRect(x, y + height - thickness, width, thickness);
        drawRect(x, y, thickness, height);
        drawRect(x + width - thickness, y, thickness, height);
    }

    public void clearRect(int startX, int startY, int width, int height) {
        if (startX + width >= WatchConstants.SCREEN_WIDTH) {
            width = WatchConstants.SCREEN_WIDTH - startX;
        }
        if (startY + height >= WatchConstants.SCREEN_HEIGHT) {
            height = WatchConstants.SCREEN_HEIGHT - startY;
        }
        int backgroundColor = getBackgroundColor();
        for (int y = 0; y < height; y++) {
            int p = (startY + y) * WatchConstants.SCREEN_WIDTH + startX;
            for (int x = 0; x < width; x++) {
                frameBuffer[p] = backgroundColor;
                p++;
            }
        }
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
            int maxY = y + height;
            boolean multiline = (fontAlignment & WatchConstants.TEXT_FLAGS_MULTILINE) != 0;
            boolean splitWord = (fontAlignment & WatchConstants.TEXT_FLAGS_SPLIT_WORD) != 0;

            if ((fontAlignment & WatchConstants.VERTICAL_ALIGN_CENTER) != 0) {
                int calc_height = FontUtils.calcTextHeight(text, startX, startY, width, height, fontType, fontAlignment);
                if (calc_height < height) {
                    y += (height - calc_height) / 2;
                }
            } else if ((fontAlignment & WatchConstants.VERTICAL_ALIGN_BOTTOM) != 0) {
                int calc_height = FontUtils.calcTextHeight(text, startX, startY, width, height, fontType, fontAlignment);
                if (calc_height < height) {
                    y += height - calc_height;
                }
            }

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

    public void drawBitmap(byte[] bitmap, int offset, int posX, int posY, int width, int height, int bitmapWidth) {
        if (posX + width >= WatchConstants.SCREEN_WIDTH) {
            width = WatchConstants.SCREEN_WIDTH - posX;
        }
        if (posY + height >= WatchConstants.SCREEN_HEIGHT) {
            height = WatchConstants.SCREEN_HEIGHT - posY;
        }
        int foregroundColor = getForegroundColor();
        int backgroundColor = getBackgroundColor();
        int bitmapByteWidth = (bitmapWidth + 7) / 8;
        for (int y = 0; y < height; y++) {
            int p = ((posY + y) * WatchConstants.SCREEN_WIDTH) + posX;
            for (int x = 0; x < width; x++) {
                boolean val = ((bitmap[offset + (bitmapByteWidth * y) + (x / 8)] >> (7 - (x % 8))) & 0x1) != 0;
                frameBuffer[p] = val ? foregroundColor : backgroundColor;
                p++;
            }
        }
    }

    public void drawImage(byte[] image, int x, int y, int width, int height) {
        drawBitmap(image, 4, x, y, width, height, (int) image[2] & 0xFF);
    }

    public void flush() {
        //long startTime = System.currentTimeMillis();
        bitmap.setPixels(frameBuffer, 0, WatchConstants.SCREEN_WIDTH, 0, 0, WatchConstants.SCREEN_WIDTH, WatchConstants.SCREEN_HEIGHT);
        canvas.drawBitmap(bitmap, new Rect(0, 0, WatchConstants.SCREEN_WIDTH, WatchConstants.SCREEN_HEIGHT), new Rect(0, 0, canvas.getClipBounds().right, canvas.getClipBounds().bottom), paint);
        //long endTime = System.currentTimeMillis();
        //Log.i("RENDER", "Flush time: " + (endTime - startTime));
    }
}
