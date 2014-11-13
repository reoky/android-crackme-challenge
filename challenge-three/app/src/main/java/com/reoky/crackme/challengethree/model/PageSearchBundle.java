package com.reoky.crackme.challengethree.model;

import android.content.Context;

/**
 * A simple class to hold parameters for PageSearch
 */
public class PageSearchBundle {
    private Context context;
    private String url;
    private String keyword;

    public PageSearchBundle(Context context, String url, String keyword) {
        this.context = context;
        this.url = url;
        this.keyword = keyword;
    }

    public Context getContext() {
        return context;
    }

    public String getUrl() {
        return url;
    }

    public String getKeyword() {
        return keyword;
    }
};