package com.althink.android.ossw.utils;

import net.sf.junidecode.Junidecode;

/**
 * Created by krzysiek on 19/07/15.
 */
public class StringNormalizer {

    public static String removeAccents(String text) {
        if (text == null) {
            return null;
        }
        String result = Junidecode.unidecode(text);
        return result;
    }
}
