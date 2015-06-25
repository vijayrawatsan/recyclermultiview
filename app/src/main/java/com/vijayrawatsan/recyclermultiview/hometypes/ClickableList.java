package com.vijayrawatsan.recyclermultiview.hometypes;

import com.vijayrawatsan.recyclermultiview.recycler.RecyclerViewItem;

import java.util.List;

/**
 * Created by vijay.rawat01 on 6/13/15.
 */
public class ClickableList extends RecyclerViewItem {

    List<RecyclerViewItem> mRecyclerViewItems;

    public ClickableList(int itemType, List<RecyclerViewItem> recyclerViewItems) {
        super(itemType);
        this.mRecyclerViewItems = recyclerViewItems;
    }

    public List<RecyclerViewItem> getRecyclerViewItems() {
        return mRecyclerViewItems;
    }
}
