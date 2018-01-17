package com.bwie.fanmeihua.ds2yuekaolianxi.product.model;

import com.bwie.fanmeihua.ds2yuekaolianxi.net.RetrofitHelper;
import com.bwie.fanmeihua.ds2yuekaolianxi.net.Success;
import com.bwie.fanmeihua.ds2yuekaolianxi.product.model.bean.ProductBean;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：FMH
 * 时间:2018/1/13 16:14
 */

public class ProductModel implements IProductModel {

    @Override
    public void getProductUrl(int pscid, final Success<ProductBean> success) {
        Flowable<ProductBean> flowable = RetrofitHelper.getSerViceAPI().getProductData(pscid);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ProductBean>() {
                    @Override
                    public void accept(ProductBean xqBean) throws Exception {
                        success.success(xqBean);
                    }
                });
    }
}
