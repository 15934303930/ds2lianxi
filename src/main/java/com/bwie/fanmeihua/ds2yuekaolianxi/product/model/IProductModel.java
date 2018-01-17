package com.bwie.fanmeihua.ds2yuekaolianxi.product.model;

import com.bwie.fanmeihua.ds2yuekaolianxi.net.Success;
import com.bwie.fanmeihua.ds2yuekaolianxi.product.model.bean.ProductBean;

/**
 * 作者：FMH
 * 时间:2018/1/13 16:13
 */

public interface IProductModel {
    void getProductUrl(int pscid, Success<ProductBean> success);
}
