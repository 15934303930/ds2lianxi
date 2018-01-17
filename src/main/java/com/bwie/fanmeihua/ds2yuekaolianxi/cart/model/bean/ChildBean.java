package com.bwie.fanmeihua.ds2yuekaolianxi.cart.model.bean;

/**
 * 作者：FMH
 * 时间:2018/1/14 20:26
 */

public class ChildBean {
    private boolean goodscheck;
    private double bargainPrice;
    private String images;
    private String title;
    private String subhead;
    private int num;
    private boolean btn;
    private int pid;

    public ChildBean(boolean goodscheck, double bargainPrice, String images, String title, String subhead, int num, boolean btn) {
        this.goodscheck = goodscheck;
        this.bargainPrice = bargainPrice;
        this.images = images;
        this.title = title;
        this.subhead = subhead;
        this.num = num;
        this.btn = btn;
    }

    public ChildBean(boolean goodscheck, double bargainPrice, String images, String title, String subhead, int num, int pid) {
        this.goodscheck = goodscheck;
        this.bargainPrice = bargainPrice;
        this.images = images;
        this.title = title;
        this.subhead = subhead;
        this.num = num;
        this.pid = pid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public boolean isBtn() {
        return btn;
    }

    public void setBtn(boolean btn) {
        this.btn = btn;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isGoodscheck() {
        return goodscheck;
    }

    public void setGoodscheck(boolean goodscheck) {
        this.goodscheck = goodscheck;
    }

    public double getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(double bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubhead() {
        return subhead;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    @Override
    public String toString() {
        return "GoodsBean{" +
                "goodscheck=" + goodscheck +
                ", bargainPrice=" + bargainPrice +
                ", images='" + images + '\'' +
                ", title='" + title + '\'' +
                ", subhead='" + subhead + '\'' +
                ", num=" + num +
                ", btn=" + btn +
                '}';
    }
}
