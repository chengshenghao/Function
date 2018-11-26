package com.csh.function;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.csh.function.adapter.WeightAdapter;

public class WeightActivity extends AppCompatActivity {


    private WeightAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
//        adapter = new WeightAdapter(list);
//        ((RecyclerView)findViewById(R.id.rv_items)).setAdapter(adapter);
    }
}
