package com.vijayrawatsan.recyclermultiview.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.vijayrawatsan.recyclermultiview.R;

/**
 * Created by vijay.rawat01 on 6/13/15.
 */
public class ListViewHolder extends RecyclerView.ViewHolder {
    public RecyclerView mRecyclerView;

    public ListViewHolder(View itemView) {
        super(itemView);
        mRecyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view_item);
    }
}
