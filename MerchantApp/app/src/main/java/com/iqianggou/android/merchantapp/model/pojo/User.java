package com.iqianggou.android.merchantapp.model.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/9/17.
 */
public class User {

    @SerializedName("id")
    private int mId;

    @SerializedName("brand_id")
    private int mBrandId;

    @SerializedName("name")
    private String mName;

    @SerializedName("brand_name")
    private String mBrandName;

    @SerializedName("logo")
    private String mLogo;

    @SerializedName("user_id")
    private int mUserId;

    @SerializedName("username")
    private String mUserName;

    @SerializedName("bind_mobile")
    private String mMobile;

    @SerializedName("share_code")
    private String mShareCode;

    @SerializedName("openim_account")
    private String mOpenImAccount;

    @SerializedName("token_available")
    private boolean isTokenAvailable;

    @SerializedName("vendor")
    private boolean isVendor;

    @SerializedName("vendor_verified")
    private boolean isVendorVerified;

    @SerializedName("is_brand")
    private boolean isBrand;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getBrandId() {
        return mBrandId;
    }

    public void setBrandId(int brandId) {
        mBrandId = brandId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getBrandName() {
        return mBrandName;
    }

    public void setBrandName(String brandName) {
        mBrandName = brandName;
    }

    public String getLogo() {
        return mLogo;
    }

    public void setLogo(String logo) {
        mLogo = logo;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getMobile() {
        return mMobile;
    }

    public void setMobile(String mobile) {
        mMobile = mobile;
    }

    public String getShareCode() {
        return mShareCode;
    }

    public void setShareCode(String shareCode) {
        mShareCode = shareCode;
    }

    public String getOpenImAccount() {
        return mOpenImAccount;
    }

    public void setOpenImAccount(String openImAccount) {
        mOpenImAccount = openImAccount;
    }

    public boolean isTokenAvailable() {
        return isTokenAvailable;
    }

    public void setIsTokenAvailable(boolean isTokenAvailable) {
        this.isTokenAvailable = isTokenAvailable;
    }

    public boolean isVendor() {
        return isVendor;
    }

    public void setIsVendor(boolean isVendor) {
        this.isVendor = isVendor;
    }

    public boolean isVendorVerified() {
        return isVendorVerified;
    }

    public void setIsVendorVerified(boolean isVendorVerified) {
        this.isVendorVerified = isVendorVerified;
    }

    public boolean isBrand() {
        return isBrand;
    }

    public void setIsBrand(boolean isBrand) {
        this.isBrand = isBrand;
    }

    @Override
    public String toString() {
        return "User{" +
                "mId=" + mId +
                ", mBrandId=" + mBrandId +
                ", mName='" + mName + '\'' +
                ", mBrandName='" + mBrandName + '\'' +
                ", mLogo='" + mLogo + '\'' +
                ", mUserId=" + mUserId +
                ", mUserName='" + mUserName + '\'' +
                ", mMobile='" + mMobile + '\'' +
                ", mShareCode='" + mShareCode + '\'' +
                ", mOpenImAccount='" + mOpenImAccount + '\'' +
                ", isTokenAvailable=" + isTokenAvailable +
                ", isVendor=" + isVendor +
                ", isVendorVerified=" + isVendorVerified +
                ", isBrand=" + isBrand +
                '}';
    }
}
