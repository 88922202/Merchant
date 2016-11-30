package com.iqianggou.android.merchantapp.ui.presenter;

import com.iqianggou.android.merchantapp.MerApplication;
import com.iqianggou.android.merchantapp.data.UserManager;
import com.iqianggou.android.merchantapp.data.http.IHttpCallback;
import com.iqianggou.android.merchantapp.data.http.ILoadingDialog;
import com.iqianggou.android.merchantapp.data.http.IUserApiService;
import com.iqianggou.android.merchantapp.data.http.asynchttp.UserApiService;
import com.iqianggou.android.merchantapp.data.model.User;
import com.iqianggou.android.merchantapp.utils.LogUtils;
import com.iqianggou.android.merchantapp.utils.ToastUtil;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016/10/5.
 */

public class LoginPresenter {

    @Inject IUserApiService mUserApiService;

    private ILoginView mLoginView;
    private ILoadingDialog mLoadingDialog;

    public LoginPresenter(ILoginView loginView, ILoadingDialog loadingDialog){
        mLoginView = loginView;
        mLoadingDialog = loadingDialog;
        mUserApiService = MerApplication.getInstance().getUserApiService();
    }

    public void doLogin(String username, String password){
        mUserApiService.doLogin(username, password, new IHttpCallback<User>() {
            @Override
            public void onSuccess(User data) {
                LogUtils.d(data.toString());
                UserManager.getInstance().setCurrentUser(data);
            }

            @Override
            public void onFailure(int errorCode, String message) {
                ToastUtil.showShortText(message);
            }
        }, mLoadingDialog);
    }
}
