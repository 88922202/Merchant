package com.iqianggou.android.merchantapp.assist.image;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2016/10/5.
 */

public class PicassoClient implements ILoadImage {
    @Override
    public void loadImage(Context context, String url, ImageView imageView) {
        Picasso.with(context).load(url).into(imageView);
    }


}
