package com.iqianggou.android.merchantapp;

import android.app.Application;

import com.bugtags.library.Bugtags;

/**
 * Created by Administrator on 2016/9/17.
 */
public class MerchantApplication extends Application {

    private static MerchantApplication INSTANCE;

    public static MerchantApplication getInstance(){
        return INSTANCE;
    }

    @Override
    public void onCreate(){
        super.onCreate();

        INSTANCE = this;
        Bugtags.start("66efc4c6bfc2ff877d2dcb90f1a2b4ae", this, Bugtags.BTGInvocationEventBubble);
    }
}
