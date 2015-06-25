package com.vijayrawatsan.recyclermultiview.hometypes;

import com.vijayrawatsan.recyclermultiview.recycler.RecyclerViewItem;

/**
 * Created by vijay.rawat01 on 6/12/15.
 */
public class ClickablePairImage extends RecyclerViewItem {

    private ImageData mImageData1;
    private String mClickUrl1;
    private ImageData mImageData2;
    private String mClickUrl2;

    public ClickablePairImage(int itemType, ImageData imageData1, String clickUrl1, ImageData imageData2, String clickUrl2) {
        super(itemType);
        mImageData1 = imageData1;
        mClickUrl1 = clickUrl1;
        mImageData2 = imageData2;
        mClickUrl2 = clickUrl2;
    }

    public ImageData getImageData1() {
        return mImageData1;
    }

    public String getClickUrl1() {
        return mClickUrl1;
    }

    public ImageData getImageData2() {
        return mImageData2;
    }

    public String getClickUrl2() {
        return mClickUrl2;
    }
}
