package com.iqianggou.android.merchantapp.data.http.retrofit;

import com.iqianggou.android.merchantapp.data.http.IHttpCallback;
import com.iqianggou.android.merchantapp.data.http.ILoadingDialog;
import com.iqianggou.android.merchantapp.data.http.api.Login;
import com.iqianggou.android.merchantapp.data.http.api.GetMerchants;
import com.iqianggou.android.merchantapp.data.http.api.Register;
import com.iqianggou.android.merchantapp.data.model.Merchant;
import com.iqianggou.android.merchantapp.data.model.User;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ubuntu on 16-9-20.
 */
public class UserApiService implements com.iqianggou.android.merchantapp.data.http.IUserApiService {

    @Override
    public void doLogin(String username, String password, IHttpCallback<User> httpCallback, ILoadingDialog dialog) {
        Login login = RetrofitClient.getClient().create(Login.class);
        login.doLogin(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SubscriberCallback<>(httpCallback, dialog));
    }

    @Override
    public void getMerchants(IHttpCallback<List<Merchant>> httpCallback, ILoadingDialog dialog) {
        GetMerchants getMerchants = RetrofitClient.getClient().create(GetMerchants.class);
        getMerchants.getMerchants()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SubscriberCallback<>(httpCallback, dialog));
    }

    @Override
    public void registerAndLogin(String mobile, String authCode, IHttpCallback<User> httpCallback, ILoadingDialog dialog) {
        Register register = RetrofitClient.getClient().create(Register.class);
        register.registerAndLogin(mobile, authCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SubscriberCallback<>(httpCallback, dialog));
    }

    @Override
    public void bind(String mobile, String authCode, IHttpCallback<User> httpCallback, ILoadingDialog dialog) {

    }


}
