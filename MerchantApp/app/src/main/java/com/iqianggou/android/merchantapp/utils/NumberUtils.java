/*
 * Copyright (c) 2014. 代码版权归属上海多维度网络科技有限公司。
 */

package com.iqianggou.android.merchantapp.utils;


/**
 * Created by admin on 14/10/27.
 */
public class NumberUtils {

    public static Integer parseInteger(String integerString) {
        try {
            return Integer.valueOf(integerString);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    public static Double parseDouble(String doubleString) {
        try {
            return Double.valueOf(doubleString);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    public static Long parseLong(String longString) {
        try {
            return Long.valueOf(longString);
        } catch (NumberFormatException nfe) {
            //此方法目前只用在播放广告这个非关键功能中。因此返回0L，避免返回null导致崩溃
            return 0L;
        }
    }

    public static String intToTwoDigitsString(Integer i) {
        if (i < 10) {
            return "0" + i;
        } else {
            return i.toString();
        }
    }

}
