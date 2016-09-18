package com.iqianggou.android.merchantapp.http.asynchttp;

import android.content.Context;

import com.iqianggou.android.merchantapp.MerchantApplication;
import com.iqianggou.android.merchantapp.http.APIBase;
import com.iqianggou.android.merchantapp.local.PreferenceClient;
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
public class AsyncClient {

    private static AsyncClient INSTANCE;

    private AsyncHttpClient mHttpClient;

    synchronized public static AsyncClient getInstance(){
        if (INSTANCE == null){
            INSTANCE = new AsyncClient();
        }

        return INSTANCE;
    }

    public void doLogin(String username, String password){
        RequestParams params = new RequestParams();
        params.put("account", username);
        params.put("password", password);

        mHttpClient.post(APIBase.URL + "brandadmin/login", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

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
