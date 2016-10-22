package com.sun.test.utils;

import android.content.Context;
import android.os.Handler;

/**
 * Created by Steven on 2016/10/10 0010.
 */

public class ReflectTest {
    private Context mContext;
    private Handler mHandler;
    private String mString;
    public ReflectTest(Context context, Handler handler) {
        LogUtil.log("ReflectTest context handler ");
        mContext = context;
        mHandler = handler;
    }

    public ReflectTest(Context context) {
        mContext = context;
        LogUtil.log("ReflectTest context");
    }

    public ReflectTest(String string) {
        LogUtil.log("ReflectTest string = " + string);
        mString = string;
    }

    public String getString() {
        return  mString;
    }

    public String getPackageName() {
        return null == mContext ? "" : mContext.getPackageName();
    }
}
