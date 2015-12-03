package com.althink.android.ossw.watchsets;

import com.althink.android.ossw.watchsets.field.FieldDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by krzysiek on 21/11/15.
 */
public class ScreenContext {
    private Map<String, FieldDefinition> model = new HashMap<>();
    private MemoryAllocator allocator = new MemoryAllocator();

    public Map<String, FieldDefinition> getModel() {
        return model;
    }

    public MemoryAllocator getAllocator() {
        return allocator;
    }

    public static class MemoryAllocator {

        int size = 0;

        public int addBuffer(int size) {
            int ptr = this.size;
            this.size += size;
            return ptr;
        }

        public int getSize() {
            return size;
        }
    }
}

