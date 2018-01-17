package com.bwie.fanmeihua.ds2yuekaolianxi.detail.view;

import com.bwie.fanmeihua.ds2yuekaolianxi.detail.model.bean.AddCarts;
import com.bwie.fanmeihua.ds2yuekaolianxi.detail.model.bean.DetailBean;

/**
 * 作者：FMH
 * 时间:2018/1/13 17:43
 */

public interface IDetailView {
    void getDetailData(DetailBean detailBean);
    void getAddCartsData(AddCarts addCarts);
}
