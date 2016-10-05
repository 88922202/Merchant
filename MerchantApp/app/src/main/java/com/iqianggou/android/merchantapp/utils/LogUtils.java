package com.iqianggou.android.merchantapp.utils;

import android.util.Log;

/**
 * Created by ubuntu on 16-9-20.
 */
public class LogUtils {

    private static final String TAG = "Merchant";
    private static final String SEPARATOR = ",";
    private static boolean isDebug = true;

    //下面是默认TAG
    public static void v(String msg){
        if (isDebug){
            StackTraceElement stack = Thread.currentThread().getStackTrace()[3];
            Log.v(TAG, msg + getExtraInfo(stack));
        }
    }

    public static void d(String msg){
        if (isDebug){
            StackTraceElement stack = Thread.currentThread().getStackTrace()[3];
            Log.d(TAG, msg + getExtraInfo(stack));
        }
    }

    public static void i(String msg){
        if (isDebug){
            StackTraceElement stack = Thread.currentThread().getStackTrace()[3];
            Log.i(TAG, msg + getExtraInfo(stack));
        }
    }

    public static void w(String msg){
        if (isDebug){
            StackTraceElement stack = Thread.currentThread().getStackTrace()[3];
            Log.w(TAG, msg + getExtraInfo(stack));
        }
    }

    public static void e(String msg){
        if (isDebug){
            StackTraceElement stack = Thread.currentThread().getStackTrace()[3];
            Log.e(TAG, msg + getExtraInfo(stack));
        }
    }

    //下面是自定义TAG
    public static void v(String tag, String msg){
        if (isDebug){
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg){
        if (isDebug){
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg){
        if (isDebug){
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg){
        if (isDebug){
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg){
        if (isDebug){
            Log.e(tag, msg);
        }
    }

    private static String getExtraInfo(StackTraceElement stack){
        StringBuilder extraInfo = new StringBuilder();
        String className = stack.getClassName();
        String methodName = stack.getMethodName();
        int line = stack.getLineNumber();
        extraInfo.append("[");
        extraInfo.append("class = " + className).append(SEPARATOR);
        extraInfo.append("method = " + methodName).append(SEPARATOR);
        extraInfo.append("line = " + line);
        extraInfo.append("]");

        return extraInfo.toString();
    }
}
