package com.scy.component.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.scy.component.common.utils.ToastUtil;
import com.scy.component.commonbase.InterfaceFactory;
import com.scy.component.login.logindata.LoginUtil;

@Route(path = "/account/login")
public class LoginActivity extends AppCompatActivity {

    private android.widget.TextView tvname;
    private android.widget.Button gotologin;
    private android.widget.Button gotoexit;
    private android.widget.Button gotopay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_login);
        this.gotopay = (Button) findViewById(R.id.goto_pay);
        this.gotoexit = (Button) findViewById(R.id.goto_exit);
        this.gotologin = (Button) findViewById(R.id.goto_login);
        this.tvname = (TextView) findViewById(R.id.tv_name);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvname.setText(LoginUtil.getUserName());
    }

    /**
     * 登录
     *
     * @param view
     */
    public void login(View view) {
        updateLoginState("admin");
    }

    /**
     * 退出
     *
     * @param view
     */
    public void exit(View view) {
        updateLoginState("");
    }

    private void updateLoginState(String name) {
        LoginUtil.setUserName(name);
        tvname.setText(name);
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
        }
    }

}
