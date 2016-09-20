package com.iqianggou.android.merchantapp.data.http.api;

import com.iqianggou.android.merchantapp.data.model.User;
import com.iqianggou.android.merchantapp.data.model.Reply;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2016/9/17.
 */
public interface Login {
    @FormUrlEncoded
    @POST("brandadmin/login")
    Observable<Reply<User>> doLogin(@Field("account") String account, @Field("password") String password);

}
