package com.iqianggou.android.merchantapp.data.http.asynchttp;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.iqianggou.android.merchantapp.data.http.ErrorCode;
import com.iqianggou.android.merchantapp.data.http.IHttpCallback;
import com.iqianggou.android.merchantapp.data.http.ILoadingDialog;
import com.iqianggou.android.merchantapp.data.local.json.JsonClient;
import com.iqianggou.android.merchantapp.data.model.Reply;
import com.iqianggou.android.merchantapp.data.model.Status;
import com.iqianggou.android.merchantapp.utils.LogUtils;
import com.iqianggou.android.merchantapp.utils.PhoneUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

/**
 * Created by Administrator on 2016/10/5.
 */

public class JsonResponseHandler<T> extends AsyncHttpResponseHandler {

    private IHttpCallback<T> mHttpCallback;
    private ILoadingDialog mLoadingDialog;

    public JsonResponseHandler(IHttpCallback<T> httpCallback, ILoadingDialog loadingDialog){
        mHttpCallback = httpCallback;
        mLoadingDialog = loadingDialog;
    }

    @Override
    public void onStart(){
        super.onStart();

        if (!PhoneUtils.checkNetWork()){
            LogUtils.d("no network");
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
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        if (mHttpCallback == null) {
            return;
        }

        String data = new String(responseBody);
        LogUtils.d("response data:" + data);
        Reply<T> reply;
        try {
            reply = JsonClient.jsonToBean(data, new TypeToken<Reply<T>>() {
            }.getType());
        }catch (JsonSyntaxException e){
            LogUtils.e("Json parse error.");
            mHttpCallback.onFailure(ErrorCode.APP_JSON_PARSE_ERROR, "Json parse error.");
            return;
        }

        Status status = reply.getStatus();
        if (status == null){
            mHttpCallback.onFailure(ErrorCode.CODE_RESULT_EMPTY, "server status is empty");
        }else if (status.getCode() == ErrorCode.CODE_RESULT_EMPTY){
            mHttpCallback.onFailure(ErrorCode.CODE_RESULT_EMPTY, "server status is empty");
        }else if (status.getCode() >= ErrorCode.CODE_SUCCESS && status.getCode() <= ErrorCode.CODE_SUCCESS_LARGEST){
            mHttpCallback.onSuccess(reply.getData());
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

    }

    @Override
    public void onFinish(){
        super.onFinish();

        LogUtils.d("http request completed");
        if (mLoadingDialog != null) {
            mLoadingDialog.cancelLoadingDialog();
        }
    }
}
