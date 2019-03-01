package com.scy.component.pay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.scy.component.common.utils.ToastUtil;
import com.scy.component.commonbase.InterfaceFactory;

@Route(path = "/pay/pay")
public class PayActivity extends AppCompatActivity {

    private android.widget.TextView tvname;
    private android.widget.Button gotologin;
    private android.widget.Button btnpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_activity_pay);
        this.btnpay = (Button) findViewById(R.id.btn_pay);
        this.gotologin = (Button) findViewById(R.id.goto_login);
        this.tvname = (TextView) findViewById(R.id.tv_name);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvname.setText(InterfaceFactory.getInstance().getLoginInterfaceImplement().getUserName());
    }

    /**
     * 支付 前提是已登录
     * @param view
     */
    public void pay(View view) {
        if (InterfaceFactory.getInstance().getLoginInterfaceImplement().isLogin()) {
            ToastUtil.showToast(this, "支付成功");
        } else {
            ToastUtil.showToast(this, "还未登录");
        }
    }

    /**
     * 去登录
     * @param view
     */
    public void gotoLogin(View view) {
        ARouter.getInstance().build("/account/login").navigation();
    }
}
