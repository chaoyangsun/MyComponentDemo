package com.scy.component.common;

import android.app.Application;

public abstract class BaseApplication extends Application {
    /**
     * Application 初始化
     */
    public abstract void init(Application application);

}
