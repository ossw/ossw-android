package com.althink.android.ossw.emulator.control.digits;

import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;
import com.althink.android.ossw.emulator.source.EmulatorResourceSource;

import java.util.Arrays;

/**
 * Created by krzysiek on 11/09/15.
 */
public class NumbersFontRenderer implements DigitsRenderer {

    private EmulatorResourceSource resource;

    public NumbersFontRenderer(EmulatorResourceSource resource) {
        this.resource = resource;
    }

    @Override
    public int renderDigit(LowLevelRenderer renderer, int digit, int x, int y, boolean fullWidth, boolean drawZero) {
        int digitWidth = resource.getData()[2];
        int digitHeight = resource.getData()[3];
        if (digit != 0 || drawZero) {
            int idx = 4 + (((digitWidth + 7) / 8) * digitHeight * digit);
            renderer.drawBitmap(resource.getData(), idx, x, y, digitWidth, digitHeight, digitWidth);
        }
        return digitWidth;
    }

    @Override
    public int renderDecimalSeparator(LowLevelRenderer renderer, int x, int y) {
        return 0;
    }
}
