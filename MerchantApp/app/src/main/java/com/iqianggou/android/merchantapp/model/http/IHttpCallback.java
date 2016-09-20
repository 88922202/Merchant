package com.iqianggou.android.merchantapp.model.http;

/**
 * Created by ubuntu on 16-9-18.
 */
public interface IHttpCallback<T> {

    void onSuccess(T data);

    void onFailure(int errorCode, String message);
}
