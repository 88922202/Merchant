package com.iqianggou.android.merchantapp.data.http.api;

import com.iqianggou.android.merchantapp.data.model.Merchant;
import com.iqianggou.android.merchantapp.data.model.Reply;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2016/10/5.
 */

public interface GetMerchants {
    @GET("brandadmin/branch/list")
    Observable<Reply<List<Merchant>>> getMerchants();
}
