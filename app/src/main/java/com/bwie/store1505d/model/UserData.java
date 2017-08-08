package com.bwie.store1505d.model;

/**
 * Created by liqy on 2017/8/8.
 */

public class UserData {
    public User user;
    public String app_cart_cookie_id;

    @Override
    public String toString() {
        return "UserData{" +
                "user=" + user +
                ", app_cart_cookie_id='" + app_cart_cookie_id + '\'' +
                '}';
    }
}
