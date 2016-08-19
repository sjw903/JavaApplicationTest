package com.jtpay.javaapplication.app;

import android.app.Application;

import com.jtpay.javaapplication.util.ContextUtil;
import com.jtpay.javaapplication.util.ExceptionHandler;

/**
 * Created by Steven on 2016/8/8 0008.
 */

public class JavaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ContextUtil.getInstance().setContext(getApplicationContext());
        ExceptionHandler.getInstance().init(getApplicationContext());
    }
}
