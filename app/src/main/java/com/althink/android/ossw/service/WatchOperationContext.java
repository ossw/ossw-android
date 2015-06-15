package com.althink.android.ossw.service;

import java.util.List;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchOperationContext {

    private List<WatchExtensionParameter> externalParameters;
    private List<WatchExtensionParameter> externalFunctions;

    public WatchOperationContext(List<WatchExtensionParameter> externalParameters, List<WatchExtensionParameter> externalFunctions) {
        this.externalParameters = externalParameters;
        this.externalFunctions = externalFunctions;
    }

    public List<WatchExtensionParameter> getExternalParameters() {
        return externalParameters;
    }

    public List<WatchExtensionParameter> getExternalFunctions() {
        return externalFunctions;
    }

}
