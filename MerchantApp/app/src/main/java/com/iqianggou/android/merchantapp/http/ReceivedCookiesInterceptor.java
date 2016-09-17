package com.iqianggou.android.merchantapp.http;

import java.io.IOException;
import java.util.HashSet;
import java.util.prefs.Preferences;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/9/17.
 */
public class ReceivedCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }

            Preferences.getDefaultPreferences().edit()
                    .putStringSet(Preferences.PREF_COOKIES, cookies)
                    .apply();
        }

        return originalResponse;
    }
}
