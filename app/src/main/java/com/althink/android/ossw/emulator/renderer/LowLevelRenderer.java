package com.althink.android.ossw.emulator.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

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

    public void drawText(String value, int x, int y, int width, int height) {
        paint.setColor(getForegroundColor());
        paint.setTextSize(36);
        if (value != null) {
            canvas.drawText(value, x * scale, y * scale+20, paint);
        }
    }
}
