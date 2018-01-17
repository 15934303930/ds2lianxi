package com.bwie.fanmeihua.ds2yuekaolianxi.cart.model;

import com.bwie.fanmeihua.ds2yuekaolianxi.cart.model.bean.GetCarts;
import com.bwie.fanmeihua.ds2yuekaolianxi.net.RetrofitHelper;
import com.bwie.fanmeihua.ds2yuekaolianxi.net.Success;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：FMH
 * 时间:2018/1/14 20:37
 */

public class CartModel implements ICartModel {
    @Override
    public void getCartUrl(int uid,String str, final Success<GetCarts> success) {
        Flowable<GetCarts> flowable = RetrofitHelper.getSerViceAPI().getCarts(uid,str);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<GetCarts>() {
                    @Override
                    public void accept(GetCarts xqBean) throws Exception {
                        success.success(xqBean);
                    }
                });
    }
}
