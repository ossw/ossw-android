package com.althink.android.ossw.emulator.control;

import com.althink.android.ossw.emulator.control.digits.DigitsRenderer;
import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;
import com.althink.android.ossw.emulator.source.EmulatorDataSource;
import com.althink.android.ossw.watch.WatchConstants;
import com.althink.android.ossw.watchsets.DataSourceType;

/**
 * Created by krzysiek on 14/06/15.
 */
public class NumberEmulatorControl extends AbstractEmulatorControl {
    private NumberRange range;
    private int x;
    private int y;
    private int digitSpace;
    private boolean zeroPadded;
    private DigitsRenderer digitsRenderer;

    public NumberEmulatorControl(NumberRange range, int x, int y, int digitSpace, boolean zeroPadded, DigitsRenderer digitsRenderer, EmulatorDataSource dataSource) {
        super(dataSource);
        this.range = range;
        this.x = x;
        this.y = y;
        this.digitSpace = digitSpace;
        this.zeroPadded = zeroPadded;
        this.digitsRenderer = digitsRenderer;
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

    private void drawIntDigits(LowLevelRenderer renderer, int value, int digitsNo, int decimalSize, int x, int y, boolean leftPadded) {
        int currentX = x;
        int div = pow(10, digitsNo - 1);

        for (int i = 0; i < digitsNo; i++) {
            if (decimalSize > 0 && digitsNo - i == decimalSize) {
                currentX += digitsRenderer.renderDecimalSeparator(renderer, currentX, y) + digitSpace;
            }
            int scaledVal = value / div;
            int digit = scaledVal % 10;
            boolean drawZeroValue = leftPadded || (digitsNo - i - 1 <= decimalSize);
            currentX += digitsRenderer.renderDigit(renderer, digit, currentX, y, true, scaledVal > 0 || drawZeroValue || div == 1) + digitSpace;
            div = div / 10;
        }
    }

    private void drawOneStartingIntDigits(LowLevelRenderer renderer, int value, int digitsNo, int decimalSize, int x, int y) {
        int div = pow(10, digitsNo - 1);
        if (value >= div) {
            x += digitsRenderer.renderDigit(renderer, 1, x, y, false, false) + digitSpace;
        }
        drawIntDigits(renderer, value, digitsNo - 1, decimalSize, x, y, false);
    }

    static int pow(int x, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    public void draw(LowLevelRenderer renderer, EmulatorExecutionContext ctx) {
        int decimalSize = range.getValue() & 0xF;
        Object value = getData(DataSourceType.NUMBER, range.getValue(), ctx);
        if (value == null) {
            return;
        }
        int intValue = (int) value;

        int digit_no = (range.getValue() >> 4) / 2 + 1 + decimalSize;
        boolean is_1X_format = (range.getValue() >> 4) % 2 == 0;

        if (is_1X_format) {
            drawOneStartingIntDigits(renderer, trimToRange(intValue, 0, 2 * pow(10, digit_no - 1) - 1), digit_no, decimalSize, x, y);
        } else {
            drawIntDigits(renderer, trimToRange(intValue, 0, pow(10, digit_no) - 1), digit_no, decimalSize, x, y, zeroPadded);
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
        NUMBER_RANGE_0__99999(0x90),
        NUMBER_RANGE_0__9_9(0x11),
        NUMBER_RANGE_0__19_9(0x21),
        NUMBER_RANGE_0__99_9(0x31),
        NUMBER_RANGE_0__199_9(0x41),
        NUMBER_RANGE_0__999_9(0x51),
        NUMBER_RANGE_0__1999_9(0x61),
        NUMBER_RANGE_0__9999_9(0x71),
        NUMBER_RANGE_0__19999_9(0x81),
        NUMBER_RANGE_0__99999_9(0x91),
        NUMBER_RANGE_0__9_99(0x12),
        NUMBER_RANGE_0__19_99(0x22),
        NUMBER_RANGE_0__99_99(0x32),
        NUMBER_RANGE_0__199_99(0x42),
        NUMBER_RANGE_0__999_99(0x52),
        NUMBER_RANGE_0__1999_99(0x62),
        NUMBER_RANGE_0__9999_99(0x72),
        NUMBER_RANGE_0__19999_99(0x82),
        NUMBER_RANGE_0__99999_99(0x92);

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

        public int getValue() {
            return key;
        }
    }
}
