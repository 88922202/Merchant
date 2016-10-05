package com.iqianggou.android.merchantapp.data.http.api;

import com.iqianggou.android.merchantapp.data.model.Reply;
import com.iqianggou.android.merchantapp.data.model.User;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2016/10/5.
 */

public interface Register {
    @FormUrlEncoded
    @POST("brandadmin/register_and_login")
    Observable<Reply<User>> registerAndLogin(@Field("mobile") String mobile, @Field("auth_code") String authCode);
}
