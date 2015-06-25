package com.vijayrawatsan.recyclermultiview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.vijayrawatsan.recyclermultiview.recycler.BaseBinder;
import com.vijayrawatsan.recyclermultiview.recycler.GenericAdapter;
import com.vijayrawatsan.recyclermultiview.recycler.RecyclerViewItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vijay.rawat01 on 6/11/15.
 */
public class MyAdapter extends GenericAdapter {

    List<RecyclerViewItem> mData = new ArrayList<>();
    Context mContext;
    RecyclerView.RecycledViewPool mRecycledViewPool;

    public MyAdapter(Context context, RecyclerView.RecycledViewPool recycledViewPool) {
        this.mContext = context;
        this.mRecycledViewPool = recycledViewPool;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public RecyclerViewItem getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getItemType();
    }

    @Override
    public BaseBinder getBaseType(int viewType) {
        return ViewType.getBinder(viewType);
    }

    public void setData(List<RecyclerViewItem> data) {
        mData = data;
    }

    public Context getContext() {
        return mContext;
    }

    public RecyclerView.RecycledViewPool getRecycledViewPool() {
        return mRecycledViewPool;
    }
}
