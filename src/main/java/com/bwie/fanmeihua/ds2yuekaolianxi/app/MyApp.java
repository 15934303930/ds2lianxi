package com.bwie.fanmeihua.ds2yuekaolianxi.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 作者：FMH
 * 时间:2018/1/13 10:00
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
