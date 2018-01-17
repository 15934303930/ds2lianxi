package com.bwie.fanmeihua.ds2yuekaolianxi.login.model;

import com.bwie.fanmeihua.ds2yuekaolianxi.login.model.bean.LoginBean;
import com.bwie.fanmeihua.ds2yuekaolianxi.net.RetrofitHelper;
import com.bwie.fanmeihua.ds2yuekaolianxi.net.Success;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：FMH
 * 时间:2018/1/13 10:02
 */

public class LoginModel implements ILoginModel {
    //请求数据
    @Override
    public void getLoginUrl(String mobile, String password, final Success<LoginBean> success) {
        Flowable<LoginBean> flowable = RetrofitHelper.getSerViceAPI().getLoginData(mobile, password);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean xqBean) throws Exception {
                        success.success(xqBean);
                    }
                });
    }
}
