package com.althink.android.ossw.watchsets;

import java.util.Map;

/**
 * Created by krzysiek on 21/11/15.
 */
public class EnumToIntResolver implements ValueResolver {

    private Map<String, Integer> valuesMap;

    public EnumToIntResolver(Map<String, Integer> valuesMap) {
        this.valuesMap = valuesMap;
    }

    @Override
    public Object resolve(Object value) {
        return valuesMap.get(value);
    }
}
