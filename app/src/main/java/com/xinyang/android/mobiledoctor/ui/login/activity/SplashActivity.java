package com.xinyang.android.mobiledoctor.ui.login.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.xinyang.android.mobiledoctor.R;

import butterknife.Bind;

/**
 * Created by Chenlu on 2016/11/18.
 */
public class SplashActivity extends BaseActivity {
    @Bind(R.id.iv_logo)
    ImageView mIvLogo;
    @Bind(R.id.tv_name)
    TextView mTvName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

        SetTranslanteBar();
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 0.3f, 1f);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 0.3f, 1f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0.3f, 1f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(mTvName, alpha, scaleX, scaleY);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(mIvLogo, alpha, scaleX, scaleY);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1, objectAnimator2);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.setDuration(2000);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                startActivity(LoginActivity.class);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animatorSet.start();
    }

}
