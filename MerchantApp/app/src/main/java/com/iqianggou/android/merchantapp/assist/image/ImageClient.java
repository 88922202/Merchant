package com.iqianggou.android.merchantapp.assist.image;

/**
 * Created by Administrator on 2016/10/5.
 */

public class ImageClient {

    private static ILoadImage CLIENT = new PicassoClient();

    private ImageClient(){

    }

    public static ILoadImage getClient(){
        return CLIENT;
    }

}
