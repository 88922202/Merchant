package com.iqianggou.android.merchantapp.data.local.json;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by ubuntu on 16-9-18.
 */
public class GsonClient implements IJson{

    private Gson mGson;

    GsonClient(){
        mGson = new Gson();
    }

    @Override
    public <T> T jsonToBean(String json, Type type) {
        return mGson.fromJson(json, type);
    }

}
