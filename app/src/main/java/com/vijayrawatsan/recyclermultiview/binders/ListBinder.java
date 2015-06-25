package com.vijayrawatsan.recyclermultiview.binders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vijayrawatsan.recyclermultiview.MyAdapter;
import com.vijayrawatsan.recyclermultiview.R;
import com.vijayrawatsan.recyclermultiview.holders.ListViewHolder;
import com.vijayrawatsan.recyclermultiview.hometypes.ClickableList;
import com.vijayrawatsan.recyclermultiview.recycler.BaseBinder;
import com.vijayrawatsan.recyclermultiview.recycler.GenericAdapter;

/**
 * Created by vijay.rawat01 on 6/13/15.
 */
public class ListBinder extends BaseBinder {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType, GenericAdapter adapter) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                getViewTypeLayout(), parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, GenericAdapter adapter) {
        ListViewHolder listViewHolder = (ListViewHolder) holder;
        final ClickableList clickableList = (ClickableList) adapter.getItem(position);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(adapter.getContext(), LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setRecycleChildrenOnDetach(true);
        listViewHolder.mRecyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.RecycledViewPool recycledViewPool = adapter.getRecycledViewPool();
        if (recycledViewPool != null) {
            listViewHolder.mRecyclerView.setRecycledViewPool(recycledViewPool);
        }
        MyAdapter myAdapter = new MyAdapter(adapter.getContext(), recycledViewPool);
        myAdapter.setData(clickableList.getRecyclerViewItems());
        listViewHolder.mRecyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    public int getViewTypeLayout() {
        return R.layout.item_recycler_view;
    }
}
