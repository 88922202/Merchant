package com.iqianggou.android.merchantapp.data.http.retrofit;

import android.content.Context;

import com.iqianggou.android.merchantapp.MerchantApplication;
import com.iqianggou.android.merchantapp.data.http.APIBase;
import com.iqianggou.android.merchantapp.data.local.PreferenceClient;
import com.iqianggou.android.merchantapp.utils.PhoneUtils;
import com.iqianggou.android.merchantapp.utils.UuidHelper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/9/17.
 */
public class RetrofitClient {

    private static RetrofitClient INSTANCE;
    private static Retrofit mRetrofit;

    synchronized public static Retrofit getClient(){
        if (INSTANCE == null){
            INSTANCE = new RetrofitClient();
        }

        return mRetrofit;
    }

    private RetrofitClient(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(APIBase.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(genericClient())
                .build();
    }

    private OkHttpClient genericClient(){
        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("version", PhoneUtils.getVersionName(MerchantApplication.getInstance()))
                                .addHeader("platform", "2")
                                .addHeader("Accept", "application/json")
                                .addHeader("Auth-Token", PreferenceClient.getToken())
                                .addHeader("zoneid", PreferenceClient.getZoneId())
                                .addHeader("width", String.valueOf(PhoneUtils.getPhoneWidth()))
                                .addHeader("height", String.valueOf(PhoneUtils.getPhoneHeight()))
                                .addHeader("udid", UuidHelper.getUuid(MerchantApplication.getInstance()))
                                .addHeader("User-Agent", getUserAgent())
                                .build();
                        return chain.proceed(request);
                    }
                })
                .addInterceptor(new AddCookiesInterceptor())
                .addInterceptor(new ReceivedCookiesInterceptor())
                .build();
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
