package com.iqianggou.android.merchantapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/10/5.
 */

public class Merchant {
    @SerializedName("name")
    public String mCityName;

    @SerializedName("branches")
    public List<Merchant> mMerchants;

    public String getCityName() {
        return mCityName;
    }

    public void setCityName(String mCityName) {
        this.mCityName = mCityName;
    }

    public List<Merchant> getMerchants() {
        return mMerchants;
    }

    public void setMerchants(List<Merchant> mMerchants) {
        this.mMerchants = mMerchants;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "mCityName='" + mCityName + '\'' +
                ", mMerchants=" + mMerchants +
                '}';
    }
}
