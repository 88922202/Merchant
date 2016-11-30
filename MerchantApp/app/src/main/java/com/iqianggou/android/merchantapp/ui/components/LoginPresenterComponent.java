package com.iqianggou.android.merchantapp.ui.components;

import com.iqianggou.android.merchantapp.ui.activity.LoginActivity;
import com.iqianggou.android.merchantapp.ui.module.LoginActivityModule;

import dagger.Component;

/**
 * <h3></h3>
 * <p/>
 * <p></p>
 */
@Component(modules = LoginActivityModule.class)
public interface LoginPresenterComponent {
    void inject(LoginActivity activity);
}
