package com.vijayrawatsan.recyclermultiview;

import com.vijayrawatsan.recyclermultiview.recycler.RecyclerViewItem;

import org.json.JSONObject;

/**
 * Created by vijay.rawat01 on 6/11/15.
 */
public class DummyData extends RecyclerViewItem {

    private JSONObject mJSONObject;

    public DummyData(JSONObject jsonObject) {
        super(jsonObject.optInt("type"));
        mJSONObject = jsonObject;
    }

    public JSONObject getJSONObject() {
        return mJSONObject;
    }
}
