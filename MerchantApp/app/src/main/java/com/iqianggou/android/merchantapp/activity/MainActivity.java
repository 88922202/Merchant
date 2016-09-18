package com.iqianggou.android.merchantapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.iqianggou.android.merchantapp.R;
import com.iqianggou.android.merchantapp.http.asynchttp.AsyncClient;
import com.iqianggou.android.merchantapp.http.retrofit.RetrofitClient;
import com.loopj.android.http.AsyncHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitClient.getInstance().doLogin("zgzd", "150130");
                AsyncClient.getInstance().doLogin("zgzd", "150130");
            }
        });

    }
}
