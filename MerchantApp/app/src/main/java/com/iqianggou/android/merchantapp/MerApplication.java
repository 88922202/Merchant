package com.iqianggou.android.merchantapp;

import android.app.Application;

import com.bugtags.library.Bugtags;
import com.facebook.stetho.Stetho;

/**
 * Created by Administrator on 2016/9/17.
 */
public class MerApplication extends Application {

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

    //初始化其他组件
    private void initComponents(){
        Bugtags.start("66efc4c6bfc2ff877d2dcb90f1a2b4ae", this, Bugtags.BTGInvocationEventBubble);
        Stetho.initializeWithDefaults(this);
    }
}
