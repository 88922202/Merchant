package com.iqianggou.android.merchantapp.model.http.retrofit;

import android.util.Log;

import com.iqianggou.android.merchantapp.model.local.PreferenceClient;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/9/17.
 */
public class AddCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> preferences = (HashSet) PreferenceClient.getCookies();
        for (String cookie : preferences) {
            builder.addHeader("Cookie", cookie);
            Log.d("OkHttp", "Adding Header: " + cookie);
        }

        return chain.proceed(builder.build());
    }
}
