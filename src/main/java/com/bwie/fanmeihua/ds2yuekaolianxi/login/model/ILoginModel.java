package com.bwie.fanmeihua.ds2yuekaolianxi.login.model;

import com.bwie.fanmeihua.ds2yuekaolianxi.login.model.bean.LoginBean;
import com.bwie.fanmeihua.ds2yuekaolianxi.net.Success;

/**
 * 作者：FMH
 * 时间:2018/1/13 09:58
 */

public interface ILoginModel {
    void getLoginUrl(String mobile, String password, Success<LoginBean> success);
}
