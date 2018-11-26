package com.csh.function.bean;

/**
 * 描述:
 *
 * @author wjx
 * @date 2018/4/9 16:15
 */
public class WeightItem {
    private long id;
    /**
     * 是否确认称重 1:是；0:否
     */
    private int isConfirmWeigh;
    private long itemId;
    private String itemCode;
    private String itemName;
    /**
     * 品项数量
     */
    private double lastQty;
    private String unitName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIsConfirmWeigh() {
        return isConfirmWeigh;
    }

    public void setIsConfirmWeigh(int isConfirmWeigh) {
        this.isConfirmWeigh = isConfirmWeigh;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getLastQty() {
        return lastQty;
    }

    public void setLastQty(double lastQty) {
        this.lastQty = lastQty;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
