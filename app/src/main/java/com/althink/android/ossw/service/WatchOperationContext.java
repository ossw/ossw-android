package com.althink.android.ossw.service;

import java.util.List;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchOperationContext {

    private List<WatchExtensionProperty> externalParameters;
    private List<WatchExtensionFunction> externalFunctions;

    public WatchOperationContext(List<WatchExtensionProperty> externalParameters, List<WatchExtensionFunction> externalFunctions) {
        this.externalParameters = externalParameters;
        this.externalFunctions = externalFunctions;
    }

    public List<WatchExtensionProperty> getExternalParameters() {
        return externalParameters;
    }

    public List<WatchExtensionFunction> getExternalFunctions() {
        return externalFunctions;
    }

}
