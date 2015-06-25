package com.vijayrawatsan.recyclermultiview.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.vijayrawatsan.recyclermultiview.R;

public class SingleImageHolder extends RecyclerView.ViewHolder {
    public ImageView mImageView;

    public SingleImageHolder(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.single_image);
    }
}