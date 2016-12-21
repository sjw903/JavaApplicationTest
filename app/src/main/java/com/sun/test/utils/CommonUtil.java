package com.sun.test.utils;

import android.util.Pair;

/**
 * Created by Steven on 2016/12/15 0015.
 */

public class CommonUtil {
    public void pairTest() {
        Pair pair = new Pair(1, 2);
        int first = (int) pair.first;
        final Object second = pair.second;
    }
}
