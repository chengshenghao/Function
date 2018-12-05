package com.csh.function;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.csh.function.adapter.WeightAdapter;
import com.csh.function.bean.WeightViewItem;
import com.csh.function.bean.WeightViewItems;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class WeightActivity extends AppCompatActivity {


    private WeightAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        List<WeightViewItem> list = new ArrayList<>();
        String json = "{    \"items\": [        {            \"id\": 1,            \"isConfirmWeigh\": 1,            \"itemCode\": \"1001\",            \"itemId\": 1001,            \"itemName\": \"王牌大虾\",            \"lastQty\": 1,            \"unitName\": \"两\"        },        {            \"id\": 1,            \"isConfirmWeigh\": 0,            \"itemCode\": \"1002\",            \"itemId\": 1002,            \"itemName\": \"红烧狮子头\",            \"lastQty\": 2,            \"unitName\": \"份\"        },        {            \"id\": 1,            \"isConfirmWeigh\": 1,            \"itemCode\": \"1003\",            \"itemId\": 1003,            \"itemName\": \"黑鱼\",            \"lastQty\": 3,            \"unitName\": \"斤\"        },        {            \"id\": 1,            \"isConfirmWeigh\": 1,            \"itemCode\": \"1001\",            \"itemId\": 1001,            \"itemName\": \"王牌大虾\",            \"lastQty\": 4,            \"unitName\": \"两\"        },        {            \"id\": 1,            \"isConfirmWeigh\": 0,            \"itemCode\": \"1002\",            \"itemId\": 1002,            \"itemName\": \"红烧狮子头\",            \"lastQty\": 5,            \"unitName\": \"份\"        },        {            \"id\": 1,            \"isConfirmWeigh\": 1,            \"itemCode\": \"1003\",            \"itemId\": 1003,            \"itemName\": \"黑鱼\",            \"lastQty\": 6,            \"unitName\": \"斤\"        },        {            \"id\": 1,            \"isConfirmWeigh\": 1,            \"itemCode\": \"1001\",            \"itemId\": 1001,            \"itemName\": \"王牌大虾\",            \"lastQty\": 7,            \"unitName\": \"两\"        },        {            \"id\": 1,            \"isConfirmWeigh\": 0,            \"itemCode\": \"1002\",            \"itemId\": 1002,            \"itemName\": \"红烧狮子头\",            \"lastQty\": 8,            \"unitName\": \"份\"        },        {            \"id\": 1,            \"isConfirmWeigh\": 1,            \"itemCode\": \"1003\",            \"itemId\": 1003,            \"itemName\": \"黑鱼\",            \"lastQty\": 9,            \"unitName\": \"斤\"        }    ]}";
        Gson gson = new Gson();
        WeightViewItems weightViewItems= gson.fromJson(json,WeightViewItems.class);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv_items);
        recyclerView.setLayoutManager(manager);
        adapter = new WeightAdapter(weightViewItems.items);
        recyclerView.setAdapter(adapter);
    }
}
