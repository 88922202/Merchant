/*
 * Copyright (c) 2014. 代码版权归属上海多维度网络科技有限公司。
 */

package com.iqianggou.android.merchantapp.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import com.iqianggou.android.merchantapp.MerApplication;

@SuppressWarnings("unused")
public class PreferenceUtils {

    private static final String PRE_NAME = "iQiangGouAndroidPre";

    public static String getPrefString(final String key, final String defaultValue) {
        SharedPreferences settings = getPreference();
        return settings.getString(key, defaultValue);
    }

    public static void setPrefString(final String key, final String value) {
        SharedPreferences settings = getPreference();
        settings.edit().putString(key, value).commit();
    }

    public static boolean getPrefBoolean(final String key, final boolean defaultValue) {
        SharedPreferences settings = getPreference();
        return settings.getBoolean(key, defaultValue);
    }

    public static boolean hasKey(final String key) {
        return getPreference().contains(key);
    }

    public static void setPrefBoolean(final String key, final boolean value) {
        SharedPreferences settings = getPreference();
        settings.edit().putBoolean(key, value).commit();
    }

    public static void setPrefInt(final String key, final int value) {
        SharedPreferences settings = getPreference();
        settings.edit().putInt(key, value).commit();
    }

    public static void increasePrefInt(final String key) {
        SharedPreferences settings = getPreference();
        increasePrefInt(settings, key);
    }

    public static void increasePrefInt(final SharedPreferences sp, final String key) {
        int v = sp.getInt(key, 0) + 1;
        sp.edit().putInt(key, v).commit();
    }

    public static void increasePrefInt(final SharedPreferences sp, final String key,
                                       final int increment) {
        int v = sp.getInt(key, 0) + increment;
        sp.edit().putInt(key, v).commit();
    }

    public static int getPrefInt(final String key, final int defaultValue) {
        SharedPreferences settings = getPreference();
        return settings.getInt(key, defaultValue);
    }

    public static void setPrefFloat(final String key, final float value) {
        SharedPreferences settings = getPreference();
        settings.edit().putFloat(key, value).commit();
    }

    public static float getPrefFloat(final String key, final float defaultValue) {
        SharedPreferences settings = getPreference();
        return settings.getFloat(key, defaultValue);
    }

    public static void setPrefDouble(final String key, final double value) {
        SharedPreferences settings = getPreference();
        settings.edit().putString(key, String.valueOf(value)).commit();
    }

    public static double getPrefDouble(final String key, final double defaultValue) {
        SharedPreferences settings = getPreference();
        String valueString = settings.getString(key, String.valueOf(defaultValue));
        return NumberUtils.parseDouble(valueString);
    }

    public static void setLong(final String key, final long value) {
        SharedPreferences settings = getPreference();
        settings.edit().putLong(key, value).commit();
    }

    public static long getLong(final String key, final long defaultValue) {
        SharedPreferences settings = getPreference();
        return settings.getLong(key, defaultValue);
    }

    public static void increasePrefLong(final SharedPreferences sp, final String key, final long increment) {
        long v = sp.getLong(key, 0) + increment;
        sp.edit().putLong(key, v).commit();
    }

    public static void removePreference(final String key) {
        SharedPreferences prefs = getPreference();
        prefs.edit().remove(key).commit();
    }

    public static void clearPreference(final SharedPreferences p) {
        Editor editor = p.edit();
        editor.clear();
        editor.commit();
    }


    private static SharedPreferences getPreference() {
        return PreferenceManager.getDefaultSharedPreferences(MerApplication.getInstance().getApplicationContext());
    }
}
