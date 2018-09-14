package com.csh.function;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.csh.function.bean.FunctionBean;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCommon;
    private ArrayList<FunctionBean> arrayCommon;
    private ArrayList<FunctionBean> arrayOther;
    private RecyclerView rvOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        //常用操作的拖拽
        FunctionSetAdapter commonAdapter = new FunctionSetAdapter(arrayCommon);
        ItemDragAndSwipeCallback commDragCallBack = new ItemDragAndSwipeCallback(commonAdapter);
        commDragCallBack.setSwipeMoveFlags(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        ItemTouchHelper commTouch = new ItemTouchHelper(commDragCallBack);
        rvCommon = (RecyclerView) findViewById(R.id.rv_common);
        commTouch.attachToRecyclerView(rvCommon);
        commonAdapter.enableSwipeItem();
        commonAdapter.enableDragItem(commTouch);
        OnItemDragListener listener = new DragListener() {
            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
                //TODO 可进行数据库的相关操作（保存数据最新顺序）
//                mModel.saveDatas(commonAdapter.getData());
            }
        };
        commonAdapter.setOnItemDragListener(listener);
        rvCommon.setAdapter(commonAdapter);


        //全部操作的拖拽
        FunctionSetAdapter otherAdapter = new FunctionSetAdapter(arrayOther);
        ItemDragAndSwipeCallback otherDragCallback = new ItemDragAndSwipeCallback(otherAdapter);
        otherDragCallback.setSwipeMoveFlags(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP);
        ItemTouchHelper otherTouch = new ItemTouchHelper(otherDragCallback);
        rvOther = (RecyclerView) findViewById(R.id.rv_other);
        otherTouch.attachToRecyclerView(rvOther);
        otherAdapter.enableSwipeItem();
        otherAdapter.enableDragItem(otherTouch);
        OnItemDragListener listener1 = new DragListener() {
            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
                //TODO 可进行数据库的相关操作（保存数据最新顺序）
//                mModel.saveDatas(otherAdapter.getData());
            }
        };
        otherAdapter.setOnItemDragListener(listener1);
        rvOther.setAdapter(otherAdapter);

    }

    private void initData() {
        arrayCommon = new ArrayList<FunctionBean>();
        for (int i = 0; i <4 ; i++) {
            FunctionBean functionBean = new FunctionBean();
            functionBean.setId(i+1);
            functionBean.setIsSelected(1);
            functionBean.setName("测试"+i);
            arrayCommon.add(functionBean);
        }
        arrayOther = new ArrayList<FunctionBean>();
        for (int i = 4; i <12 ; i++) {
            FunctionBean functionBean = new FunctionBean();
            functionBean.setId(i+1);
            functionBean.setIsSelected(0);
            functionBean.setName("测试"+i);
            arrayOther.add(functionBean);
        }

    }
}
