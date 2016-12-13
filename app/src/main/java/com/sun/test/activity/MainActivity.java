package com.sun.test.activity;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sun.test.R;
import com.sun.test.java.CollectionTest;
import com.sun.test.java.ExceptionTest;
import com.sun.test.utils.Algorithm;
import com.sun.test.utils.LogUtil;
import com.sun.test.utils.ReflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
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
                algorithmTest();
//                reflectTest();
//                androidTest();
//                for (int i = 0; i < 2; i++) {
//                    simpleTest(i);
//                }
                javaTest();
            }).start();
        });
        Button button1 = (Button) findViewById(R.id.btn_test);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeChatScanUI();
            }
        });
    }

    private void openWeChatScanUI() {
        if (Build.VERSION.SDK_INT >= 23) {
            int checkOpenPermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA);
            if (checkOpenPermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA,"com.tencent.mm.permission.C2D_MESSAGE",
                "com.tencent.mm.plugin.permission.READ","com.tencent.mm.plugin.permission.WRIT"
                }, 0);
            }
        } else {
            doOpenWeChatScanUI();
        }
    }

    private void doOpenWeChatScanUI() {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.scanner.ui.BaseScanUI");
        intent.setComponent(componentName);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                doOpenWeChatScanUI();
            } else {
                Toast.makeText(this, "can have permission", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private static final String TOKEN_ID = "token_id";
    private static final String APPID = "appid";
    private static final String PLUGIN = "android.intent.action.PAY_PLUGIN";

    // 打开Apk
    public void openApk() {
        String tokenId = "cb9d364fab1c35a84db7de82ca2c559c";
        String appId = "wx1d6775c7e499caa9";
        Intent intent = new Intent(PLUGIN);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(TOKEN_ID, tokenId);
        intent.putExtra(APPID, appId);
        startActivity(intent);
    }

    private void javaTest() {
        collectionTest();
        exceptionTest();
    }

    private void exceptionTest() {
        ExceptionTest test = new ExceptionTest();
        test.exception();
    }

    private void collectionTest() {
        List<String> list = Arrays.asList(new String[]{"one", "two", "three", "four", "five"});
        CollectionTest.getInstance().listReverse(list);
        for (String str : list) {
            System.out.print(" " + str);
        }
        System.out.println();
    }

    private void reflectTest() {
        try {
            Class<?> cls = Class.forName("com.sun.test.utils.ReflectTest");
            Constructor constructor = cls.getConstructor(new Class[]{String.class});
            try {
                ReflectTest reflectTest = (ReflectTest) constructor.newInstance("test");
                LogUtil.log("get String " + reflectTest.getString());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            Constructor constructor1 = cls.getConstructor(new Class[]{Context.class});
            try {
                ReflectTest reflectTest = (ReflectTest) constructor1.newInstance(this);
                String packageName = reflectTest.getPackageName();
                LogUtil.log("packageName = " + packageName);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
        }

    }

    private void androidTest() {
        androidUtilTest();
    }

    private void androidUtilTest() {
        long currentTime = System.currentTimeMillis();
        boolean result = DateUtils.isToday(currentTime);
        LogUtil.log("result1 = " + result);
        long day_millis = DateUtils.DAY_IN_MILLIS;
        currentTime += day_millis;
        result = DateUtils.isToday(currentTime);
        LogUtil.log("result2 = " + result);
        LogUtil.log("day_millis = " + day_millis);
    }

    private void algorithmTest() {
        int[] intArrays = {5, 3, 3, 3, 3, 3, 2323, -1};
        int[] intArrays2 = {8, 4, 1, 3};
        int[] intArrays3 = {3, 3, 3, 3, 3, 3};
        Algorithm algorithm = new Algorithm();
        int result = 'i' + 't';
        LogUtil.log("result = " + result);
        algorithm.findSecond(intArrays);
        algorithm.findSecond(intArrays2);
        algorithm.findSecond(intArrays3);
//        algorithm.switchTest();
//        algorithm.percent();
//        algorithm.arrayListLengthTest();

//        try {
//            algorithm.findSecondLargerNumber(intArrays);
//            algorithm.findSecondLargerNumber(intArrays2);
//            algorithm.findSecondLargerNumber(intArrays3);
//            algorithm.findSecondLargerNumber(null);
//        } catch (IllegalArgumentException e) {
//            LogUtil.log(" Exception " + e.getMessage());
//        } finally {
//            LogUtil.log("finally ");
//        }

        System.out.println();
        LogUtil.log("intArrays ");
        for (int i : intArrays) {
            System.out.print(i + " ");
        }

        System.out.println();
        LogUtil.log("intArrays2 ");
        for (int i : intArrays2) {
            System.out.print(i + " ");
        }

        System.out.println();
        LogUtil.log("intArrays3 ");
        for (int i : intArrays3) {
            System.out.print(i + " ");
        }
        System.out.println();
        algorithm.test();
//        algorithm.removeRepeatedNumber(intArrays);
//        algorithm.removeRepeatedNumber(intArrays2);
//        algorithm.removeRepeatedNumber(intArrays3);

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