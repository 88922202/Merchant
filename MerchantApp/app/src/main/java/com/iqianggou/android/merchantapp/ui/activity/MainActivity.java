package com.iqianggou.android.merchantapp.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.iqianggou.android.merchantapp.R;
import com.iqianggou.android.merchantapp.model.http.IHttpCallback;
import com.iqianggou.android.merchantapp.model.http.IUserApiService;
import com.iqianggou.android.merchantapp.model.http.retrofit.UserApiService;
import com.iqianggou.android.merchantapp.model.pojo.Reply;
import com.iqianggou.android.merchantapp.model.pojo.User;

public class MainActivity extends BaseActivity {

    private IUserApiService mLoginApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginApi = new UserApiService();
                mLoginApi.doLogin("zgzd", "150130", new IHttpCallback<Reply<User>>() {

                    @Override
                    public void onSuccess(Reply<User> reply) {
                        Log.d("MainActivity", "onSuccess");
                    }

                    @Override
                    public void onFailure(int errorCode, String message) {

                    }

                }, MainActivity.this);
            }
        });

    }

}
