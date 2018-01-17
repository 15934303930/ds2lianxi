package com.bwie.fanmeihua.ds2yuekaolianxi.reg.model;

import com.bwie.fanmeihua.ds2yuekaolianxi.net.RetrofitHelper;
import com.bwie.fanmeihua.ds2yuekaolianxi.net.Success;
import com.bwie.fanmeihua.ds2yuekaolianxi.reg.model.bean.RegBean;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：FMH
 * 时间:2018/1/13 15:06
 */

public class RegModel implements IRegModel{
    @Override
    public void getRegUrl(String mobile, String password, final Success<RegBean> success) {
        Flowable<RegBean> flowable = RetrofitHelper.getSerViceAPI().getRegData(mobile,password);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<RegBean>() {
                    @Override
                    public void accept(RegBean xqBean) throws Exception {
                        success.success(xqBean);
                    }
                });
    }
}
