package com.iqianggou.android.merchantapp.data;

import com.iqianggou.android.merchantapp.data.model.User;

/**
 * Created by Administrator on 2016/10/5.
 */

public class UserManager {

    private static UserManager INSTANCE;

    private User mCurrentUser;

    public static UserManager getInstance(){
        if (INSTANCE == null){
            synchronized (UserManager.class){
                INSTANCE = new UserManager();
            }
        }

        return INSTANCE;
    }

    public void setCurrentUser(User user){
        mCurrentUser = user;
    }

    public User getCurrentUser(){
        return mCurrentUser;
    }
}
