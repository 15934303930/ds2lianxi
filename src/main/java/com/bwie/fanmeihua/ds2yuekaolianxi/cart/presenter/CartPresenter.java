package com.bwie.fanmeihua.ds2yuekaolianxi.cart.presenter;

import com.bwie.fanmeihua.ds2yuekaolianxi.cart.model.CartModel;
import com.bwie.fanmeihua.ds2yuekaolianxi.cart.model.bean.GetCarts;
import com.bwie.fanmeihua.ds2yuekaolianxi.cart.view.ICartView;
import com.bwie.fanmeihua.ds2yuekaolianxi.net.Success;

/**
 * 作者：FMH
 * 时间:2018/1/14 20:39
 */

public class CartPresenter extends CartModel {
    ICartView iCartView;
    CartModel cartModel;

    public CartPresenter(ICartView iCartView) {
        this.iCartView = iCartView;
        this.cartModel = new CartModel();
    }
    public void getCartUrl(){
        cartModel.getCartUrl(2933,"android",new Success<GetCarts>() {
            @Override
            public void success(GetCarts getCarts) {
                iCartView.CartSuccess(getCarts);
            }
        });
    }
}
