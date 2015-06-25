package com.vijayrawatsan.recyclermultiview.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by vijay.rawat01 on 6/11/15.
 */
public abstract class GenericAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseBinder baseType = getBaseType(viewType);
        return baseType.onCreateViewHolder(parent, viewType, this);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = holder.getItemViewType();
        BaseBinder baseType = getBaseType(itemViewType);
        baseType.onBindViewHolder(holder, position, this);
    }

    abstract public Context getContext();

    abstract public int getItemCount();

    abstract public int getItemViewType(int position);

    abstract public RecyclerViewItem getItem(int position);

    abstract public BaseBinder getBaseType(int viewType);

    public RecyclerView.RecycledViewPool getRecycledViewPool() {
        return null;
    }
}
