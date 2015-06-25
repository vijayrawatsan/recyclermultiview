package com.vijayrawatsan.recyclermultiview.binders;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koushikdutta.ion.Ion;
import com.vijayrawatsan.recyclermultiview.R;
import com.vijayrawatsan.recyclermultiview.holders.ProductHolder;
import com.vijayrawatsan.recyclermultiview.hometypes.ClickableProduct;
import com.vijayrawatsan.recyclermultiview.recycler.BaseBinder;
import com.vijayrawatsan.recyclermultiview.recycler.GenericAdapter;

/**
 * Created by vijay.rawat01 on 6/14/15.
 */
public class ProductBinder extends BaseBinder {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType, GenericAdapter adapter) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                getViewTypeLayout(), parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, final GenericAdapter adapter) {
        ProductHolder productHolder = (ProductHolder) holder;
        final ClickableProduct clickableProduct = (ClickableProduct) adapter.getItem(position);
        Ion.with(productHolder.mImageView)
                .centerCrop()
                .load(clickableProduct.getImageData().getUrl());
        productHolder.mName.setText(clickableProduct.getName());
        productHolder.mPrice.setText(clickableProduct.getPrice());
        productHolder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(clickableProduct.getClickUrl()));
                adapter.getContext().startActivity(browserIntent);
            }
        });
    }

    public int getViewTypeLayout() {
        return R.layout.item_product;
    }
}
