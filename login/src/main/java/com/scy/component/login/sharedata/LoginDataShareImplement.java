package com.scy.component.login.sharedata;

import android.text.TextUtils;

import com.scy.component.commonbase.sharedata.LoginDataInterface;
import com.scy.component.login.logindata.LoginUtil;

/**
 * Login 组件对外暴露数据的接口实现类
 * 外界要通过 commonbase 里的 InterfaceFactory 工厂类获取该实现类的前提是
 * 该类需要在App初始化的时候就注册到 InterfaceFactory 里
 */
public class LoginDataShareImplement implements LoginDataInterface {
    @Override
    public boolean isLogin() {
        return !TextUtils.isEmpty(LoginUtil.getUserName());
    }

    @Override
    public String getUserName() {
        return LoginUtil.getUserName();
    }
}
