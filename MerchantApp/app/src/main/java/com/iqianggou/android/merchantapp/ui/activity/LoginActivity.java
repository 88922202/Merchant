package com.iqianggou.android.merchantapp.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iqianggou.android.merchantapp.MerApplication;
import com.iqianggou.android.merchantapp.R;
import com.iqianggou.android.merchantapp.ui.presenter.ILoginPresenter;
import com.iqianggou.android.merchantapp.ui.presenter.ILoginView;
import com.iqianggou.android.merchantapp.ui.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity implements ILoginView{

    private Button mLogin;
    private EditText mUsername;
    private EditText mPassword;
    private ILoginPresenter mLoginPresenter;

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
                    Toast.makeText(MerApplication.getInstance(), "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(MerApplication.getInstance(), "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }

                mLoginPresenter.doLogin(username, password);
            }
        });
    }

    private void initComponents(){
        mLoginPresenter = new LoginPresenter(this, this);
    }
}
