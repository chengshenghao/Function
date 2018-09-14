package com.csh.function;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.csh.function.bean.FunctionBean;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCommon;
    private ArrayList<FunctionBean> arrayCommon;
    private ArrayList<FunctionBean> arrayOther;
    private RecyclerView rvOther;
    private FunctionSetAdapter commonAdapter;
    private FunctionSetAdapter otherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();


        //常用操作的拖拽
        commonAdapter = new FunctionSetAdapter(arrayCommon);
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
        otherAdapter = new FunctionSetAdapter(arrayOther);
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


        //点击事件处理
        commonAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                changState(commonAdapter.getData().get(position));
            }
        });
        otherAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                changState(otherAdapter.getData().get(position));
            }
        });
    }

    private void initData() {
        arrayCommon = new ArrayList<FunctionBean>();
        for (int i = 0; i < 4; i++) {
            FunctionBean functionBean = new FunctionBean();
            functionBean.setId(i + 1);
            functionBean.setIsSelected(1);
            functionBean.setName("测试" + i);
            arrayCommon.add(functionBean);
        }
        arrayOther = new ArrayList<FunctionBean>();
        for (int i = 4; i < 12; i++) {
            FunctionBean functionBean = new FunctionBean();
            functionBean.setId(i + 1);
            functionBean.setIsSelected(0);
            functionBean.setName("测试" + i);
            arrayOther.add(functionBean);
        }
    }

    public void changState(FunctionBean functionBean) {
        if (functionBean.getIsSelected() == 1) {
            functionBean.setIsSelected(0);
            arrayCommon.remove(functionBean);
            arrayOther.add(functionBean);
        } else {
            if (arrayCommon.size() >= 4) {
                Toast.makeText(this, "常用功能最多选择4个", Toast.LENGTH_SHORT).show();
                return;
            }
            functionBean.setIsSelected(1);
            arrayOther.remove(functionBean);
            arrayCommon.add(functionBean);
        }
//        getmDatabase().functionDao().replace(dbFunction);
        commonAdapter.notifyDataSetChanged();
        otherAdapter.notifyDataSetChanged();
    }
}
