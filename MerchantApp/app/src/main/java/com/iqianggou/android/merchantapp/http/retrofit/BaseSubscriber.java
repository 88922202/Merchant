package com.iqianggou.android.merchantapp.http.retrofit;

import rx.Subscriber;

/**
 * Created by ubuntu on 16-9-18.
 */
public class BaseSubscriber<T> extends Subscriber {

    private IHttpCallBack mHttpCallBack;

    @Override
    public void onStart(){
        mHttpCallBack.onStart();
    }

    @Override
    public void onCompleted() {
        mHttpCallBack.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        mHttpCallBack.onError(e);
    }

    @Override
    public void onNext(Object o) {
        mHttpCallBack.onNext(o);
    }
}
