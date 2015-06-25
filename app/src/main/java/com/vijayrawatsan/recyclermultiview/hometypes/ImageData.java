package com.vijayrawatsan.recyclermultiview.hometypes;

/**
 * Created by vijay.rawat01 on 6/15/15.
 */
public class ImageData {
    private String mUrl;
    private String mWidth;
    private String mHeight;

    public ImageData(String url) {
        mUrl = url;
    }

    public ImageData(String url, String width, String height) {
        mUrl = url;
        mWidth = width;
        mHeight = height;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getWidth() {
        return mWidth;
    }

    public String getHeight() {
        return mHeight;
    }
}
