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

public class MainActivity extends AppCompatActivity {

    User user;
    ListView listView;
    CartAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        adapter = new CartAdapter(this);
        listView.setAdapter(adapter);
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
                        user = userDataRootData.data.user;
                        //TODO 保存起来
                    }
                });


        //获取购物车
        RetrofitHelper.getStoreAPI()
                .cart("TW5yIGDt5rYDnualXyp6A4rdQNpZoSKQ", "ff51418d453201602a768743c5ac648c", 158, "ios")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RootData<CartData>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RootData<CartData> cartDataRootData) {
                        Log.d(getLocalClassName(), cartDataRootData.toString());

                        adapter.addData(cartDataRootData.data.cartItems);
                    }
                })
        ;

    }
}
