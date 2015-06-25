package com.vijayrawatsan.recyclermultiview.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by vijay.rawat01 on 6/11/15.
 */
public abstract class BaseBinder {

    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType, GenericAdapter adapter);

    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position, GenericAdapter adapter);

}
