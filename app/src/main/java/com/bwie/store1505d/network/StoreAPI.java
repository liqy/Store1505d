package com.bwie.store1505d.network;

import com.bwie.store1505d.model.CartData;
import com.bwie.store1505d.model.RootData;
import com.bwie.store1505d.model.UserData;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 接口类
 * Created by liqy on 2017/8/8.
 */

public interface StoreAPI {

    /**
     * 登录
     * @param mobile
     * @param password
     * @return
     */
    @FormUrlEncoded //表单提交
    @POST("user/login")
    //请求是POST
    Observable<RootData<UserData>> login(@Field("mobile") String mobile, @Field("password") String password);


    /**
     * 获取购物车
     * @param token
     * @param cart_id
     * @param uid
     * @param type
     * @return
     */
    @FormUrlEncoded
    @POST("cart")
    Observable<RootData<CartData>> cart(@Field("access_token") String token,
                                        @Field("app_cart_cookie_id") String cart_id,
                                        @Field("user_id") int uid,
                                        @Field("_terminal-type") String type
    );


}