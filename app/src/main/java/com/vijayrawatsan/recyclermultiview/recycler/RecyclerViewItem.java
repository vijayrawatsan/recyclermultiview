package com.vijayrawatsan.recyclermultiview.recycler;

/**
 * Created by vijay.rawat01 on 6/11/15.
 */
public abstract class RecyclerViewItem {
    protected int itemType;

    public RecyclerViewItem(int itemType) {
        this.itemType = itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getItemType() {
        return itemType;
    }
}
