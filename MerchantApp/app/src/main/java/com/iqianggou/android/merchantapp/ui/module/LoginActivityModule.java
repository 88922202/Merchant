package com.iqianggou.android.merchantapp.ui.module;

import com.iqianggou.android.merchantapp.ui.activity.LoginActivity;
import com.iqianggou.android.merchantapp.ui.activity.MainActivity;
import com.iqianggou.android.merchantapp.ui.presenter.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * <h3></h3>
 * <p/>
 * <p></p>
 */
@Module
public class LoginActivityModule {

    private LoginActivity mActivity;

    public LoginActivityModule(LoginActivity activity){
        mActivity = activity;
    }

    @Provides
    LoginActivity provideLoginActivity(){
        return mActivity;
    }

    @Provides
    LoginPresenter provideLoginPresenter(){
        return new LoginPresenter(mActivity, mActivity);
    }
}
