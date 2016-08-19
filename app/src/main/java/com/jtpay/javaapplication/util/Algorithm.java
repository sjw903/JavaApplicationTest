package com.jtpay.javaapplication.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Steven on 2016/8/8 0008.
 */

public class Algorithm {
    public int findGreatNumber(int[] intArrays) {
        if (null == intArrays) {
            throw new NullPointerException("Array is null");
        } else if (0 == intArrays.length) {
            throw new IllegalArgumentException("Array can't have data");
        }

        int max = intArrays[0];
        for (int i : intArrays) {
            if (max < i) {
                max = i;
            }
        }
//        ToastUtil.getInstance().showToast(max + "");
        return max;
    }

    /**
     * great common divider
     *
     * @param number1
     * @param number2
     * @return
     */
    public int gcd(int number1, int number2) {
        return 0;
    }

    public void print() {
        System.out.println('I' + 'T');
    }

    public void switchTest() {
        String content = "123";
        switch (content) {
            case "3456":
                break;
            case "343243":
                LogUtil.log("switchTest");
                break;
            case "123":
                LogUtil.log("switchTest find it");
                break;
            default:
                break;
        }
    }

    public void percent() {
        double percent = (double) (1 - 1.1 * 0.7) / (1.1 * 0.3);
        LogUtil.log("percent = " + percent);
    }

    /*
     * remove the repeated number in the array
     */
    public <T> void removeRepeatedNumber(T[] array) {
        Set<T> set = new HashSet<T>();
        for (T t : array) {
            set.add(t);
        }
        LogUtil.log("removeRepeatedNumber after : ");
        LogUtil.log(" array value is ");

        for (T t : set) {
            LogUtil.log("   " + t);
        }
    }

    public void removeRepeatedNumber(int[] intArrays) {
        Set<Integer> set = new HashSet();
        for (int i : intArrays) {
            set.add(i);
        }
        LogUtil.log("removeRepeatedNumber after : ");
        LogUtil.log(" array value is ");
        for (int i : set) {
            LogUtil.log("   " + i);
        }
    }

    public void findSecondLargerNumber(int[] intArrays) {
        if (null == intArrays || 0 == intArrays.length) {
            throw new IllegalArgumentException("argument is null or argument length is 0 ");
        }
        Arrays.sort(intArrays);
        int max, secondMax;
        max = secondMax = intArrays[0];
        boolean findSecondMax = false;
        for (int i : intArrays) {
            if (max < i) {
                secondMax = max;
                if (!findSecondMax) {
                    findSecondMax = true;
                }
                max = i;
            }
        }
        if (findSecondMax) {
            LogUtil.log("findSecondLargerNumber find second max number is " + secondMax);
        } else {
            LogUtil.log("findSecondLargerNumber not  find second max number");
        }
    }
}
