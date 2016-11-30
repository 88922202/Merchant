package com.iqianggou.android.merchantapp.ui.module;

import com.iqianggou.android.merchantapp.data.http.IUserApiService;
import com.iqianggou.android.merchantapp.data.http.asynchttp.UserApiService;

import dagger.Module;
import dagger.Provides;

/**
 * <h3></h3>
 * <p>
 * <p></p>
 */
@Module
public class UserApiServiceModule {

    @Provides
    IUserApiService provideUserApiService(){
        return new UserApiService();
    }
}
