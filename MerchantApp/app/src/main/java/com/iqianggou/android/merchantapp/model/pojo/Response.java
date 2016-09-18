package com.iqianggou.android.merchantapp.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ubuntu on 16-9-18.
 */
public class Response<T> {

    @SerializedName("status")
    private Status mStatus;

    @SerializedName("data")
    private T mData;

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "mStatus=" + mStatus +
                ", mData=" + mData +
                '}';
    }
}
