package com.bwie.store1505d;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.bwie.store1505d.adapter.CartAdapter;
import com.bwie.store1505d.model.CartData;
import com.bwie.store1505d.model.RootData;
import com.bwie.store1505d.model.User;
import com.bwie.store1505d.model.UserData;
import com.bwie.store1505d.network.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 购物车
 * <p>
 * android使用shape stroke描边只保留底部
 * http://blog.csdn.net/liuqz2009/article/details/70313070
 * <p>
 * ListView 局部更新
 * http://blog.csdn.net/linglongxin24/article/details/53020164?ref=myread
 */
public class MainActivity extends AppCompatActivity {

    ListView listView;
    CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        /**
         * 登录
         */
        RetrofitHelper.getStoreAPI()
                .login("18610463512", "123456")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RootData<UserData>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(getLocalClassName(), e.getMessage());

                    }

                    @Override
                    public void onNext(RootData<UserData> userDataRootData) {
                        Log.d(getLocalClassName(), userDataRootData.toString());
                        User user = userDataRootData.data.user;
                        //TODO 保存起来,存放在SQLite中

                        //获取购物车
                        RetrofitHelper.getStoreAPI()
                                .cart(user.access_token, userDataRootData.data.app_cart_cookie_id, user.id, "ios")
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<RootData<CartData>>() {
                                    @Override
                                    public void onCompleted() {
                                        //TODO 请求完成
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        // TODO 请求错误
                                    }

                                    @Override
                                    public void onNext(RootData<CartData> cartDataRootData) {
                                        //TODO 数据处理
                                        Log.d(getLocalClassName(), cartDataRootData.toString());

                                        adapter.addData(cartDataRootData.data.cartItems);
                                    }
                                })
                        ;

                    }
                });


    }

    /**
     * 初始化UI
     */
    private void initUI() {
        listView = (ListView) findViewById(R.id.listView);
        adapter = new CartAdapter(this);
        listView.setAdapter(adapter);
    }
}
