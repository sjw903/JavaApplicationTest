package com.sun.test.utils;

import android.util.Log;

/**
 * Created by Steven on 2016/6/25 0025.
 */

public class LogUtil {
    private static boolean mDebug = true;
    private static final String TAG = "junfutong";

    public static void log(String content) {
        if (mDebug) {
            Log.d(TAG, content);
        }
    }
}
