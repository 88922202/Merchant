package com.iqianggou.android.merchantapp.data.http;

import com.iqianggou.android.merchantapp.data.model.Reply;
import com.iqianggou.android.merchantapp.data.model.User;

/**
 * Created by ubuntu on 16-9-18.
 */
public interface IUserApiService {

    void doLogin(String username, String password, IHttpCallback<Reply<User>> httpCallback, ILoadingDialog dialog);
}
