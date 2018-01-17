package com.bwie.fanmeihua.ds2yuekaolianxi.reg.model;

import com.bwie.fanmeihua.ds2yuekaolianxi.net.Success;
import com.bwie.fanmeihua.ds2yuekaolianxi.reg.model.bean.RegBean;

/**
 * 作者：FMH
 * 时间:2018/1/13 15:04
 */

public interface IRegModel {
    void getRegUrl(String mobile, String password, Success<RegBean> success);
}
