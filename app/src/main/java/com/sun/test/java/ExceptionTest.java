package com.sun.test.java;

import com.sun.test.utils.LogUtil;

/**
 * Created by Steven on 2016/11/24 0024.
 */

public class ExceptionTest {
    public void exception() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        } finally {
            LogUtil.log("finally !!");
        }
    }
}
