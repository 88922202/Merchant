package com.iqianggou.android.merchantapp.model.local;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.iqianggou.android.merchantapp.MerchantApplication;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/17.
 */
public class PreferenceClient {

    private static final String COOKIES = "cookies";
    private static final String TOKEN = "token";
    private static final String ZONE_ID = "zone_id";

    private static SharedPreferences PREFERENCE = getPreferences();

    public static Set<String> getCookies(){
        return PREFERENCE.getStringSet(COOKIES, new HashSet<String>());
    }

    public static void setCookies(Set<String> cookies){
        PREFERENCE.edit().putStringSet(COOKIES, cookies).apply();
    }

    public static String getToken(){
        return PREFERENCE.getString(TOKEN, "");
    }

    public static void setToken(String token){
        PREFERENCE.edit().putString(TOKEN, token).apply();
    }

    public static String getZoneId(){
        return PREFERENCE.getString(ZONE_ID, "");
    }

    public static void setZoneId(String id){
        PREFERENCE.edit().putString(ZONE_ID, id).apply();
    }

    private static SharedPreferences getPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(MerchantApplication.getInstance());
    }
}
