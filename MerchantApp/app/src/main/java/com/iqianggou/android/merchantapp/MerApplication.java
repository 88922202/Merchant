package com.iqianggou.android.merchantapp;

import android.app.Application;

import com.bugtags.library.Bugtags;
import com.facebook.stetho.Stetho;
import com.iqianggou.android.merchantapp.data.http.IUserApiService;
import com.iqianggou.android.merchantapp.ui.components.DaggerUserApiComponent;
import com.iqianggou.android.merchantapp.ui.components.UserApiComponent;
import com.iqianggou.android.merchantapp.ui.module.UserApiServiceModule;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016/9/17.
 */
public class MerApplication extends Application {

    @Inject
    IUserApiService mUserApiService;

    private static MerApplication INSTANCE;

    public static MerApplication getInstance(){
        return INSTANCE;
    }

    @Override
    public void onCreate(){
        super.onCreate();

        INSTANCE = this;

        initComponents();
    }

    public IUserApiService getUserApiService(){
        return mUserApiService;
    }

    //初始化其他组件
    private void initComponents(){
        Bugtags.start("66efc4c6bfc2ff877d2dcb90f1a2b4ae", this, Bugtags.BTGInvocationEventBubble);
        Stetho.initializeWithDefaults(this);
        DaggerUserApiComponent.builder().userApiServiceModule(new UserApiServiceModule()).build().inject(this);
    }
}
