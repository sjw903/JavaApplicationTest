package com.sun.test.utils;

import java.util.Objects;

/**
 * Created by Steven on 2017/1/7 0007.
 */

public class GenericPair<F, S> {
    public final F first;
    public final S second;

    public GenericPair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public static <A, B> GenericPair<A, B> create(A f, B s) {
        return new GenericPair(f, s);
    }

    @Override
    public int hashCode() {
        return (null == first ? 0 : first.hashCode()) ^ (null == second ? 0 : second.hashCode());
    }

    @Override
    public String toString() {
        return "GenericPair{" + String.valueOf(first) + " " + String.valueOf(second) + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GenericPair)) {
            return false;
        }
        GenericPair<?, ?> t = (GenericPair<?, ?>) o;
        return Objects.equals(t.first, first) && Objects.equals(t.second, second);

    }
}
