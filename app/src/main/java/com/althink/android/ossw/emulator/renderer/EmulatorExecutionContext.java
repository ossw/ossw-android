package com.althink.android.ossw.emulator.renderer;

import com.althink.android.ossw.emulator.WatchEmulator;
import com.althink.android.ossw.emulator.watchset.WatchSetEmulatorModel;

/**
 * Created by krzysiek on 22/11/15.
 */
public class EmulatorExecutionContext extends WatchEmulator {

    private WatchSetEmulatorModel watchset;
    private WatchEmulator emulator;

    public EmulatorExecutionContext(WatchSetEmulatorModel watchset, WatchEmulator emulator) {
        super();
        this.watchset = watchset;
        this.emulator = emulator;
    }

    public WatchEmulator getEmulator() {
        return emulator;
    }

    public WatchSetEmulatorModel getWatchset() {
        return watchset;
    }
}
