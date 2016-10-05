package com.iqianggou.android.merchantapp.data.local.json;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2016/10/5.
 */

public interface IJson {
    <T> T jsonToBean(String json, Type type);
}
