package com.scy.component.commonbase.emptyimplement;

import com.scy.component.commonbase.sharedata.LoginDataInterface;

/**
 * LoginDataInterface接口的空实现 防止在其真正的实现类所在组件缺失时 出现崩溃
 */
public class EmptyImplementLogin implements LoginDataInterface {
    @Override
    public boolean isLogin() {
        return false;
    }

    @Override
    public String getUserName() {
        return null;
    }
}
