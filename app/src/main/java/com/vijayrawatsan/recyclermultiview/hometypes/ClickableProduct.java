package com.vijayrawatsan.recyclermultiview.hometypes;

import com.vijayrawatsan.recyclermultiview.recycler.RecyclerViewItem;

/**
 * Created by vijay.rawat01 on 6/14/15.
 */
public class ClickableProduct extends RecyclerViewItem {
    private ImageData mImageData;
    private String mClickUrl;
    private String mName;
    private String mPrice;

    public ClickableProduct(int itemType, ImageData imageData, String clickUrl, String name, String price) {
        super(itemType);
        mImageData = imageData;
        mClickUrl = clickUrl;
        mName = name;
        mPrice = price;
    }

    public ImageData getImageData() {
        return mImageData;
    }

    public String getClickUrl() {
        return mClickUrl;
    }

    public String getName() {
        return mName;
    }

    public String getPrice() {
        return mPrice;
    }
}
