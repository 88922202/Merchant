package com.iqianggou.android.merchantapp.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import org.apache.http.util.EncodingUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by admin on 14-10-9.
 */
public class UuidHelper {


    private static final String FILE_NAME = "IQG";
    private static final String UUID_FILE = ".security";

    private static String uuid;

    /**
     * 获取设备唯一ID
     * 参考：http://stackoverflow.com/questions/2785485/is-there-a-unique-android-device-id
     *
     * @param context
     * @return 唯一ID
     */
    public static String getUuid(Context context) {

        if (uuid == null) {
            uuid = getLogicUUID(context);
        }

        return uuid;
    }


    private static String getLogicUUID(Context context) {

        String uuid = null;

        File file = new File(PhoneUtils.getSDCardPath() + "/" + FILE_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        File saveFile = new File(file.getPath() + "/" + UUID_FILE);
        try {
            if (saveFile.exists()) {
                FileInputStream fileInputStream = new FileInputStream(saveFile);
                int length = fileInputStream.available();
                byte[] buffer = new byte[length];
                fileInputStream.read(buffer);
                uuid = EncodingUtils.getString(buffer, "UTF-8");
                fileInputStream.close();
            } else {
                saveFile.createNewFile();
                uuid = getTrulyUUID(context);
                FileOutputStream outputStream = new FileOutputStream(saveFile);
                outputStream.write(uuid.getBytes("UTF-8"));
                outputStream.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return TextUtils.isEmpty(uuid) ? getTrulyUUID(context) : uuid;
    }


    private static String getTrulyUUID(Context context) {
        final TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        final String tmDevice, tmSerial, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(context.getContentResolver(),
                android.provider.Settings.Secure.ANDROID_ID);

        UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
        String deviceId = deviceUuid.toString();

        return deviceId;
    }


}
