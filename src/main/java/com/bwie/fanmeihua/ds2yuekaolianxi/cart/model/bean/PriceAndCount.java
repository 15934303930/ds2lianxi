package com.bwie.fanmeihua.ds2yuekaolianxi.cart.model.bean;

/**
 * 作者：FMH
 * 时间:2018/1/17 11:41
 */

public class PriceAndCount {
    private double price;
    private int count;

    public PriceAndCount(double price, int count) {
        this.price = price;
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
