package com.scy.component.mycomponentdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.scy.component.common.utils.ToastUtil;
import com.scy.component.commonbase.InterfaceFactory;

public class MainActivity extends AppCompatActivity {

    private android.widget.TextView tvname;
    private android.widget.Button gotologin;
    private android.widget.Button gotopay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.gotopay = (Button) findViewById(R.id.goto_pay);
        this.gotologin = (Button) findViewById(R.id.goto_login);
        this.tvname = (TextView) findViewById(R.id.tv_name);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvname.setText(InterfaceFactory.getInstance().getLoginInterfaceImplement().getUserName());
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
        if (InterfaceFactory.getInstance().getLoginInterfaceImplement().isLogin()){
            ARouter.getInstance().build("/pay/pay").navigation();
        }else {
            ToastUtil.showToast(this, "还未登录");
//            Toast.makeText(this, "sss", Toast.LENGTH_SHORT).show();
        }
    }
}
