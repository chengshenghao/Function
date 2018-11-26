package com.csh.function.bean;


/**
 * Desc: 称重视图item
 *
 * @author：Jing Yang
 * @date: 2018/5/2 13:43
 */
public class WeightViewItem {

    private boolean checked;

    private double editWeight;

    private WeightItem bean;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public double getEditWeight() {
        return editWeight;
    }

    public void setEditWeight(double editWeight) {
        this.editWeight = editWeight;
    }

    public WeightItem getBean() {
        return bean;
    }

    public void setBean(WeightItem bean) {
        this.bean = bean;
    }
}
