package com.scy.component.mycomponentdemo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.scy.component.common.BaseApplication;
import com.scy.component.commonbase.AppConfig;

public class App extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        // ARouter配置
        if (isDebug()) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(this); // As early as possible, it is recommended to initialize in the Application

        init(this);
    }

    private boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Override
    public void init(Application application) {
        //通过反射的方式 初始化各个组件的Application
        for (String moduleApp : AppConfig.moduleApps) {
            try {
                Class clazz = Class.forName(moduleApp);
                BaseApplication baseApp = (BaseApplication) clazz.newInstance();
                baseApp.init(this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
