package com.iqianggou.android.merchantapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ubuntu on 16-9-18.
 */
public class ListReply<T> {

    @SerializedName("status")
    private Status mStatus;

    @SerializedName("data")
    private List<T> mDatas;

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

    public List<T> getDatas() {
        return mDatas;
    }

    public void setDatas(List<T> datas) {
        mDatas = datas;
    }

    @Override
    public String toString() {
        return "ListReply{" +
                "mStatus=" + mStatus +
                ", mDatas=" + mDatas +
                '}';
    }
}
