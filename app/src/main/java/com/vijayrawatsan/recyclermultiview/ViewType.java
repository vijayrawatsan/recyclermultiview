package com.vijayrawatsan.recyclermultiview;

import com.vijayrawatsan.recyclermultiview.binders.ListBinder;
import com.vijayrawatsan.recyclermultiview.binders.PairImageBinder;
import com.vijayrawatsan.recyclermultiview.binders.ProductBinder;
import com.vijayrawatsan.recyclermultiview.binders.SingleImageBinder;
import com.vijayrawatsan.recyclermultiview.hometypes.ClickableList;
import com.vijayrawatsan.recyclermultiview.hometypes.ClickablePairImage;
import com.vijayrawatsan.recyclermultiview.hometypes.ClickableProduct;
import com.vijayrawatsan.recyclermultiview.hometypes.ClickableSingleImage;
import com.vijayrawatsan.recyclermultiview.hometypes.ImageData;
import com.vijayrawatsan.recyclermultiview.recycler.BaseBinder;
import com.vijayrawatsan.recyclermultiview.recycler.RecyclerViewItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vijay.rawat01 on 6/12/15.
 */
public enum ViewType {
    SINGLE_IMAGE(0, new SingleImageBinder()) {
        @Override
        public RecyclerViewItem getItem(JSONObject json) {
            ClickableSingleImage clickableSingleImage = new ClickableSingleImage(this.getItemType(),
                    getImageData(json.optJSONObject("imageData")), json.optString("clickUrl"));
            return clickableSingleImage;
        }
    }, PAIR_IMAGE(1, new PairImageBinder()) {
        @Override
        public RecyclerViewItem getItem(JSONObject json) {
            ClickablePairImage clickablePairImage = new ClickablePairImage(this.getItemType(),
                    getImageData(json.optJSONObject("imageData1")), json.optString("clickUrl1"),
                    getImageData(json.optJSONObject("imageData2")), json.optString("clickUrl2"));
            return clickablePairImage;
        }
    }, LIST_ITEMS(2, new ListBinder()) {
        @Override
        public RecyclerViewItem getItem(JSONObject json) {
            List<RecyclerViewItem> recyclerViewItems = new ArrayList<>();
            try {
                JSONArray items = json.getJSONArray("items");
                for (int i = 0; i < items.length(); i++) {
                    JSONObject item = items.getJSONObject(i);
                    int type = item.optInt("type");
                    recyclerViewItems.add(ViewType.getViewType(type).getItem(item));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ClickableList clickableList = new ClickableList(this.getItemType(), recyclerViewItems);
            return clickableList;
        }
    }, PRODUCT(3, new ProductBinder()) {
        @Override
        public RecyclerViewItem getItem(JSONObject json) {
            ClickableProduct clickableProduct = new ClickableProduct(this.getItemType(), getImageData(json.optJSONObject("imageData")), json.optString("clickUrl"), json.optString("name"), json.optString("price"));
            return clickableProduct;
        }
    };

    private static class Holder {
        static Map<Integer, ViewType> MAP = new HashMap<>();
    }

    private final int itemType;
    private final BaseBinder binder;

    ViewType(int itemType, BaseBinder binder) {
        this.itemType = itemType;
        this.binder = binder;
        Holder.MAP.put(itemType, this);
    }

    public int getItemType() {
        return Integer.valueOf(itemType);
    }

    public BaseBinder getBinder() {
        return binder;
    }

    public abstract RecyclerViewItem getItem(JSONObject json);

    public static BaseBinder getBinder(int itemType) {
        return Holder.MAP.get(itemType).getBinder();
    }

    public static ViewType getViewType(int itemType) {
        return Holder.MAP.get(itemType);
    }

    public static ImageData getImageData(JSONObject json) {
        return new ImageData(json.optString("imageUrl"), json.optString("width"), json.optString("height"));
    }
}
