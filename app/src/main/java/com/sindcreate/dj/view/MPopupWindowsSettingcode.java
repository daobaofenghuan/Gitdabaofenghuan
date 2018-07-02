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
import android.widget.TextView;

import com.sindcreate.dj.R;

/**
 * Created by Double on 2018/6/28.
 */
public class MPopupWindowsSettingcode extends PopupWindow {
    private static final int TAKE_PICTURE = 0x000000;
    public static final int SHOWIMG=1533;
    public MPopupWindowsSettingcode(final Context mContext, View parent, final Activity ac, final RelativeLayout chenjin) {

        super(mContext);

        View view = View
                .inflate(mContext, R.layout.item_popubwindows_changecode, null);
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
        TextView quxiaotext=view.findViewById(R.id.id_popu_quxiao);
        quxiaotext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chenjin.setVisibility(View.INVISIBLE);
                dismiss();
            }
        });

    }
}
