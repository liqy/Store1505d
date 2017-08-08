package com.bwie.store1505d.model;

import java.util.List;

/**
 * Created by liqy on 2017/8/8.
 */

public class CartData {
    public int cart_num;
    public int total_price;
    public boolean is_logged_in;
    public String app_cart_cookie_id;

    public List<CartItem> cartItems;

    @Override
    public String toString() {
        return "CartData{" +
                "cart_num=" + cart_num +
                ", total_price=" + total_price +
                ", is_logged_in=" + is_logged_in +
                ", app_cart_cookie_id='" + app_cart_cookie_id + '\'' +
                '}';
    }
}
