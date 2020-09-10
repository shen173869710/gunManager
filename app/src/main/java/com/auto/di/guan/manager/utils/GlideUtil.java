package com.auto.di.guan.manager.utils;

import android.widget.ImageView;

import com.auto.di.guan.manager.app.BaseApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtil {


    /**
     *        加载圆角的图片
     * @param imageView
     * @param url
     */
    public static void glideCircleImage(ImageView imageView, String url) {
        Glide.with(BaseApp.getInstance())
                .load(url)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }


    /**
     *        加载圆角的图片
     * @param imageView
     * @param resId
     */
    public static void glideCircleImage(ImageView imageView, int resId) {
        Glide.with(BaseApp.getInstance())
                .load(resId)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }

}
