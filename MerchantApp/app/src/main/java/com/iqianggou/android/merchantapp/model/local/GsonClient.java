package com.iqianggou.android.merchantapp.model.local;

import com.google.gson.Gson;

/**
 * Created by ubuntu on 16-9-18.
 */
public class GsonClient {

    synchronized public static Gson getGson(){
        return Holder.INSTANCE;
    }

    private GsonClient(){

    }

    private static class Holder {
        private static Gson INSTANCE = new Gson();
    }
}
