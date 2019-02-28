package com.scy.component.commonbase.sharedata;

/**
 * 登录组件 对外暴露数据的接口方法
 */
public interface LoginDataInterface {
    /**
     * 登录与否
     * @return
     */
    boolean isLogin();

    /**
     * 登录人姓名
     * @return
     */
    String getUserName();
}
