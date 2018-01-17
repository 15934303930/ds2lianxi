package com.bwie.fanmeihua.ds2yuekaolianxi.net;

import com.bwie.fanmeihua.ds2yuekaolianxi.cart.model.bean.GetCarts;
import com.bwie.fanmeihua.ds2yuekaolianxi.detail.model.bean.AddCarts;
import com.bwie.fanmeihua.ds2yuekaolianxi.detail.model.bean.DetailBean;
import com.bwie.fanmeihua.ds2yuekaolianxi.login.model.bean.LoginBean;
import com.bwie.fanmeihua.ds2yuekaolianxi.product.model.bean.ProductBean;
import com.bwie.fanmeihua.ds2yuekaolianxi.reg.model.bean.RegBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者：FMH
 * 时间:2018/1/13 09:33
 */

public interface ServiceApi {
    @GET("user/login")
    Flowable<LoginBean> getLoginData(@Query("mobile") String mobile, @Query("password") String password);
    @GET("user/reg")
    Flowable<RegBean> getRegData(@Query("mobile") String mobile, @Query("password") String password);
    @GET("product/getProducts")
    Flowable<ProductBean> getProductData(@Query("pscid") int pscid);
    @GET("product/getProductDetail")
    Flowable<DetailBean> getDetailData(@Query("pid") int pid,@Query("source")String str);
    @GET("product/addCart")
    Flowable<AddCarts> getAddCartsData(@Query("pid") int pid,@Query("uid") int uid,@Query("source")String str);
    @GET("product/getCarts")
    Flowable<GetCarts> getCarts(@Query("uid") int uid,@Query("source")String str);
}
