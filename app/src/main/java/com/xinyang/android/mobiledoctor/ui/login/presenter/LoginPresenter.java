package com.xinyang.android.mobiledoctor.ui.login.presenter;

import android.support.annotation.NonNull;

import com.jaydenxiao.common.commonutils.LogUtils;
import com.xinyang.android.mobiledoctor.ui.login.contract.LoginContact;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Chenlu on 2016/11/18.
 */

public class LoginPresenter extends LoginContact.Presenter {
    private static final String TAG = "LoginPresenter";

    @Override
    public void loginRequest(@NonNull String username, @NonNull String passward) {
        if (username.length() < 4) {
            mView.onUserNameError();
        } else if (passward.length() < 4) {
            mView.onPasswordError();
        } else {
            mView.onStartLogin();
//            mModel.login(username,passward);

            Observable.just("login").delay(2, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<String>() {
                @Override
                public void onCompleted() {
                    mView.onLoginSuccess();
                }

                @Override
                public void onError(Throwable e) {
                    mView.onLoginFailed("error msg:"+e.getMessage());
                }

                @Override
                public void onNext(String s) {
                    LogUtils.logd(TAG,s);
                }
            });
        }
    }
}
