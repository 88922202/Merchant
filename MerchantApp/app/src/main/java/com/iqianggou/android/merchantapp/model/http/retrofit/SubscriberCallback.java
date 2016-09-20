package com.iqianggou.android.merchantapp.model.http.retrofit;

import com.iqianggou.android.merchantapp.model.http.ErrorCode;
import com.iqianggou.android.merchantapp.model.http.IHttpCallback;
import com.iqianggou.android.merchantapp.model.http.ILoadingDialog;
import com.iqianggou.android.merchantapp.model.pojo.Reply;
import com.iqianggou.android.merchantapp.model.pojo.Status;
import com.iqianggou.android.merchantapp.utils.LogUtils;
import com.iqianggou.android.merchantapp.utils.PhoneUtils;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by ubuntu on 16-9-19.
 */
public class SubscriberCallback<T extends Reply> extends Subscriber<T> {

    private IHttpCallback<T> mHttpCallback;
    private ILoadingDialog mLoadingDialog;

    public SubscriberCallback(IHttpCallback<T> httpCallback, ILoadingDialog loadingDialog) {
        mHttpCallback = httpCallback;
        mLoadingDialog = loadingDialog;
    }

    @Override
    public void onStart(){
        super.onStart();

        if (!PhoneUtils.checkNetWork()){
            LogUtils.d("no network");
            if (!isUnsubscribed()){
                unsubscribe();
            }
            if (mHttpCallback != null){
                mHttpCallback.onFailure(ErrorCode.NO_NETWORK, "没有网络连接");
            }
        }else {
            LogUtils.d("http request start");
            if (mLoadingDialog != null) {
                mLoadingDialog.showLoadingDialog();
            }
        }
    }

    @Override
    public void onCompleted() {
        LogUtils.d("http request completed");
        if (mLoadingDialog != null) {
            mLoadingDialog.cancelLoadingDialog();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException){
            int code = ((HttpException) e).code();
            processError(code);
            LogUtils.e("error code = " + code + "," + e.getMessage());
        }else {
            LogUtils.e(e.getMessage());
        }
    }

    @Override
    public void onNext(T t) {
        if (mHttpCallback == null) {
            return;
        }

        Status status = t.getStatus();
        if (status == null){
            mHttpCallback.onFailure(ErrorCode.CODE_RESULT_EMPTY, "server status is empty");
        }else if (status.getCode() == ErrorCode.CODE_RESULT_EMPTY){
            mHttpCallback.onFailure(ErrorCode.CODE_RESULT_EMPTY, "server status is empty");
        }else if (status.getCode() >= ErrorCode.CODE_SUCCESS && status.getCode() <= ErrorCode.CODE_SUCCESS_LARGEST){
            mHttpCallback.onSuccess(t);
        }
    }

    private void processError(int errorCode){
        if (mHttpCallback == null) {
            return;
        }
        switch (errorCode){
            case 401:
                mHttpCallback.onFailure(401, "information");
                break;
            case 408:
                break;
            default:
                break;
        }
    }
}
