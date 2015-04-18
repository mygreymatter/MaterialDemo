package com.mayo.materialdemo.recyclerview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mayo.materialdemo.R;


public class ActRecyclerView extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String[] mNames = {"rekha", "mayo", "kanchana"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_recycler_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new MyAdapter(mNames);
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
}
