package com.scy.component.login;

import android.app.Application;

import com.scy.component.common.BaseApplication;
import com.scy.component.commonbase.InterfaceFactory;
import com.scy.component.login.sharedata.LoginDataShareImplement;

public class LoginApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        init(this);
    }

    @Override
    public void init(Application application) {
        //将Login对外暴露接口的实现类注册到工厂类InterfaceFactory里
        InterfaceFactory.getInstance().setLoginInterfaceImplement(new LoginDataShareImplement());
    }
}
