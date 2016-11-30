package com.iqianggou.android.merchantapp.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iqianggou.android.merchantapp.MerApplication;
import com.iqianggou.android.merchantapp.R;
import com.iqianggou.android.merchantapp.ui.components.DaggerLoginPresenterComponent;
import com.iqianggou.android.merchantapp.ui.components.LoginPresenterComponent;
import com.iqianggou.android.merchantapp.ui.module.LoginActivityModule;
import com.iqianggou.android.merchantapp.ui.presenter.ILoginView;
import com.iqianggou.android.merchantapp.ui.presenter.LoginPresenter;
import com.iqianggou.android.merchantapp.utils.ToastUtil;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements ILoginView{

    @Inject LoginPresenter mLoginPresenter;

    private Button mLogin;
    private EditText mUsername;
    private EditText mPassword;

    //private LoginPresenterComponent mLoginPresenterComponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViews();
        setupViews();
        initComponents();
    }

    private void findViews(){
        mLogin = (Button) findViewById(R.id.btn_login);
        mUsername = (EditText) findViewById(R.id.et_username);
        mPassword = (EditText) findViewById(R.id.et_password);
    }

    private void setupViews(){
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUsername.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                if (TextUtils.isEmpty(username)){
                    ToastUtil.showShortText("请输入用户名");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    ToastUtil.showShortText("请输入密码");
                    return;
                }

                mLoginPresenter.doLogin(username, password);
            }
        });
    }

    private void initComponents(){
        //mLoginPresenter = new LoginPresenter(this, this);
        DaggerLoginPresenterComponent.builder()
                .loginActivityModule(new LoginActivityModule(this))
                .build()
                .inject(this);
    }
}
