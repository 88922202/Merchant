package com.iqianggou.android.merchantapp.data.http.retrofit;

import com.iqianggou.android.merchantapp.data.local.PreferenceClient;
import com.iqianggou.android.merchantapp.utils.LogUtils;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/9/17.
 */
public class AddCookiesInterceptor implements Interceptor {

    private static final String TAG = AddCookiesInterceptor.class.getName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> preferences = (HashSet) PreferenceClient.getCookies();
        for (String cookie : preferences) {
            builder.addHeader("Cookie", cookie);
            LogUtils.d("Adding Header. " + cookie);
        }

        return chain.proceed(builder.build());
    }
}
