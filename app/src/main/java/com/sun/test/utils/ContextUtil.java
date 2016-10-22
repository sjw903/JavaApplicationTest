package com.sun.test.utils;

import android.content.Context;

/**
 * Created by Steven on 2016/8/8 0008.
 */

public class ContextUtil {
    private ContextUtil() {

    }
    private Context mContext;
    private static class Holder{
        private static ContextUtil mContextUtil = new ContextUtil();
    }

    public static ContextUtil getInstance() {
        return Holder.mContextUtil;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public Context getContext() {
        if (null == mContext) {
            throw new RuntimeException("Context must be not null! Should set it at Application");
        }
        return  mContext;
    }
}
