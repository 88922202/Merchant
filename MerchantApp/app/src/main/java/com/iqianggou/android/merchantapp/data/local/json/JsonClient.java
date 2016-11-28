package com.iqianggou.android.merchantapp.data.local.json;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2016/10/5.
 */

public class JsonClient {

    private static IJson CLIENT = new GsonClient();

    private JsonClient(){

    }

    public static  <T> T jsonToBean(String json, Type type){
        return CLIENT.jsonToBean(json, type);
    }
}
