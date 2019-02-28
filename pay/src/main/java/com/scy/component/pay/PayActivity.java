package com.scy.component.pay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/account/pay")
public class PayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_activity_pay);
    }

    /**
     * 支付 前提是已登录
     * @param view
     */
    public void pay(View view) {

    }

    /**
     * 去登录
     * @param view
     */
    public void gotoLogin(View view) {
    }
}
