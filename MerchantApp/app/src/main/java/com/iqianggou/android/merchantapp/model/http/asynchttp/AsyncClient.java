package com.iqianggou.android.merchantapp.model.http.asynchttp;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.iqianggou.android.merchantapp.MerchantApplication;
import com.iqianggou.android.merchantapp.model.http.APIBase;
import com.iqianggou.android.merchantapp.model.http.ILoadingDialog;
import com.iqianggou.android.merchantapp.model.http.IUserApiService;
import com.iqianggou.android.merchantapp.model.http.IHttpCallback;
import com.iqianggou.android.merchantapp.model.local.GsonClient;
import com.iqianggou.android.merchantapp.model.local.PreferenceClient;
import com.iqianggou.android.merchantapp.model.pojo.Reply;
import com.iqianggou.android.merchantapp.model.pojo.User;
import com.iqianggou.android.merchantapp.utils.PhoneUtils;
import com.iqianggou.android.merchantapp.utils.UuidHelper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;

/**
 * Created by ubuntu on 16-9-18.
 */
public class AsyncClient implements IUserApiService {

    private static AsyncClient INSTANCE;

    private AsyncHttpClient mHttpClient;

    synchronized public static AsyncClient getInstance(){
        if (INSTANCE == null){
            INSTANCE = new AsyncClient();
        }

        return INSTANCE;
    }

    @Override
    public void doLogin(String username, String password, final IHttpCallback<Reply<User>> callBack, final ILoadingDialog dialog){
        RequestParams params = new RequestParams();
        params.put("account", username);
        params.put("password", password);

        mHttpClient.post(APIBase.URL + "brandadmin/login", params, new AsyncHttpResponseHandler() {

            @Override
            public void onStart(){
                dialog.showLoadingDialog();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String data = new String(responseBody);
                Reply<User> reply = GsonClient.getGson().fromJson(data, new TypeToken<Reply<User>>() {
                }.getType());

                callBack.onSuccess(reply);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                callBack.onFailure(statusCode, error.getMessage());
            }

            @Override
            public void onFinish(){
                dialog.cancelLoadingDialog();
            }

        });

    }

    private AsyncClient(){
        mHttpClient = new AsyncHttpClient();
        mHttpClient.addHeader("version", PhoneUtils.getVersionName(MerchantApplication.getInstance()));
        mHttpClient.addHeader("platform", "2");
        mHttpClient.addHeader("Accept", "application/json");
        mHttpClient.addHeader("Auth-Token", PreferenceClient.getToken());
        mHttpClient.addHeader("zoneid", PreferenceClient.getZoneId());
        mHttpClient.addHeader("width", String.valueOf(PhoneUtils.getPhoneWidth()));
        mHttpClient.addHeader("height", String.valueOf(PhoneUtils.getPhoneHeight()));
        mHttpClient.addHeader("udid", UuidHelper.getUuid(MerchantApplication.getInstance()));

        mHttpClient.setUserAgent(getUserAgent());

        PersistentCookieStore cookieStore = new PersistentCookieStore(MerchantApplication.getInstance());
        mHttpClient.setCookieStore(cookieStore);
    }

    private String getUserAgent(){
        Context context = MerchantApplication.getInstance();
        String version = PhoneUtils.getVersionName(context);
        String osVersion = PhoneUtils.getOSVersion(context);
        String deviceModel = PhoneUtils.getDeviceModel();
        String density = String.valueOf(PhoneUtils.getDensity());
        return "iqgSH/" + version + " (" + deviceModel + ";Android " + osVersion + ";Scale/" + density + ")";
    }

}
