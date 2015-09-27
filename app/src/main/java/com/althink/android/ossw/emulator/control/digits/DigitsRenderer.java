package com.althink.android.ossw.emulator.control.digits;

import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;

/**
 * Created by krzysiek on 11/09/15.
 */
public interface DigitsRenderer {

    int renderDigit(LowLevelRenderer renderer, int digit, int x, int y, boolean fullWidth, boolean drawZero);

    int renderDecimalSeparator(LowLevelRenderer renderer, int x, int y);

}
