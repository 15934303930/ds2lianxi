package com.bwie.fanmeihua.ds2yuekaolianxi.cart.model;

import com.bwie.fanmeihua.ds2yuekaolianxi.cart.model.bean.GetCarts;
import com.bwie.fanmeihua.ds2yuekaolianxi.net.Success;

/**
 * 作者：FMH
 * 时间:2018/1/14 20:36
 */

public interface ICartModel {
    void getCartUrl(int uid,String str, Success<GetCarts> success);
}
