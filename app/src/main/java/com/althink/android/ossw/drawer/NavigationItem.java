package com.althink.android.ossw.drawer;


import android.graphics.drawable.Drawable;

/**
 * Created by poliveira on 24/10/2014.
 */
public class NavigationItem {
    private int mItemId;
    private String mText;
    private Drawable mDrawable;

    public NavigationItem(int itemId, String text, Drawable drawable) {
        mItemId = itemId;
        mText = text;
        mDrawable = drawable;
    }

    public int getItemId() {
        return mItemId;
    }

    public void setItemId(int itemId) {
        this.mItemId = itemId;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Drawable getDrawable() {
        return mDrawable;
    }

    public void setDrawable(Drawable drawable) {
        mDrawable = drawable;
    }
}
