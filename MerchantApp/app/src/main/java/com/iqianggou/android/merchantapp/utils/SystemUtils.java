/*
 * Copyright (c) 2014. 代码版权归属上海多维度网络科技有限公司。
 */

package com.iqianggou.android.merchantapp.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.util.Log;


import java.util.List;


public class SystemUtils {

    public static int getPackageVersionCode(final Context pContext) {
        return SystemUtils.getPackageInfo(pContext).versionCode;
    }

    public static String getPackageVersionName(final Context pContext) {
        return SystemUtils.getPackageInfo(pContext).versionName;
    }

    public static String getPackageName(final Context pContext) {
        return pContext.getPackageName();
    }

    private static PackageInfo getPackageInfo(final Context pContext) {
        try {
            return pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), 0);
        } catch (final NameNotFoundException e) {
            return null;
        }
    }

    /**
     * @param pBuildVersionCode taken from {@link android.os.Build.VERSION_CODES}.
     */
    public static boolean isAndroidVersionOrLower(final int pBuildVersionCode) {
        return Build.VERSION.SDK_INT <= pBuildVersionCode;
    }

    /**
     * @param pBuildVersionCode taken from {@link android.os.Build.VERSION_CODES}.
     */
    public static boolean isAndroidVersionOrHigher(final int pBuildVersionCode) {
        return Build.VERSION.SDK_INT >= pBuildVersionCode;
    }

    /**
     * @param pBuildVersionCodeMin taken from {@link android.os.Build.VERSION_CODES}.
     * @param pBuildVersionCodeMax taken from {@link android.os.Build.VERSION_CODES}.
     */
    public static boolean isAndroidVersion(final int pBuildVersionCodeMin, final int pBuildVersionCodeMax) {
        return (Build.VERSION.SDK_INT >= pBuildVersionCodeMin) && (Build.VERSION.SDK_INT <= pBuildVersionCodeMax);
    }

    /**
     * 判断应用是否已经启动
     *
     * @param context     一个context
     * @param packageName 要判断应用的包名
     * @return boolean
     */
    public static boolean isAppAlive(Context context, String packageName) {
        ActivityManager activityManager =
                (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> processInfos
                = activityManager.getRunningAppProcesses();
        for (int i = 0; i < processInfos.size(); i++) {
            if (processInfos.get(i).processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInLauncher(Context context,Class<?> cls) {
        Intent intent = new Intent(context, cls);
        ComponentName cmpName = intent.resolveActivity(context.getPackageManager());
        if (cmpName != null) { // 说明系统中存在这个activity
            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> taskInfoList = am.getRunningTasks(10);
            for (ActivityManager.RunningTaskInfo taskInfo : taskInfoList) {
                if (taskInfo.baseActivity.equals(cmpName)) { // 说明它已经启动了
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 程序是否在前台运行
     *
     * @return
     */
    public static boolean isAppOnForeground(Context context) {
        // Returns a list of application processes that are running on the
        // device

        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = context.getApplicationContext().getPackageName();

        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null)
            return false;

        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }

        return false;
    }

}
