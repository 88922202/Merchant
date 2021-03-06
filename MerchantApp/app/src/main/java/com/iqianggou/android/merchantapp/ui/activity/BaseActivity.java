package com.iqianggou.android.merchantapp.ui.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;

import com.bugtags.library.Bugtags;
import com.iqianggou.android.merchantapp.R;
import com.iqianggou.android.merchantapp.data.http.ILoadingDialog;

/**
 * Created by Administrator on 2016/9/17.
 */
public class BaseActivity extends AppCompatActivity implements ILoadingDialog{

    protected Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        mLoadingDialog = createLoadingDialog();
    }

    @Override
    protected void onResume(){
        super.onResume();

        Bugtags.onResume(this);
    }

    @Override
    protected void onPause(){
        super.onPause();

        Bugtags.onPause(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event){

        Bugtags.onDispatchTouchEvent(this, event);
        return super.dispatchTouchEvent(event);
    }

    @Override
    public void showLoadingDialog() {
        mLoadingDialog.show();
    }

    @Override
    public void cancelLoadingDialog() {
        mLoadingDialog.cancel();
    }

    private Dialog createLoadingDialog(){
        Dialog dialog = new Dialog(this, R.style.dialog_loading);
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        dialog.setContentView(R.layout.dialog_loading);

        return dialog;
    }
}
