package com.sun.test.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
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
        //LinkedHashSet keep origin order
        //TreeSet from small to big

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
        Set<Integer> set = new LinkedHashSet<>();
        for (int i : intArrays) {
            set.add(i);
        }
        LogUtil.log("removeRepeatedNumber after : ");
        LogUtil.log(" array value is ");
        Integer[] integers = (Integer[]) set.toArray();
        for (int i : integers) {
            LogUtil.log("   " + i);

        }
        LogUtil.log("set array");
        for (int i : set) {
            LogUtil.log("   " + i);
        }
    }

    public <T> void findSecondLargerNumber(T[] intArrays) {
        if (null == intArrays || 0 == intArrays.length) {
            throw new IllegalArgumentException("argument is null or argument length is 0 ");
        }
        Arrays.sort(intArrays);
        T max;
        int len = intArrays.length;

        max = intArrays[len - 1];
        boolean findSecondMax = false;
        for (int i = len - 1; i >= 0; i--) {
            T num = intArrays[i];
            if (!num.equals(max)) {
                max = num;
                findSecondMax = true;
                break;
            }
        }
        if (findSecondMax) {
            LogUtil.log("findSecondLargerNumber find second max number is " + max);
        } else {
            LogUtil.log("findSecondLargerNumber not  find second max number");
        }
    }

    public void findSecondLargerNumber(int[] intArrays) {
        if (null == intArrays || 0 == intArrays.length) {
            throw new IllegalArgumentException("argument is null or argument length is 0 ");
        }
        Arrays.sort(intArrays);
        int max;
        int len = intArrays.length;

        max = intArrays[len - 1];
        boolean findSecondMax = false;
        for (int i = len - 1; i >= 0; i--) {
            int num = intArrays[i];
            if (num < max) {
                max = num;
                findSecondMax = true;
                break;
            }
        }
        if (findSecondMax) {
            LogUtil.log("findSecondLargerNumber find second max number is " + max);
        } else {
            LogUtil.log("findSecondLargerNumber not  find second max number");
        }
    }

    public void arrayListLengthTest() {
        List list = new ArrayList();
        int len = list.size();
        LogUtil.log("arrayListLengthTest len = " + len);
    }

    public void createDir() {

    }

    public void findSecond(int[] intArrays) {
        if (null == intArrays || 0 == intArrays.length) {
            throw new IllegalArgumentException("argument is null or argument length is 0 ");
        }
        int max, secondMax;
        max = intArrays[0];
        secondMax = Integer.MIN_VALUE;
        boolean find = false;
        int len = intArrays.length;
        for (int i = 0; i < len; i++) {
            if (intArrays[i] > max) {
                secondMax = max;
                max = intArrays[i];
                find = true;
            } else if (intArrays[i] > secondMax) {
                if (max > intArrays[i]) {
                    secondMax = intArrays[i];
                    find = true;
                }
            }
        }
        if (find) {
            LogUtil.log("secondMax =  " + secondMax);
        } else {
            LogUtil.log("not findSecondMax!!!");
        }
    }

    public void test() {
        int j = 0;
        for (int i = 1; ; i = i + 2) {
            if (i % 2 == 1 && i % 3 == 0 && i % 4 == 1 && i % 5 == 4 && i % 6 == 3 && i % 7 == 5 && i % 8 == 1 && i % 9 == 0) {
                System.out.println("i = " + i);
                j++;
                if (j == 5) {
                    break;
                }
            }
        }
        System.out.print("out!");
    }
}
