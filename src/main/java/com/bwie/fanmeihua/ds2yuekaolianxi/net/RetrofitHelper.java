package com.bwie.fanmeihua.ds2yuekaolianxi.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：FMH
 * 时间:2018/1/13 09:47
 */

public class RetrofitHelper {
    public static OkHttpClient okHttpClient;
    public static ServiceApi serViceAPI;
    /**
     * 优先执行
     */
    static {
        getOkHttpClient();
    }
    public static OkHttpClient getOkHttpClient(){
        if(okHttpClient==null){
            synchronized (OkHttpClient.class){
                if(okHttpClient==null){
                    okHttpClient=new OkHttpClient();
                }
            }
        }
        return okHttpClient;
    }
    public static ServiceApi getSerViceAPI(){

        if(serViceAPI==null){
            synchronized (OkHttpClient.class){
                if(serViceAPI==null){
                    serViceAPI=onCreate(ServiceApi.class,Api.HOST);
                }
            }
        }
        return serViceAPI;
    }
    public static <T> T onCreate(Class<T>tClass,String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(tClass);
    }
}
