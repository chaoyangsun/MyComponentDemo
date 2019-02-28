package com.scy.component.mycomponentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 去登录
     *
     * @param view
     */
    public void gotoLogin(View view) {
        ARouter.getInstance().build("/account/login").navigation();
    }

    /**
     * 去支付
     *
     * @param view
     */
    public void gotoPay(View view) {
        ARouter.getInstance().build("/pay/pay").navigation();
    }
}
