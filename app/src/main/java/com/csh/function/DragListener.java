package com.csh.function;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.listener.OnItemDragListener;

/**
 * 描述:
 *
 * @author wjx
 * @date 2018/5/9 11:43
 */
public abstract class DragListener implements OnItemDragListener {
    @Override
    public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {

    }

    @Override
    public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {

    }
}
