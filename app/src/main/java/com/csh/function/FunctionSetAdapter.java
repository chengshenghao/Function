package com.csh.function;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.csh.function.bean.FunctionBean;
import com.csh.function.utils.ImgUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:功能设置
 *
 * @author wjx
 * @date 2018/5/9 9:49
 */
public class FunctionSetAdapter extends BaseItemDraggableAdapter<FunctionBean, BaseViewHolder> {

    public FunctionSetAdapter(List<FunctionBean> data) {
        super(R.layout.item_function_set, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, FunctionBean functionBean) {
        holder.setText(R.id.tv_name, functionBean.getName())
                .setImageResource(R.id.iv_icon, ImgUtils.getImage(functionBean.getId()))
                .setImageResource(R.id.iv, functionBean.getIsSelected() == 1 ? R.drawable.btn_del : R.drawable.btn_add_list);
    }
}
