package com.vijayrawatsan.recyclermultiview.hometypes;

import com.vijayrawatsan.recyclermultiview.recycler.RecyclerViewItem;

/**
 * Created by vijay.rawat01 on 6/12/15.
 */
public class ClickableSingleImage extends RecyclerViewItem {
    private ImageData mImageData;
    private String mClickUrl;

    public ClickableSingleImage(int itemType, ImageData imageData, String clickUrl) {
        super(itemType);
        mImageData = imageData;
        mClickUrl = clickUrl;
    }

    public ImageData getImageData() {
        return mImageData;
    }

    public String getClickUrl() {
        return mClickUrl;
    }
}
