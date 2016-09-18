package com.iqianggou.android.merchantapp.local;

import android.content.Context;
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

    private static SharedPreferences PREFERENCE = getPreferences();

    public static Set<String> getCookies(){
        return PREFERENCE.getStringSet(COOKIES, new HashSet<String>());
    }

    public static void setCookies(Set<String> cookies){
        PREFERENCE.edit().putStringSet(COOKIES, cookies).apply();
    }

    private static SharedPreferences getPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(MerchantApplication.getInstance());
    }
}
