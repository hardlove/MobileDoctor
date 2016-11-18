package com.xinyang.android.mobiledoctor.ui.login.activity;

import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.xinyang.android.mobiledoctor.R;
import com.xinyang.android.mobiledoctor.ui.login.contract.LoginContact;
import com.xinyang.android.mobiledoctor.ui.login.model.LoginModel;
import com.xinyang.android.mobiledoctor.ui.login.presenter.LoginPresenter;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 登录界面
 */
public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContact.View {


    @Bind(R.id.login_progress)
    ProgressBar mLoginProgress;
    @Bind(R.id.email)
    AutoCompleteTextView mEmail;
    @Bind(R.id.password)
    EditText mPassword;
    @Bind(R.id.email_sign_in_button)
    Button mEmailSignInButton;
    @Bind(R.id.email_login_form)
    LinearLayout mEmailLoginForm;
    @Bind(R.id.login_form)
    ScrollView mLoginForm;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {

    }

    @Override
    public void onUserNameError() {
        ToastUitl.showShort("用户名错误，请检查!");
        stopProgressDialog();
    }

    @Override
    public void onPasswordError() {
        ToastUitl.showShort("密码错误，请检查!");
        stopProgressDialog();
    }

    @Override
    public void onStartLogin() {
        startProgressDialog("正在登录...");
    }

    @Override
    public void onLoginSuccess() {
        stopProgressDialog();
        ToastUitl.showShort("登录成功！");
    }

    @Override
    public void onLoginFailed(String msg) {
        stopProgressDialog();
    }


    @OnClick(R.id.email_sign_in_button)
    public void onClick() {
        login();
    }

    private void login() {
        String username = mEmail.getText().toString().trim();
        String passward = mPassword.getText().toString().trim();
        mPresenter.loginRequest(username,passward);
    }
}

