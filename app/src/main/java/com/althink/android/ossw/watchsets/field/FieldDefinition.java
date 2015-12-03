package com.althink.android.ossw.watchsets.field;

import com.althink.android.ossw.watchsets.ValueResolver;

/**
 * Created by krzysiek on 21/11/15.
 */
public abstract class FieldDefinition implements ValueResolver {

    protected int fieldId;

    public FieldDefinition(int fieldId) {
        this.fieldId = fieldId;
    }

    public int getFieldId() {
        return fieldId;
    }
}
