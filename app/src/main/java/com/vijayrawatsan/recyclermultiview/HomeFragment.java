package com.vijayrawatsan.recyclermultiview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.vijayrawatsan.recyclermultiview.recycler.RecyclerViewItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vijay.rawat01 on 6/12/15.
 */
public class HomeFragment extends Fragment {

    RecyclerView mRecyclerView;
    MyAdapter adapter;
    RecyclerView.RecycledViewPool mRecycledViewPool;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("TAG", "onCreate called");
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecycledViewPool = new RecyclerView.RecycledViewPool();
        adapter = new MyAdapter(getActivity(), mRecycledViewPool);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setRecycledViewPool(mRecycledViewPool);
        mRecyclerView.setAdapter(adapter);
        Ion.with(this).load("http://10.125.2.12:3000/data").noCache().asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
                Log.d("TAG", "Result is : " + result);
                final List<RecyclerViewItem> items = new ArrayList<>();
                try {
                    JSONArray data = new JSONArray(result);
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject item = data.getJSONObject(i);
                        int type = item.optInt("type");
                        ViewType viewType = ViewType.getViewType(type);
                        items.add(viewType.getItem(item));
                    }
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
                adapter.setData(items);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        ActionBar bar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        bar.setTitle("Home");
        bar.setDisplayHomeAsUpEnabled(false);
    }
}
