package com.iqianggou.android.merchantapp.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ubuntu on 16-9-18.
 */
public class Reply<T> {

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
        return "Reply{" +
                "mStatus=" + mStatus +
                ", mData=" + mData +
                '}';
    }
}
