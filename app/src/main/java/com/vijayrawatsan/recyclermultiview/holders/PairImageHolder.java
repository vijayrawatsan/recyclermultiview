package com.vijayrawatsan.recyclermultiview.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.vijayrawatsan.recyclermultiview.R;

public class PairImageHolder extends RecyclerView.ViewHolder {
    public ImageView mImageView1;
    public ImageView mImageView2;

    public PairImageHolder(View itemView) {
        super(itemView);
        mImageView1 = (ImageView) itemView.findViewById(R.id.image1);
        mImageView2 = (ImageView) itemView.findViewById(R.id.image2);
    }
}