package com.jtpay.javaapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;

import com.jtpay.javaapplication.R;
import com.jtpay.javaapplication.util.Algorithm;
import com.jtpay.javaapplication.util.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        initWidget();
    }

    private void initWidget() {
        Button button = (Button) findViewById(R.id.btn_algorithm);
        button.setOnClickListener(m -> {
            System.out.println("Lambda  m.getId() = " + m.getId());
            new Thread(() -> {
//                algorithmTest();
                for (int i = 0; i < 2; i++) {
                    simpleTest(i);
                }
            }).start();
        });
    }

    private void algorithmTest() {
        int[] intArrays = {3, 3, 3, 3, 3, 3, 2323, -1};
        int[] intArrays2 = {2, 35, 5, 4, 1, 2};
        int[] intArrays3 = {3, 3, 3, 3, 3, 3};
        Algorithm algorithm = new Algorithm();
        int max = algorithm.findGreatNumber(intArrays);
        LogUtil.log("algorithmTest max = " + max);
        algorithm.print();
        int result = 'i' + 't';
        LogUtil.log("result = " + result);
        algorithm.switchTest();
        algorithm.percent();


        algorithm.removeRepeatedNumber(intArrays);
        algorithm.removeRepeatedNumber(intArrays2);
        algorithm.removeRepeatedNumber(intArrays3);
        try {
            algorithm.findSecondLargerNumber(intArrays);
            algorithm.findSecondLargerNumber(intArrays2);
            algorithm.findSecondLargerNumber(intArrays3);
            algorithm.findSecondLargerNumber(null);
        } catch (IllegalArgumentException e) {
            LogUtil.log(" Exception " + e.getMessage());
        } finally {
            LogUtil.log("finally ");
        }
    }

    private void test() {
        HashMap<String, String> map = new HashMap<>();
        map.put("tangshan", "chen bao");
        Map<String, String> map2 = new HashMap<>();
        map.put("beijing", "chang liang");
        map2.put("beijing", "chang liang");

        List<Map<String, String>> list = new ArrayList<>();
        list.add(map);
        list.add(map2);
        for (Map<String, String> map3 : list) {
            for (Map.Entry<String, String> entry : map3.entrySet()) {
                LogUtil.log("key = " + entry.getKey());
                LogUtil.log("key = " + entry.getValue());
            }
        }
    }

    private void textUtilTest() {
        String origin = "0123456789";
        CharSequence dest = TextUtils.getReverse(origin, 0, origin.length());
        LogUtil.log("textUtilTest dest = " + dest);
    }

    private void regexTest() {
        stringTest();
    }

    private void stringTest() {
        String regex = "g+d";
        boolean ret = checkMatch(regex, "god");
        LogUtil.log("stringTest ret1 = " + ret);
    }

    private boolean checkMatch(String regex, String string) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        boolean ret = matcher.matches();
        return ret;
    }

    private void strTest() {
        String timeStr = "2016-07-01 00:00:00";
        int index = timeStr.lastIndexOf("-");
        String newTimeStr = timeStr.substring(0, index + 1);
        LogUtil.log("strTest newTimeStr = " + newTimeStr);
    }

    private int simpleTest(int i) {
        try {
            if (i % 2 == 0) {
                Exception();
            }
            LogUtil.log("return normal");
            return 0;
        } catch (Exception e) {
            LogUtil.log("exception happen!");

        } finally {
            LogUtil.log("finally implement!");
        }
        LogUtil.log("return abnormal");
        return 1;

    }

    private void Exception() {
        throw new NullPointerException("Null pointer exception");
    }
}