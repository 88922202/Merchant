package com.iqianggou.android.merchantapp.model.http;

import com.iqianggou.android.merchantapp.model.pojo.Reply;
import com.iqianggou.android.merchantapp.model.pojo.User;

/**
 * Created by ubuntu on 16-9-18.
 */
public interface IUserApiService {

    void doLogin(String username, String password, IHttpCallback<Reply<User>> httpCallback, ILoadingDialog dialog);
}
