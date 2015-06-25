package com.vijayrawatsan.recyclermultiview.binders;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koushikdutta.ion.Ion;
import com.vijayrawatsan.recyclermultiview.R;
import com.vijayrawatsan.recyclermultiview.Utils;
import com.vijayrawatsan.recyclermultiview.holders.SingleImageHolder;
import com.vijayrawatsan.recyclermultiview.hometypes.ClickableSingleImage;
import com.vijayrawatsan.recyclermultiview.recycler.BaseBinder;
import com.vijayrawatsan.recyclermultiview.recycler.GenericAdapter;

/**
 * Created by vijay.rawat01 on 6/11/15.
 */

public class SingleImageBinder extends BaseBinder {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType, GenericAdapter adapter) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                getViewTypeLayout(), parent, false);
        return new SingleImageHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, final GenericAdapter adapter) {
        SingleImageHolder singleImageHolder = (SingleImageHolder) holder;
        final ClickableSingleImage image = (ClickableSingleImage) adapter.getItem(position);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) singleImageHolder.mImageView.getLayoutParams();
        int margin = layoutParams.leftMargin + layoutParams.rightMargin;
        int width = Utils.getDeviceWidth(adapter.getContext()) - (margin + (int) Utils.convertDpToPixel((4 + 4), adapter.getContext()));
        int height = (int) Math.round(Integer.parseInt(image.getImageData().getHeight()) / (double) Integer.parseInt(image.getImageData().getWidth()) * (double) width);
        Ion.with(singleImageHolder.mImageView)
                .resize(width, height)
                .centerCrop()
                .load(image.getImageData().getUrl());
        singleImageHolder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(image.getClickUrl()));
                adapter.getContext().startActivity(browserIntent);
            }
        });
    }

    public int getViewTypeLayout() {
        return R.layout.item_single_image;
    }

}
