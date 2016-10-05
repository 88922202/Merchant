package com.iqianggou.android.merchantapp.data.local.json;

/**
 * Created by Administrator on 2016/10/5.
 */

public class JsonClient {

    private static IJson CLIENT = new GsonClient();

    public static IJson getClient(){
        return CLIENT;
    }

    private JsonClient(){

    }
}
