package com.bwie.fanmeihua.ds2yuekaolianxi.detail.presenter;

import android.util.Log;

import com.bwie.fanmeihua.ds2yuekaolianxi.detail.model.DetailModel;
import com.bwie.fanmeihua.ds2yuekaolianxi.detail.model.bean.AddCarts;
import com.bwie.fanmeihua.ds2yuekaolianxi.detail.model.bean.DetailBean;
import com.bwie.fanmeihua.ds2yuekaolianxi.detail.view.IDetailView;
import com.bwie.fanmeihua.ds2yuekaolianxi.net.Success;

/**
 * 作者：FMH
 * 时间:2018/1/13 17:50
 */

public class DetailPresenter extends DetailModel {
    IDetailView iDetailView;
    DetailModel detailModel;

    public DetailPresenter(IDetailView iDetailView) {
        this.iDetailView = iDetailView;
        this.detailModel = new DetailModel();
    }
    public void getDetailUrl(int pid){
        detailModel.getDetailUrl(pid,"android",new Success<DetailBean>() {
            @Override
            public void success(DetailBean detailBean) {
                Log.e("+++", "success:"+detailBean.getMsg());
                iDetailView.getDetailData(detailBean);
            }
        });
    }
    public void getAddCartslUrl(int pid){
        detailModel.getAddCartsUrl(pid,2933,"android",new Success<AddCarts>() {
            @Override
            public void success(AddCarts addCarts) {
                iDetailView.getAddCartsData(addCarts);
            }
        });
    }
}
