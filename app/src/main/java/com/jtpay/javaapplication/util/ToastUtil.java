package com.jtpay.javaapplication.util;

import android.widget.Toast;

/**
 * Created by Steven on 2016/8/8 0008.
 */

public class ToastUtil {
    private Toast mToast;
    private ToastUtil() {
        mToast = Toast.makeText(ContextUtil.getInstance().getContext(),"",Toast.LENGTH_SHORT);
    }
    private static class Holder {
        private static ToastUtil mToastUtil = new ToastUtil();
    }

    public static ToastUtil getInstance() {
        return Holder.mToastUtil;
    }

    public void showToast(String content) {
        if (null != mToast) {
            mToast.setText(content);
            mToast.show();
        }
    }
}
