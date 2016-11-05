package com.sun.test.java;

import java.util.Collections;
import java.util.List;

/**
 * Created by Steven on 2016/11/5 0005.
 * user singleTon instance
 */

public class CollectionTest<T> {
    private CollectionTest() {
    }

    private static class Holder {
        private static final CollectionTest mInstance = new CollectionTest();
    }

    public static CollectionTest getInstance() {
        return Holder.mInstance;
    }

    public void listReverse(List<?> list) {
        Collections.reverse(list);
    }

    public T test(T t) {
        return  t;
    }
}
