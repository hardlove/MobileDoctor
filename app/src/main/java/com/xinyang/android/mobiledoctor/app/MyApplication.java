package com.xinyang.android.mobiledoctor.app;


import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.jaydenxiao.common.commonutils.TimeUtil;
import com.xinyang.android.mobiledoctor.BuildConfig;

/**
 * Created by Chenlu on 2016/11/18.
 */

public class MyApplication extends BaseApplication {
    private static final String TAG = "MyApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化logger
        LogUtils.logInit(BuildConfig.LOG_DEBUG);
        LogUtils.logd("app start time:"+ TimeUtil.getCurrentDate(TimeUtil.dateFormatYMDHMS));
    }
}
