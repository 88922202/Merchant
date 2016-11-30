package com.iqianggou.android.merchantapp.ui.components;

import com.iqianggou.android.merchantapp.MerApplication;
import com.iqianggou.android.merchantapp.ui.module.UserApiServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * <h3></h3>
 * <p>
 * <p></p>
 */
@Singleton
@Component(modules = UserApiServiceModule.class)
public interface UserApiComponent {
    void inject(MerApplication application);
}
