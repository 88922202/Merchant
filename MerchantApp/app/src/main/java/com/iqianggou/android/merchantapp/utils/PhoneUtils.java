package com.iqianggou.android.merchantapp.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.iqianggou.android.merchantapp.MerApplication;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 获取手机信息工具类
 *
 * @author chuanchao
 */
public class PhoneUtils {


    public static final String SIM_YIDONG = "中国移动";
    public static final String SIM_LIANTONG = "中国联通";
    public static final String SIM_DIANXIN = "中国电信";
    public static final String SIM_UNKNOW = "未知";

    /**
     * 程序是否在前台运行
     *
     * @return
     */
    public static boolean isAppOnForeground(Context context) {

        ActivityManager activityManager = (ActivityManager) context
                .getApplicationContext().getSystemService(
                        Context.ACTIVITY_SERVICE);
        String packageName = context.getApplicationContext().getPackageName();

        List<RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null)
            return false;

        for (RunningAppProcessInfo appProcess : appProcesses) {
            // The itemName of the process that this object is associated with.
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }

        return false;
    }


    /**
     * 设置 应用字体大小不跟随系统设置改变
     *
     * @param context
     */
    public static void initFontSize(Context context) {
        Resources res = context.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        config.fontScale = 1.0f;
        res.updateConfiguration(config, res.getDisplayMetrics());
    }


    /**
     * 获取安装包版本号
     *
     * @param pContext
     * @return
     */
    public static String getVersionName(Context pContext) {

        return SystemUtils.getPackageVersionName(pContext);
    }

    /**
     * 获取deviceId，作为udid使用
     *
     * @param pContext
     * @return
     */
    public static String getDeviceId(Context pContext) {


        return UuidHelper.getUuid(pContext);
//        return getTelephonyManager(pContext).getDeviceId();

    }

    /**
     * 读取sim卡
     *
     * @param pContext
     * @return
     */
    public static String getSimISO(Context pContext) {

        TelephonyManager telephonyManager = getTelephonyManager(pContext);
        if (telephonyManager.getSimState() == TelephonyManager.SIM_STATE_READY) {
            return getTelephonyManager(pContext).getSimCountryIso();
        }
        return "";
    }

    /**
     * 读取sim卡上的运营商信息
     *
     * @param pContext
     * @return
     */
    public static String getSimOperator(Context pContext) {
        TelephonyManager telephonyManager = getTelephonyManager(pContext);
        String operatorName = SIM_UNKNOW;

        if (telephonyManager.getSimState() == TelephonyManager.SIM_STATE_READY) {
            String operator = telephonyManager.getSimOperator();

            if (operator != null) {
                if (operator.equals("46000") || operator.equals("46002") || operator.equals("46007")) {
                    operatorName = SIM_YIDONG;
                } else if (operator.equals("46001")) {
                    operatorName = SIM_LIANTONG;
                } else if (operator.equals("46003")) {
                    operatorName = SIM_DIANXIN;
                }
            }
        }

        return operatorName;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getDeviceModel() {
        return android.os.Build.MODEL;

    }

    /**
     * 获取手机软件版本
     *
     * @param pContext
     * @return
     */
    public static String getOSVersion(Context pContext) {

        return android.os.Build.VERSION.RELEASE;

    }

    /**
     * 获取当前时间(格式 Y-m-d H:m:s)
     *
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    public static final String CHANNEL_KEY = "UMENG_CHANNEL";

    /**
     * 获取取到名称
     *
     * @param pContext
     * @return
     */
    public static String getChannelName(Context pContext) {

        String channelName = null;

        try {
            ApplicationInfo aInfo = pContext.getPackageManager()
                    .getApplicationInfo(pContext.getPackageName(),
                            PackageManager.GET_META_DATA);
            Object value = aInfo.metaData.get(CHANNEL_KEY);
            if (value != null) {
                channelName = value.toString();
            }

        } catch (NameNotFoundException e) {
        }

        return channelName;

    }

    public static TelephonyManager getTelephonyManager(Context pContext) {
        return (TelephonyManager) pContext
                .getSystemService(Context.TELEPHONY_SERVICE);
    }

    /**
     * 获取sim卡里面的手机号，不一定读取的到
     *
     * @param context
     * @return
     */
    public static String getPhoneNumber(Context context) {
        return getTelephonyManager(context).getLine1Number();
    }


    /**
     * 获取时间戳
     *
     * @return
     */
    public static String getTimeStamp() {

        Long tsTime = System.currentTimeMillis() / 1000;

        return tsTime.toString();

    }

    /**
     * 获取sdcard路径
     *
     * @return
     */
    public static String getSDCardPath() {

        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED);   //判断sd卡是否存在
        if (sdCardExist) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }

        return null;
    }


    /**
     * 得到32位唯一随机数
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().trim().replace("-", "");
    }

    /**
     * 得到0-9999的随机谁
     *
     * @return
     */
    public static int getRandom() {
        return (int) (Math.random() * 10000);
    }


    /**
     * 获取mac地址
     *
     * @param pContext
     * @return
     */
    public static String getMacAddress(Context pContext) {

        WifiManager wifiManager = (WifiManager) pContext.getSystemService(Context.WIFI_SERVICE);

        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (wifiInfo == null) {
            return "";
        }
        String macAddress = wifiInfo.getMacAddress();
        if (TextUtils.isEmpty(macAddress)) {
            return "";
        }

        return macAddress;

    }

    /**
     * 判断桌面是否已添加快捷方式
     *
     * @param cx
     * @return
     */
    public static boolean hasShortcut(Context cx) {
        boolean result = false;
        // 获取当前应用名称
        String title = null;
        try {
            final PackageManager pm = cx.getPackageManager();
            title = pm.getApplicationLabel(
                    pm.getApplicationInfo(cx.getPackageName(),
                            PackageManager.GET_META_DATA)).toString();
        } catch (Exception e) {
        }

        final String uriStr;
        if (android.os.Build.VERSION.SDK_INT < 8) {
            uriStr = "content://com.android.launcher.settings/favorites?notify=true";
        } else {
            uriStr = "content://com.android.launcher2.settings/favorites?notify=true";
        }
        final Uri CONTENT_URI = Uri.parse(uriStr);
        final Cursor c = cx.getContentResolver().query(CONTENT_URI, null,
                "title=?", new String[]{title}, null);
        if (c != null && c.getCount() > 0) {
            result = true;
        }
        return result;
    }

    /**
     * 判断app是否安装
     *
     * @param context     context对象
     * @param packageName 包名，例"com.iqianggou.android"
     * @return 已安装true，未安装false
     */
    public static boolean isInstalled(Context context, String packageName) {
        final PackageManager packageManager = context.getPackageManager();//获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);//获取所有已安装程序的包信息
        List<String> pName = new ArrayList<String>();//用于存储所有已安装程序的包名
        //从pinfo中将包名字逐一取出，压入pName list中
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                pName.add(pn);
            }
        }
        return pName.contains(packageName);//判断pName中是否有目标程序的包名，有TRUE，没有FALSE
    }


    public static final String PRE_TAG_PHONE_WIDTH = "preTagphoneWidth";
    public static final String PRE_TAG_PHONE_HEIGHT = "preTagphoneHeight";

    /**
     * 获取手机宽度
     *
     * @return
     */
    public static int getPhoneWidth() {

        int width = PreferenceUtils.getPrefInt(PRE_TAG_PHONE_WIDTH, 0);
        if (width == 0) {
            WindowManager windowManager = (WindowManager) MerApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
            width = windowManager.getDefaultDisplay().getWidth();
            PreferenceUtils.setPrefInt(PRE_TAG_PHONE_WIDTH, width);
        }

        return width;
    }


    /**
     * 获取手机宽度
     *
     * @return
     */
    public static int getPhoneHeight() {
        int height = PreferenceUtils.getPrefInt(PRE_TAG_PHONE_HEIGHT, 0);
        if (height == 0) {
            WindowManager windowManager = (WindowManager) MerApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
            height = windowManager.getDefaultDisplay().getHeight();
            PreferenceUtils.setPrefInt(PRE_TAG_PHONE_HEIGHT, height);
        }

        return height;
    }

    /**
     * 获取手机屏幕密度
     *
     * @return 屏幕密度
     */
    public static double getDensity(){
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) MerApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);

        return dm.density;      // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
    }

    /**
     * 检测网络连接
     *
     * @return true 有网络;
     */
    public static boolean checkNetWork() {

        ConnectivityManager connectivityManager = (ConnectivityManager) MerApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        return (wifiInfo != null && wifiInfo.isConnected()) || (mobileInfo != null && mobileInfo.isConnected());

    }


    /**
     * 拨打电话
     *
     * @param context
     */
    public static void makePhoneCall(Context context, String phoneNumber) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_TELEPHONY)) {
            Intent intentPhone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +
                    phoneNumber));
            context.startActivity(intentPhone);
        } else {
            //ToastUtils.makeToast(ResourceUtils.getResString(R.string.phone_call_not_support));
        }
    }


}
