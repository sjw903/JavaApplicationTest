package com.sun.test.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
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
        System.out.println("out!");
        randomNumber();
    }

    public void randomNumber() {
        System.out.println("randomNumber!");
        Random r = new Random();
        int number;
        for (int i = 0; i < 20; i++) {
            number = r.nextInt();
            System.out.print(" " + number);
            if (0 == i % 10) {
                System.out.println();
            }
        }
        System.out.println();
        for (int i = 0; i < 50; i++) {
            number = r.nextInt(50);
            System.out.print(" " + number);
            if (0 == i % 10) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public void printMap(HashMap map) {
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object value = map.get(key);
            System.out.println("key %s: value %s" + key + value);

        }
        for (Object entry : map.entrySet()) {
            Map.Entry mapEntry = (Map.Entry) entry;
            System.out.println("key %s: value %s" + mapEntry.getKey() + mapEntry.getValue());
        }
        Set<Map.Entry> set = map.entrySet();
        for (Map.Entry entry : set) {
            Object key = entry.getKey();
            Object value = entry.getValue();
        }
    }

    /**
     * Algorithm
     * Question:
     * <p>
     * 1    3   7   13  ...
     * 5    9   15  ...
     * 11   17  ...
     * 19   ...
     * ...
     * <p>
     * calculate the position of 2009
     * <p>
     * print out the result of coordinate
     * Form :
     * A(i,j) = i * i + j * j + i + 2 * i * j + 3 * j + 1
     */

    public void calculateCoordinate() {
        int sum;
        int m, n;
        m = n = 0;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                sum = (int) Math.pow(i, 2) + (int) Math.pow(j, 2) + i + 2 * i * j + 3 * j + 1;
                if (2009 == sum) {
                    m = i;
                    n = j;
                    System.out.println("i = " + i + " j = " + j + " sum = " + sum);
                    break;
                }
            }
        }
        System.out.println(" x = " + (m + 1) + " y = " + (n + 1));
        int con = (int) Math.pow(n, 2) + 3 * n + 1;
        for (int i = 0; i <= m; i++) {
            sum = con + (int) Math.pow(i, 2) + i + 2 * i * n;
            System.out.print(" " + sum);
        }
        System.out.println(String.format("m = %d, n = %d", m + 1, n + 1));
        System.out.printf("m = %d, n = %d ", m + 1, n + 1);
        System.out.println("end");
    }

    /**
     * calculateCoordinate
     * the wrong method above
     */
    public void testNumber() {
        int sum = 0;
        int m, n;
        m = n = 0;
        for (int i = 0; i < 44; i++) {
            for (int j = 0; j < 44; j++) {
                sum = i * i + i + j * j + 3 * j;
                if (sum == 8) {
                    m = i;
                    n = j;
                    i = i + 1;
                    j = j + 1;
                    LogUtil.log("i = " + i + " j = " + j + " sum = " + sum);
                    break;
                }
            }
        }
        int begin = n * n + 3 * n + 1;
        System.out.println("begin = " + begin);
        int number;
        for (int i = 0; i <= m; i++) {
            number = (i + 1) * i + begin;
            System.out.print(" " + number);
            if (0 == (i + 1) % 10) {
                System.out.println();
            }
        }
        System.out.println();

    }

    public void listTest() {
        List<String> listStr = new ArrayList<>();
        listStr.add("1");
        listStr.add("2");
        // wrong code
//        for (String str : listStr) {
//            if ("1".equals(str)) {
//                listStr.remove(str);
//            }
//        }
        System.out.println("Original:");
        for (String str : listStr) {
            System.out.print(" " + str);
        }
        System.out.println();

        Iterator<String> iterator = listStr.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if ("1".equals(str)) {
                iterator.remove();
            }
        }
        System.out.println();
        System.out.println("After:");
        for (String str : listStr) {
            System.out.print(" " + str);
        }
        System.out.println();
        int remain = -3 % 2;
        int mod = -3 / 2;
        System.out.println(String.format("remain = %d, mod = %d", remain, mod));
        double result = 2.00 - 1.10;
        System.out.println("result = " + result);
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
        result = Double.parseDouble(new BigDecimal("2.00").subtract(new BigDecimal("1.10")).toString());
        System.out.println("result = " + result);
    }
}
