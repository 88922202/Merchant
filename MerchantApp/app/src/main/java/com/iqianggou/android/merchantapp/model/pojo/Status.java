package com.iqianggou.android.merchantapp.model.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ubuntu on 16-9-18.
 */
public class Status {

    @SerializedName("code")
    private int mCode;

    @SerializedName("message")
    private String mMessage;

    @SerializedName("alert")
    private String mAlert;

    @SerializedName("server_time")
    private long mServerTime;

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        mCode = code;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getAlert() {
        return mAlert;
    }

    public void setAlert(String alert) {
        mAlert = alert;
    }

    public long getServerTime() {
        return mServerTime;
    }

    public void setServerTime(long serverTime) {
        mServerTime = serverTime;
    }

    @Override
    public String toString() {
        return "Status{" +
                "mCode=" + mCode +
                ", mMessage='" + mMessage + '\'' +
                ", mAlert='" + mAlert + '\'' +
                ", mServerTime=" + mServerTime +
                '}';
    }
}
