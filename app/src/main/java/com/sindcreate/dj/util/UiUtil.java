package com.sindcreate.dj.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.sindcreate.dj.application.MyApplication;

import java.util.List;
import java.util.Random;

/**
 * @Description 处理UI的工具类
 * @Author hefeng
 */

public class UiUtil {

    public static Context getContext() {
        return MyApplication.getContext();
    }

    /**
     * @Description 获取布局
     */
    public static View inflate(int resId) {
        return LayoutInflater.from(getContext()).inflate(resId, null);
    }

    /**
     * @Description 获取资源
     */
    public static Resources getResources() {
        return getContext().getResources();
    }

    /**
     * @Description 获取String
     */
    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    /**
     * @Description 获取String数组
     */
    public static String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }

    /**
     * @Description 获取dimen
     */
    public static int getDimens(int resId) {
        return getResources().getDimensionPixelSize(resId);
    }

    /**
     * @Description 获取drawable
     */
    public static Drawable getDrawable(int resId) {
        return getResources().getDrawable(resId);
    }

    /**
     * @Description 获取颜色
     */
    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    /**
     * @Description 获取颜色选择器
     */
    public static ColorStateList getColorStateList(int resId) {
        return getResources().getColorStateList(resId);
    }

    /**
     * @Description 设置EditText光标在内容之后
     */
    public static void setEditTextCursor(EditText editText) {
        CharSequence text = editText.getText();
        if (text instanceof Spannable) {
            Spannable spanText = (Spannable) text;
            Selection.setSelection(spanText, text.length());
        }
    }

    /**
     * @Description 设置TextView光标在内容之后
     */
    public static void setTextViewCursor(TextView textView) {
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            Spannable spanText = (Spannable) text;
            Selection.setSelection(spanText, text.length());
        }
    }

    /**
     * @Description 判断app是否在前台还是在后台运行
     */
    public static boolean ifRunInBackground(Context context) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(context.getPackageName())) {
                /*
                 * BACKGROUND=400 EMPTY=500 FOREGROUND=100
				 * GONE=1000 PERCEPTIBLE=130 SERVICE=300 ISIBLE=200
				 */
                Log.i(context.getPackageName(), "此appimportace ="
                        + appProcess.importance
                        + ",context.getClass().getName()="
                        + context.getClass().getName());
                if (appProcess.importance != ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    Log.i(context.getPackageName(), "处于后台" + appProcess.processName);
                    return true;
                } else {
                    Log.i(context.getPackageName(), "处于前台" + appProcess.processName);
                    return false;
                }
            }
        }
        return false;
    }
    /**
     * 判断是否有长按动作发生
     *
     * @param lastX         按下时X坐标
     * @param lastY         按下时Y坐标
     * @param thisX         移动时X坐标
     * @param thisY         移动时Y坐标
     * @param lastDownTime  按下时间
     * @param thisEventTime 移动时间
     * @param longPressTime 判断长按时间的阀值
     */
    private boolean ifLongPressed(float lastX, float lastY,
                                  float thisX, float thisY,
                                  long lastDownTime, long thisEventTime,
                                  long longPressTime) {
        float offsetX = Math.abs(thisX - lastX);
        float offsetY = Math.abs(thisY - lastY);
        long intervalTime = thisEventTime - lastDownTime;
        if (offsetX <= 10 && offsetY <= 10 && intervalTime >= longPressTime) {
            return true;
        }
        return false;
    }

    /**
     * dio转换成px
     * @param context
     * @param dp dp值
     * @return px 值
     */
    public static int dip2Px(Context context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static String getRandomColor() {
        String r, g, b;
        Random random = new Random();
        r = Integer.toHexString(random.nextInt(256)).toUpperCase();
        g = Integer.toHexString(random.nextInt(256)).toUpperCase();
        b = Integer.toHexString(random.nextInt(256)).toUpperCase();

        r = r.length() == 1 ? "0" + r : r;
        g = g.length() == 1 ? "0" + g : g;
        b = b.length() == 1 ? "0" + b : b;
        return "#" + r + g + b;
    }
}
