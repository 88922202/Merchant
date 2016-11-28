package com.iqianggou.android.merchantapp.assist.image;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/10/5.
 */

public class ImageClient {

    private static ILoadImage CLIENT = new PicassoClient();

    private ImageClient(){

    }

    public static void loadImage(Context context, String url, ImageView imageView){
        CLIENT.loadImage(context, url, imageView);
    }

}
