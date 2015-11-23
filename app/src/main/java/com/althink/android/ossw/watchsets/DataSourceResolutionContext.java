package com.althink.android.ossw.watchsets;

/**
 * Created by krzysiek on 17/11/15.
 */
public class DataSourceResolutionContext {
    public DataSourceType dataSourceType;
    public int dataRange;
    public ValueResolver resolver;
    public ScreenContext screenContext;

    public DataSourceResolutionContext(ScreenContext screenContext) {
        this.screenContext = screenContext;
    }
}
