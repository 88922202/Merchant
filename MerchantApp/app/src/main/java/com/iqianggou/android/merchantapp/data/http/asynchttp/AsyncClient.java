package com.iqianggou.android.merchantapp.data.http.asynchttp;

import android.content.Context;

import com.iqianggou.android.merchantapp.MerApplication;
import com.iqianggou.android.merchantapp.data.local.PreferenceClient;
import com.iqianggou.android.merchantapp.utils.PhoneUtils;
import com.iqianggou.android.merchantapp.utils.UuidHelper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.PersistentCookieStore;

/**
 * Created by ubuntu on 16-9-18.
 */
class AsyncClient {

    private static AsyncHttpClient CLIENT = initAsyncHttpClient();

    static AsyncHttpClient getClient(){
        return CLIENT;
    }

    private AsyncClient(){

    }

    private static AsyncHttpClient initAsyncHttpClient(){
        CLIENT = new AsyncHttpClient();
        CLIENT.addHeader("version", PhoneUtils.getVersionName(MerApplication.getInstance()));
        CLIENT.addHeader("platform", "2");
        CLIENT.addHeader("Accept", "application/json");
        CLIENT.addHeader("Auth-Token", PreferenceClient.getToken());
        CLIENT.addHeader("zoneid", PreferenceClient.getZoneId());
        CLIENT.addHeader("width", String.valueOf(PhoneUtils.getPhoneWidth()));
        CLIENT.addHeader("height", String.valueOf(PhoneUtils.getPhoneHeight()));
        CLIENT.addHeader("udid", UuidHelper.getUuid(MerApplication.getInstance()));

        CLIENT.setUserAgent(getUserAgent());

        PersistentCookieStore cookieStore = new PersistentCookieStore(MerApplication.getInstance());
        CLIENT.setCookieStore(cookieStore);

        return CLIENT;
    }

    private static String getUserAgent(){
        Context context = MerApplication.getInstance();
        String version = PhoneUtils.getVersionName(context);
        String osVersion = PhoneUtils.getOSVersion(context);
        String deviceModel = PhoneUtils.getDeviceModel();
        String density = String.valueOf(PhoneUtils.getDensity());
        return "iqgSH/" + version + " (" + deviceModel + ";Android " + osVersion + ";Scale/" + density + ")";
    }

}
