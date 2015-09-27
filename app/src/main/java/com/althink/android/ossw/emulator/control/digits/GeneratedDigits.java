package com.althink.android.ossw.emulator.control.digits;

import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;

/**
 * Created by krzysiek on 11/09/15.
 */
public class GeneratedDigits implements DigitsRenderer {

    private int digitWidth;
    private int digitHeight;
    private int thickness;

    public GeneratedDigits(int digitWidth, int digitHeight, int thickness) {
        this.digitWidth = digitWidth;
        this.digitHeight = digitHeight;
        this.thickness = thickness;
    }

    @Override
    public int renderDigit(LowLevelRenderer renderer, int digit, int x, int y, boolean fullWidth, boolean drawZero) {
        if (!fullWidth && digit == 1) {
            renderer.drawRect(x, y, thickness, digitHeight);
            return thickness;
        } else {
            if (drawZero || digit != 0) {
                renderer.drawDigit(digit, x, y, digitWidth, digitHeight, thickness);
            }
            return digitWidth;
        }
    }

    @Override
    public int renderDecimalSeparator(LowLevelRenderer renderer, int x, int y) {
        renderer.drawRect(x, y + digitHeight - thickness, thickness, thickness);
        return thickness;
    }
}
