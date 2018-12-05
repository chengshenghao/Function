package com.csh.function.adapter;

import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.csh.function.R;
import com.csh.function.bean.WeightViewItem;

import java.util.List;


/**
 * Desc:称重品项
 *
 * @author：Jing Yang
 * @date: 2018/5/2 13:47
 */
public class WeightAdapter extends BaseQuickAdapter<WeightViewItem, WeightAdapter.WeightHolder> {

    public WeightAdapter(@Nullable List<WeightViewItem> data) {
        super(R.layout.item_weight, data);
    }

    @Override
    protected void convert(final WeightHolder helper, final WeightViewItem item) {
        helper.item = item;
        helper.getView(R.id.iv_check).setSelected(item.isChecked());
        helper.setText(R.id.tv_name, item.getItemName());
        helper.setText(R.id.tv_unit, item.getUnitName());

        helper.getView(R.id.group_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setChecked(!item.isChecked());
                helper.getView(R.id.iv_check).setSelected(item.isChecked());
            }
        });
        getWeightEdit(helper).setTag(item);
        getWeightEdit(helper).clearFocus();
        getWeightEdit(helper).setText(String.valueOf(item.getLastQty()));
    }

    private EditText getWeightEdit(WeightHolder helper) {
        return helper.getView(R.id.et_weight);
    }

    public static class WeightHolder extends BaseViewHolder {

        private EditText etWeight;

        public TextWatcher textWatcher;
        public WeightViewItem item;
        private ImageView ivCheck;

        public WeightHolder(View view) {
            super(view);
            etWeight = getView(R.id.et_weight);
            ivCheck = getView(R.id.iv_check);
            textWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.length() > 0) {
                        try {
                            item.setEditWeight(Double.parseDouble(s.toString()));
                            if (etWeight.isFocused()) {
                                item.setChecked(true);
                                ivCheck.setSelected(item.isChecked());
                            }
                        } catch (Exception e) {
                        }
                    }
                }

                @Override
                public void afterTextChanged(Editable edt) {
                    String temp = edt.toString();
                    int posDot = temp.indexOf(".");
                    if (posDot >= 0 && temp.length() - posDot - 1 > 2) {// 设置最多显示小数点后两位
                        edt.delete(posDot + 3, posDot + 4);
                        return;
                    }
                }
            };
            etWeight.addTextChangedListener(textWatcher);
        }
    }

}
