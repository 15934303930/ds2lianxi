package com.bwie.fanmeihua.ds2yuekaolianxi.detail.model;

import com.bwie.fanmeihua.ds2yuekaolianxi.detail.model.bean.AddCarts;
import com.bwie.fanmeihua.ds2yuekaolianxi.detail.model.bean.DetailBean;
import com.bwie.fanmeihua.ds2yuekaolianxi.net.RetrofitHelper;
import com.bwie.fanmeihua.ds2yuekaolianxi.net.Success;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：FMH
 * 时间:2018/1/13 17:44
 */

public class DetailModel implements IDetailModel {
    @Override
    public void getDetailUrl(int pid,String str,final Success<DetailBean> success) {
        Flowable<DetailBean> flowable = RetrofitHelper.getSerViceAPI().getDetailData(pid,str);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<DetailBean>() {
                    @Override
                    public void accept(DetailBean xqBean) throws Exception {
                        success.success(xqBean);
                    }
                });
    }

    @Override
    public void getAddCartsUrl(int pid, int uid, String str, final Success<AddCarts> success) {
        Flowable<AddCarts> flowable = RetrofitHelper.getSerViceAPI().getAddCartsData(pid,uid,str);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<AddCarts>() {
                    @Override
                    public void accept(AddCarts xqBean) throws Exception {
                        success.success(xqBean);
                    }
                });
    }
}
