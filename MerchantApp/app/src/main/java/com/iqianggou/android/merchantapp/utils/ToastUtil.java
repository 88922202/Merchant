package com.iqianggou.android.merchantapp.utils;

import android.widget.Toast;

import com.iqianggou.android.merchantapp.MerApplication;

/**
 * <h3></h3>
 * <p/>
 * <p></p>
 */
public class ToastUtil {

    public static void showShortText(String text){
        Toast.makeText(MerApplication.getInstance(), text, Toast.LENGTH_SHORT).show();
    }
}
