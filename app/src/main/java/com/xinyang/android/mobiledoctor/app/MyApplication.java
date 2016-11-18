package com.xinyang.android.mobiledoctor.app;

import com.jaydenxiao.common.BuildConfig;
import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.LogUtils;

/**
 * Created by Administrator on 2016/11/18.
 */

public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化logger
        LogUtils.logInit(BuildConfig.LOG_DEBUG);

    }
}
