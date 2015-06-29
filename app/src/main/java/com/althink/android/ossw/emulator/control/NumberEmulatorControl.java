package com.althink.android.ossw.emulator.control;

import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.watch.WatchConstants;

/**
 * Created by krzysiek on 14/06/15.
 */
public class NumberEmulatorControl extends AbstractEmulatorControl {
    private NumberRange range;
    private int x;
    private int y;
    private int style;

    public NumberEmulatorControl(NumberRange range, int x, int y, int style, EmulatorDataSource dataSource) {
        super(dataSource);
        this.range = range;
        this.x = x;
        this.y = y;
        this.style = style;
    }

    public int trimToRange(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    private void drawIntDigits(LowLevelRenderer renderer, int value, int digitsNo, int x, int y, int digitWidth, int digitHeight, int digitSpace, int digitThickness, boolean leftPadded) {
        int currentX = x;
        int div = 1;
        for (int i = 1; i < digitsNo; i++) {
            div *= 10;
        }
        for (int i = 0; i < digitsNo; i++) {
            int scaledVal = value / div;
            int digit = scaledVal % 10;
            if (scaledVal > 0 || leftPadded || div == 1) {
                renderer.drawDigit(digit, currentX, y, digitWidth, digitHeight, digitThickness);
            }
            div = div / 10;
            currentX += digitWidth + digitSpace;
        }
    }

    private void drawOneStartingIntDigits(LowLevelRenderer renderer, int value, int digitsNo, int x, int y, int digitWidth, int digitHeight, int digitSpace, int digitThickness) {
        int div = 1;
        for (int i = 1; i < digitsNo; i++) {
            div *= 10;
        }
        if (value >= div) {
            renderer.drawRect(x, y, digitThickness, digitHeight);
        }
        drawIntDigits(renderer, value, digitsNo - 1, x + digitThickness + digitSpace, y, digitWidth, digitHeight, digitSpace, digitThickness, false);
    }

    public void draw(LowLevelRenderer renderer) {
        Integer value = (Integer) getData();
        if (value == null) {
            return;
        }
        int digitWidth = style >> 8 & 0xFF;
        int digitHeight = style & 0xFF;
        int thickness = (style >> 16) & 0x3F;
        int digitSpace = (style >> 22) & 0x1F;
        boolean leftPadded = (style & 0x80000000) != 0;

        switch (range) {
            case NUMBER_RANGE_0__9:
                drawIntDigits(renderer, trimToRange(value, 0, 9), 1, x, y, digitWidth, digitHeight, digitSpace, thickness, leftPadded);
                break;
            case NUMBER_RANGE_0__19:
                drawOneStartingIntDigits(renderer, trimToRange(value, 0, 19), 2, x, y, digitWidth, digitHeight, digitSpace, thickness);
                break;
            case NUMBER_RANGE_0__99:
                drawIntDigits(renderer, trimToRange(value, 0, 99), 2, x, y, digitWidth, digitHeight, digitSpace, thickness, leftPadded);
                break;
            case NUMBER_RANGE_0__199:
                drawOneStartingIntDigits(renderer, trimToRange(value, 0, 199), 3, x, y, digitWidth, digitHeight, digitSpace, thickness);
                break;
            case NUMBER_RANGE_0__999:
                drawIntDigits(renderer, trimToRange(value, 0, 999), 3, x, y, digitWidth, digitHeight, digitSpace, thickness, leftPadded);
                break;
            case NUMBER_RANGE_0__1999:
                drawOneStartingIntDigits(renderer, trimToRange(value, 0, 1999), 4, x, y, digitWidth, digitHeight, digitSpace, thickness);
                break;
            case NUMBER_RANGE_0__9999:
                drawIntDigits(renderer, trimToRange(value, 0, 9999), 4, x, y, digitWidth, digitHeight, digitSpace, thickness, leftPadded);
                break;
            case NUMBER_RANGE_0__19999:
                drawOneStartingIntDigits(renderer, trimToRange(value, 0, 19999), 5, x, y, digitWidth, digitHeight, digitSpace, thickness);
                break;
            case NUMBER_RANGE_0__99999:
                drawIntDigits(renderer, trimToRange(value, 0, 99999), 5, x, y, digitWidth, digitHeight, digitSpace, thickness, leftPadded);
                break;
        }
    }

    public static enum NumberRange {
        NUMBER_RANGE_0__9(0x10),
        NUMBER_RANGE_0__19(0x20),
        NUMBER_RANGE_0__99(0x30),
        NUMBER_RANGE_0__199(0x40),
        NUMBER_RANGE_0__999(0x50),
        NUMBER_RANGE_0__1999(0x60),
        NUMBER_RANGE_0__9999(0x70),
        NUMBER_RANGE_0__19999(0x80),
        NUMBER_RANGE_0__99999(0x90);

        private int key;

        private NumberRange(int key) {
            this.key = key;
        }

        public static NumberRange resolveByKey(int key) {
            for (NumberRange format : NumberRange.values()) {
                if (format.key == key) {
                    return format;
                }
            }
            return null;
        }
    }
}
