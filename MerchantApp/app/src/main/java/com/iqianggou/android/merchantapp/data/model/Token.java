package com.iqianggou.android.merchantapp.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/10/5.
 */

public class Token {

    @SerializedName("token")
    private String mToken;

    public String getToken() {
        return mToken;
    }

    public void setToken(String mToken) {
        this.mToken = mToken;
    }

    @Override
    public String toString() {
        return "Token{" +
                "mToken='" + mToken + '\'' +
                '}';
    }
}
