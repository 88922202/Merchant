package com.iqianggou.android.merchantapp.model.http.retrofit;

import com.iqianggou.android.merchantapp.model.http.IHttpCallback;
import com.iqianggou.android.merchantapp.model.http.ILoadingDialog;
import com.iqianggou.android.merchantapp.model.http.IUserApiService;
import com.iqianggou.android.merchantapp.model.http.api.Login;
import com.iqianggou.android.merchantapp.model.pojo.Reply;
import com.iqianggou.android.merchantapp.model.pojo.User;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ubuntu on 16-9-20.
 */
public class UserApiService implements IUserApiService {

    @Override
    public void doLogin(String username, String password, IHttpCallback<Reply<User>> httpCallback, ILoadingDialog dialog) {
        Login login = RetrofitClient.getClient().create(Login.class);
        login.doLogin(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SubscriberCallback<>(httpCallback, dialog));
    }
}
