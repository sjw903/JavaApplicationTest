package com.sun.test.utils;


import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final ThreadLocal<SimpleDateFormat> sDateFormat = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        }
    };
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (!handleException(throwable) && null != mDefaultHandler) {
            mDefaultHandler.uncaughtException(thread, throwable);
        } else {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    private static class InstanceHolder {
        static ExceptionHandler handler = new ExceptionHandler();
    }

    public static ExceptionHandler getInstance() {
        return InstanceHolder.handler;
    }

    private ExceptionHandler() {

    }

    public void init(Context context) {
        mContext = context;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private void saveFile(Throwable throwable) {
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        throwable.printStackTrace(printWriter);
        Throwable cause = throwable.getCause();
        while (null != cause) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        String str = writer.toString();
        String fileName = "crash_" + sDateFormat.get().format(new Date()) + ".log";
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            String storagePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "java_exception";
            boolean canWrite = Environment.getExternalStorageDirectory().canWrite();
            LogUtil.log("canWrite = " + canWrite);
            File pathFile = new File(storagePath);
            if (!pathFile.exists()) {
                pathFile.mkdirs();
            }
            File file1 = new File(pathFile, fileName);
            FileWriter fileWriter1 = null;
            try {
                fileWriter1 = new FileWriter(file1, true);
                fileWriter1.write(str);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                AutoClose.quietClose(fileWriter1);
            }
        }
    }

    private boolean handleException(Throwable throwable) {
        if (null == throwable) {
            return false;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(mContext, "program quit caused by exception ", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }).start();
        saveFile(throwable);
        return true;
    }

}
