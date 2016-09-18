package com.iqianggou.android.merchantapp.http.retrofit;

/**
 * Created by ubuntu on 16-9-18.
 */
public interface IHttpCallBack {

    void onStart();

    void onCompleted();

    void onError(Throwable e);

    void onNext(Object o);
}
