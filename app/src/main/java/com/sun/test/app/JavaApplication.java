package com.sun.test.app;

import android.app.Application;

import com.sun.test.utils.ContextUtil;
import com.sun.test.utils.ExceptionHandler;

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
