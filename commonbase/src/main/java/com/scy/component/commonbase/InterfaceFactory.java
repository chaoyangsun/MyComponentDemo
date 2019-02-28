package com.scy.component.commonbase;

import com.scy.component.commonbase.emptyimplement.EmptyImplementLogin;
import com.scy.component.commonbase.sharedata.LoginDataInterface;

/**
 * 各个组件可以通过 InterfaceFactory 获取想要调用的其他组件的接口实现
 */
public class InterfaceFactory {

    private LoginDataInterface interfaceImplement;

    private InterfaceFactory() {
    }

    /**
     * 单例模式
     */
    public static InterfaceFactory getInstance() {
        return Inner.serviceFactory;
    }

    private static class Inner {
        private static InterfaceFactory serviceFactory = new InterfaceFactory();
    }

    /**
     * 接收Login组件的 LoginDataInterface 实现类
     */
    public void setLoginInterfaceImplement(LoginDataInterface interfaceImplement) {
        this.interfaceImplement = interfaceImplement;
    }

    /**
     * 返回 注册的实现类的实例
     */
    public LoginDataInterface getLoginInterfaceImplement() {
        //如果Login组件缺失 返回一个空实现
        if (interfaceImplement == null) {
            interfaceImplement = new EmptyImplementLogin();
        }
        return interfaceImplement;
    }
}
