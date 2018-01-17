package com.bwie.fanmeihua.ds2yuekaolianxi.reg.view;

import com.bwie.fanmeihua.ds2yuekaolianxi.reg.model.bean.RegBean;

/**
 * 作者：FMH
 * 时间:2018/1/13 11:44
 */

public interface IRegView {
    void getRegSuccess(RegBean regBean);
    void getRegFail();
}
