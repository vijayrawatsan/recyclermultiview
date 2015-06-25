package com.vijayrawatsan.recyclermultiview.binders;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.koushikdutta.ion.Ion;
import com.vijayrawatsan.recyclermultiview.R;
import com.vijayrawatsan.recyclermultiview.Utils;
import com.vijayrawatsan.recyclermultiview.holders.PairImageHolder;
import com.vijayrawatsan.recyclermultiview.hometypes.ClickablePairImage;
import com.vijayrawatsan.recyclermultiview.recycler.BaseBinder;
import com.vijayrawatsan.recyclermultiview.recycler.GenericAdapter;

/**
 * Created by vijay.rawat01 on 6/11/15.
 */

public class PairImageBinder extends BaseBinder {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType, GenericAdapter adapter) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                getViewTypeLayout(), parent, false);
        return new PairImageHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, final GenericAdapter adapter) {
        PairImageHolder singleImageHolder = (PairImageHolder) holder;
        final ClickablePairImage image = (ClickablePairImage) adapter.getItem(position);
        int leftMargin1 = ((LinearLayout.LayoutParams) singleImageHolder.mImageView1.getLayoutParams()).leftMargin;
        int rightMargin1 = ((LinearLayout.LayoutParams) singleImageHolder.mImageView1.getLayoutParams()).rightMargin;
        int leftMargin2 = ((LinearLayout.LayoutParams) singleImageHolder.mImageView2.getLayoutParams()).leftMargin;
        int rightMargin2 = ((LinearLayout.LayoutParams) singleImageHolder.mImageView2.getLayoutParams()).rightMargin;

        int finalWidth = (int) Math.round((Utils.getDeviceWidth(adapter.getContext()) - (leftMargin1 + rightMargin1 + leftMargin2 + rightMargin2 + (int) Utils.convertDpToPixel((4 + 4), adapter.getContext()))) / (double) 2);
        int height1 = (int) Math.round(Integer.parseInt(image.getImageData1().getHeight()) / (double) Integer.parseInt(image.getImageData1().getWidth()) * (double) finalWidth);
        int height2 = (int) Math.round(Integer.parseInt(image.getImageData2().getHeight()) / (double) Integer.parseInt(image.getImageData2().getWidth()) * (double) finalWidth);
        Log.d("PAIR_BINDER", finalWidth + ": " + height2);
        Ion.with(singleImageHolder.mImageView1)
                .placeholder(new ColorDrawable(adapter.getContext().getResources().getColor(R.color.background_material_light)))
                .resize(finalWidth, height1)
                .centerCrop()
                .load(image.getImageData1().getUrl());

        singleImageHolder.mImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(image.getClickUrl1()));
                adapter.getContext().startActivity(browserIntent);
            }
        });

        Ion.with(singleImageHolder.mImageView2)
                .placeholder(new ColorDrawable(adapter.getContext().getResources().getColor(R.color.background_material_light)))
                .resize(finalWidth, height2)
                .centerCrop()
                .load(image.getImageData2().getUrl());
        singleImageHolder.mImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(image.getClickUrl2()));
                adapter.getContext().startActivity(browserIntent);
            }
        });
    }

    public int getViewTypeLayout() {
        return R.layout.item_pair_image;
    }

}
