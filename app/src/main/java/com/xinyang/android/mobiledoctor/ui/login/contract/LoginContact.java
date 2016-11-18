package com.xinyang.android.mobiledoctor.ui.login.contract;

import android.support.annotation.NonNull;

import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

/**
 * Created by Chenlu on 2016/11/18.
 */

public interface LoginContact {
    interface Model extends BaseModel{
        void login(String userName,String passWard);
    }

    interface View extends BaseView{

        void onUserNameError();
        void onPasswordError();
        void onStartLogin();
        void onLoginSuccess();
        void onLoginFailed(String msg);

    }

    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void loginRequest(@NonNull String username, @NonNull String passward);
    }
}
