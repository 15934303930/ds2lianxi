package com.bwie.fanmeihua.ds2yuekaolianxi.product.presenter;

import com.bwie.fanmeihua.ds2yuekaolianxi.net.Success;
import com.bwie.fanmeihua.ds2yuekaolianxi.product.model.ProductModel;
import com.bwie.fanmeihua.ds2yuekaolianxi.product.model.bean.ProductBean;
import com.bwie.fanmeihua.ds2yuekaolianxi.product.view.IProductView;

/**
 * 作者：FMH
 * 时间:2018/1/13 16:20
 */

public class ProductPresenter extends ProductModel {
    IProductView iProductView;
    ProductModel productModel;

    public ProductPresenter(IProductView iProductView) {
        this.iProductView = iProductView;
        this.productModel = new ProductModel();
    }
    public void getProductUrl(){
        productModel.getProductUrl(1, new Success<ProductBean>() {
            @Override
            public void success(ProductBean productBean) {
                iProductView.getProductData(productBean);
            }
        });
    }
}
