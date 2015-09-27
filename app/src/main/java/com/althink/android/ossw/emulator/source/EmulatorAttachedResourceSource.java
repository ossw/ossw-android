package com.althink.android.ossw.emulator.source;

import com.althink.android.ossw.emulator.watchset.WatchSetEmulatorModel;
import com.althink.android.ossw.watchsets.CompiledWatchSet;

/**
 * Created by krzysiek on 08/09/15.
 */
public class EmulatorAttachedResourceSource implements EmulatorResourceSource {

    private WatchSetEmulatorModel watchSet;
    private int resourceId;

    public EmulatorAttachedResourceSource(WatchSetEmulatorModel watchSet, int resourceId) {
        this.watchSet = watchSet;
        this.resourceId = resourceId;
    }

    @Override
    public byte[] getData() {
        return watchSet.getResources().get(resourceId);
    }
}
