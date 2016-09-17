package com.iqianggou.android.merchantapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.bugtags.library.Bugtags;

/**
 * Created by Administrator on 2016/9/17.
 */
public class BaseActivity extends AppCompatActivity {

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
}
