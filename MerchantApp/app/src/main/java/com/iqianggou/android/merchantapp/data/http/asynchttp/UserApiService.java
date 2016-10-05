package com.iqianggou.android.merchantapp.data.http.asynchttp;

import com.iqianggou.android.merchantapp.data.http.APIBase;
import com.iqianggou.android.merchantapp.data.http.IHttpCallback;
import com.iqianggou.android.merchantapp.data.http.ILoadingDialog;
import com.iqianggou.android.merchantapp.data.model.Merchant;
import com.iqianggou.android.merchantapp.data.model.User;
import com.loopj.android.http.RequestParams;

import java.util.List;

/**
 * Created by Administrator on 2016/10/5.
 */

public class UserApiService implements com.iqianggou.android.merchantapp.data.http.IUserApiService {

    @Override
    public void doLogin(String username, String password, final IHttpCallback<User> callBack, final ILoadingDialog dialog){
        RequestParams params = new RequestParams();
        params.put("account", username);
        params.put("password", password);

        AsyncClient.getClient().post(APIBase.URL + "brandadmin/login", params, new JsonResponseHandler<>(callBack, dialog));

    }

    @Override
    public void getMerchants(IHttpCallback<List<Merchant>> httpCallback, ILoadingDialog dialog) {

    }

    @Override
    public void registerAndLogin(String mobile, String authCode, IHttpCallback<User> httpCallback, ILoadingDialog dialog) {

    }

    @Override
    public void bind(String mobile, String authCode, IHttpCallback<User> httpCallback, ILoadingDialog dialog) {

    }

}
