package com.bwie.store1505d.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 单例
 * Created by liqy on 2017/8/8.
 */

public class RetrofitHelper {

    //第一步 ；定义OkHttpClient变量
    private static OkHttpClient mOkHttpClient;

    /**
     * 第二步：单例模式，双重检测
     * Builder:构建者模式（建造者模式）
     * <p>
     * 初始化OKHttpClient
     */
    private static void initOkHttpClient() {
        if (mOkHttpClient == null) {//第一重检测
            synchronized (RetrofitHelper.class) {
                if (mOkHttpClient == null) {//第二重检测
                    mOkHttpClient = new OkHttpClient.Builder()
                            .retryOnConnectionFailure(true)//重连
                            .connectTimeout(30, TimeUnit.SECONDS)//超时
                            .writeTimeout(20, TimeUnit.SECONDS)
                            .readTimeout(20, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }

    /**
     * 第三步静态初始化
     */
    static {
        initOkHttpClient();
    }

    /**
     * 第四步：初始化retrofit；
     * 根据传入的baseUrl，和api创建retrofit
     *
     * @param clazz      类型
     * @param baseUrl//
     * @param <T>//接口服务类
     * @return
     */
    private static <T> T createApi(Class<T> clazz, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)//
                .client(mOkHttpClient)//绑定OKHTTP
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//绑定Rxjava
                .addConverterFactory(GsonConverterFactory.create())//gson解析
                .build();

        return retrofit.create(clazz);
    }

    /**
     * 第五步：绑定接口服务类到Retrofit
     * @return
     */
    public static StoreAPI getStoreAPI() {
        return createApi(StoreAPI.class, "http://api.eleteam.com/v1/");
    }
}
