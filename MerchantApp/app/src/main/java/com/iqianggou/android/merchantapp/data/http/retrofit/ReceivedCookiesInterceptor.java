package com.iqianggou.android.merchantapp.data.http.retrofit;

import com.iqianggou.android.merchantapp.data.local.PreferenceClient;
import com.iqianggou.android.merchantapp.utils.LogUtils;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/9/17.
 */
public class ReceivedCookiesInterceptor implements Interceptor {

    private static final String TAG = ReceivedCookiesInterceptor.class.getName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
                LogUtils.d("received header." + header);
            }

            PreferenceClient.setCookies(cookies);
        }

        return originalResponse;
    }
}
