package com.bwie.fanmeihua.ds2yuekaolianxi.detail.model;

import com.bwie.fanmeihua.ds2yuekaolianxi.detail.model.bean.AddCarts;
import com.bwie.fanmeihua.ds2yuekaolianxi.detail.model.bean.DetailBean;
import com.bwie.fanmeihua.ds2yuekaolianxi.net.Success;

/**
 * 作者：FMH
 * 时间:2018/1/13 17:42
 */

public interface IDetailModel {
    void getDetailUrl(int pid,String str, Success<DetailBean> success);
    void getAddCartsUrl(int pid,int uid,String str,Success<AddCarts> success);
}
