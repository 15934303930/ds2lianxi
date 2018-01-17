package com.bwie.fanmeihua.ds2yuekaolianxi.login.presenter;

import com.bwie.fanmeihua.ds2yuekaolianxi.login.model.LoginModel;
import com.bwie.fanmeihua.ds2yuekaolianxi.login.model.bean.LoginBean;
import com.bwie.fanmeihua.ds2yuekaolianxi.login.view.ILoginView;
import com.bwie.fanmeihua.ds2yuekaolianxi.net.Success;

/**
 * 作者：FMH
 * 时间:2018/1/13 10:46
 */

public class LoginPresenter extends LoginModel{
    ILoginView iLoginView;
    LoginModel loginModel;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        this.loginModel = new LoginModel();
    }
    //调用方法
    public void getLoginUrl(String mobile,String password){
        loginModel.getLoginUrl(mobile, password, new Success<LoginBean>() {
            @Override
            public void success(LoginBean loginBean) {
                if ("0".equals(loginBean.getCode())){
                    iLoginView.loginSuccess(loginBean);
                }else{
                    iLoginView.loginFail();
                }

            }
        });
    }
}
