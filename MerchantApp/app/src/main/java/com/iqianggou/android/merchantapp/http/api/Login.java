package com.iqianggou.android.merchantapp.http.api;

import com.iqianggou.android.merchantapp.model.pojo.User;
import com.iqianggou.android.merchantapp.model.pojo.Response;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/9/17.
 */
public interface Login {
    @FormUrlEncoded
    @POST("brandadmin/login")
    Observable<Response<User>> doLogin(@Field("account") String account, @Field("password") String password);

}
