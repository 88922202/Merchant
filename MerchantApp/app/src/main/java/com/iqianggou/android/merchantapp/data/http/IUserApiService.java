package com.iqianggou.android.merchantapp.data.http;

import com.iqianggou.android.merchantapp.data.model.Merchant;
import com.iqianggou.android.merchantapp.data.model.Reply;
import com.iqianggou.android.merchantapp.data.model.User;

import java.util.List;

/**
 * Created by ubuntu on 16-9-18.
 */
public interface IUserApiService {

    //用户登录
    void doLogin(String username, String password, IHttpCallback<User> httpCallback, ILoadingDialog dialog);

    void getMerchants(IHttpCallback<List<Merchant>> httpCallback, ILoadingDialog dialog);

    void registerAndLogin(String mobile, String authCode, IHttpCallback<User> httpCallback, ILoadingDialog dialog);

    void bind(String mobile, String authCode, IHttpCallback<User> httpCallback, ILoadingDialog dialog);
}
