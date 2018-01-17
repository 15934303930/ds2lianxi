package com.bwie.fanmeihua.ds2yuekaolianxi.login.view;

import com.bwie.fanmeihua.ds2yuekaolianxi.login.model.bean.LoginBean;

/**
 * 作者：FMH
 * 时间:2018/1/13 09:06
 */

public interface ILoginView {
    void loginSuccess(LoginBean loginBean);
    void loginFail();
}
