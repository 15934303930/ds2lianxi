package com.bwie.fanmeihua.ds2yuekaolianxi.reg.presenter;

import com.bwie.fanmeihua.ds2yuekaolianxi.net.Success;
import com.bwie.fanmeihua.ds2yuekaolianxi.reg.model.RegModel;
import com.bwie.fanmeihua.ds2yuekaolianxi.reg.model.bean.RegBean;
import com.bwie.fanmeihua.ds2yuekaolianxi.reg.view.IRegView;

/**
 * 作者：FMH
 * 时间:2018/1/13 15:10
 */

public class RegPresenter extends RegModel{
    IRegView iRegView;
    RegModel regModel;

    public RegPresenter(IRegView iRegView) {
        this.iRegView = iRegView;
        this.regModel = new RegModel();
    }
    public void getRegUrl(String mobile,String password){
        regModel.getRegUrl(mobile, password, new Success<RegBean>() {
            @Override
            public void success(RegBean regBean) {
                if ("0".equals(regBean.getCode())){
                    iRegView.getRegSuccess(regBean);
                }else{
                    iRegView.getRegFail();
                }
            }
        });
    }
}
