package com.vijayrawatsan.recyclermultiview.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vijayrawatsan.recyclermultiview.R;

/**
 * Created by vijay.rawat01 on 6/14/15.
 */
public class ProductHolder extends RecyclerView.ViewHolder {
    public ImageView mImageView;
    public TextView mName;
    public TextView mPrice;

    public ProductHolder(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.product_image);
        mName = (TextView) itemView.findViewById(R.id.product_name);
        mPrice = (TextView) itemView.findViewById(R.id.product_price);
    }
}
