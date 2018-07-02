package com.sindcreate.dj.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.sindcreate.dj.R;

/**
 * Created by Double on 2018/6/28.
 */
public class MPopupWindowsSetting extends PopupWindow {
    private static final int TAKE_PICTURE = 0x000000;
    public static final int SHOWIMG=1533;
    public MPopupWindowsSetting(final Context mContext, View parent, final Activity ac, final RelativeLayout chenjin) {

        super(mContext);

        View view = View
                .inflate(mContext, R.layout.item_popubwindowsdefaulet, null);
        view.startAnimation(AnimationUtils.loadAnimation(mContext,
               R.anim.fade_ins));
        LinearLayout ll_popup = (LinearLayout) view
                .findViewById(R.id.ll_popup);
        ll_popup.startAnimation(AnimationUtils.loadAnimation(mContext,
               R.anim.push_bottom_in_2));

        setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        setHeight(ViewGroup.LayoutParams.FILL_PARENT);
        setBackgroundDrawable(new BitmapDrawable());
        setFocusable(true);
        setOutsideTouchable(true);
        setContentView(view);
        showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        chenjin.setVisibility(View.VISIBLE);
        update();

        Button bt1 = (Button) view
                .findViewById(R.id.item_popupwindows_camera);
        Button bt2 = (Button) view
                .findViewById(R.id.item_popupwindows_Photo);
        Button bt3 = (Button) view
                .findViewById(R.id.item_popupwindows_cancel);
        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // photo();
                // dismiss();
                Intent intent = new Intent();
                Intent intent_camera = mContext.getPackageManager()
                        .getLaunchIntentForPackage("com.android.camera");
                if (intent_camera != null) {
                    intent.setPackage("com.android.camera");
                }
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                ac.startActivityForResult(intent,
                        TAKE_PICTURE);
                dismiss();
                chenjin.setVisibility(View.INVISIBLE);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chenjin.setVisibility(View.INVISIBLE);
                // Intent intent = new Intent(MainActivity.this,
                // TestPicActivity.class);
                // startActivity(intent);
                // dismiss();
					/*
					 * Intent intent = new Intent(Intent.ACTION_PICK,
					 * android.provider
					 * .MediaStore.Images.Media.EXTERNAL_CONTENT_URI
					 * );//调用android的图库 startActivity(intent); dismiss();
					 */
//                Intent intent = new Intent(ac,
//                        ScaleImageFromSdcardActivity.class);
//              ac.startActivityForResult(intent,
//                        SHOW_ALL_PICTURE);




//                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                intent.setType("image/*");
//                ac. startActivityForResult(intent, SHOWIMG);

                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                ac.startActivityForResult(intent, SHOWIMG);



                chenjin.setVisibility(View.INVISIBLE);

                dismiss();
                ac.overridePendingTransition(R.anim.in_from_right,
                        R.anim.out_to_left);// 设置切换动画，从右边进入，左边退出
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chenjin.setVisibility(View.INVISIBLE);
                dismiss();
            }
        });

    }
}
