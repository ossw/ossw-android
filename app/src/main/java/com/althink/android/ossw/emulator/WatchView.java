package com.althink.android.ossw.emulator;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import com.althink.android.ossw.emulator.actions.EmulatorAction;
import com.althink.android.ossw.emulator.control.EmulatorControl;
import com.althink.android.ossw.emulator.control.NumberEmulatorControl;
import com.althink.android.ossw.emulator.renderer.LowLevelRenderer;
import com.althink.android.ossw.emulator.source.internal.HourInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.source.internal.MinutesInternalEmulatorDataSource;
import com.althink.android.ossw.emulator.watchset.WatchSetEmulatorModel;
import com.althink.android.ossw.emulator.watchset.WatchSetScreenEmulatorModel;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by krzysiek on 13/06/15.
 */
public class WatchView extends View {

    private static final int SCR_CONTROL_STATIC_RECT = 0;
    private static final int SCR_CONTROL_NUMBER = 1;
    private static final int SCR_CONTROL_HORIZONTAL_PROGRESS_BAR = 2;

    private WatchEmulator watchEmulator;

    Handler viewHandler = new Handler();
    Runnable updateView = new Runnable() {
        @Override
        public void run() {
            WatchView.this.invalidate();
        }
    };

    public WatchView(Context context) {
        super(context);
    }

    public WatchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        watchEmulator = new WatchEmulator();

        List<EmulatorControl> controls = new LinkedList<>();
        controls.add(new NumberEmulatorControl(NumberEmulatorControl.NumberRange.NUMBER_RANGE_0__99, 5, 4, 8, new HourInternalEmulatorDataSource()));
        controls.add(new NumberEmulatorControl(NumberEmulatorControl.NumberRange.NUMBER_RANGE_0__99, 5, 85, 6, new MinutesInternalEmulatorDataSource()));
        List<WatchSetScreenEmulatorModel> screens = new LinkedList<>();
        screens.add(new WatchSetScreenEmulatorModel(controls, new LinkedList<EmulatorAction>()));
        WatchSetEmulatorModel watchset = new WatchSetEmulatorModel(screens);
        watchEmulator.showWatchSet(watchset);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        LowLevelRenderer renderer = new LowLevelRenderer(canvas);
        watchEmulator.render(renderer);

        viewHandler.postDelayed(updateView, 200);
    }

    public WatchEmulator getWatchEmulator() {
        return watchEmulator;
    }
}