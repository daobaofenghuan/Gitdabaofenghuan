package com.sindcreate.dj.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.sindcreate.dj.MainActivity;
import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.recycleradapter.ApplyforHelpAdapter;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.view.MPopupWindows;
import com.sindcreate.dj.view.MPopupWindows2;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ApplyForHelpActivity extends BaseActivity {
    private static final int TAKE_PICTURE = 0x000000;
    private static final int SHOW_CAMERA = 0x000001;
    private static final int SHOW_CAMERA_RESULT = 0x000002;
    public static final int SHOW_ALL_PICTURE = 0x14;// 查看图片
    public static final int SHOW_PICTURE_RESULT = 0x15;// 查看图片返回
    public static final int CLOSE_INPUT = 0x01;// 关闭软键盘
    String tupian = "";
    @BindView(R.id.id_forhelp_picly)
    RelativeLayout picly;
    @BindView(R.id.recycler_view)
    RecyclerView listv;
    ApplyforHelpAdapter adapter;
    List<Bitmap> listdata = new ArrayList<>();
    @SuppressLint("HandlerLeak")
    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MsgNum.OK) {
                int postion = (int) msg.obj;
                listdata.remove(postion);
                adapter.notifyDataSetChanged();


            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applyforhelp);
        StatusBarUtils.setWindowStatusBarColor(ApplyForHelpActivity.this, R.color.dj_titalred);
        ButterKnife.bind(this);
      //  ImmersionBar.with(this).init();
        GridLayoutManager manager = new GridLayoutManager(this, 6, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        Mydata.helphandler = mhandler;
        listv.setLayoutManager(manager);
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.icon_test_xiangji);

//listdata.add(bitmap);
//listdata.add(bitmap);
        listdata.add(bitmap);
        adapter = new ApplyforHelpAdapter(this, listdata);
        listv.setAdapter(adapter);
//        View view2 = getLayoutInflater().inflate(R.layout.item_applyforhelp_xiangji,null);
//        listv.addFooterView(view2);


    }

    @OnClick({R.id.id_forhelp_picly})
    public void viewclich(View v) {
        switch (v.getId()) {
            case R.id.id_forhelp_picly:
                System.out.println("照片");
                MPopupWindows mPopupWindows = new MPopupWindows(this, picly, this);
//                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                    //透明状态栏
//                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//                    //透明导航栏
//                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//                }else{
//                    StatusBarUtils.setWindowStatusBarColor(ApplyForHelpActivity.this, R.color.dj_login_red1);}

                break;

        }


    }


    @SuppressLint("WrongConstant")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PICTURE && resultCode == Activity.RESULT_OK
                && null != data) {
            if (!Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                //   Toast.makeText(GroupMainActivity.this, "未找到SDK", 1).show();
                return;
            }
            new android.text.format.DateFormat();
            String name = android.text.format.DateFormat.format(
                    "yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA))
                    + ".jpg";
            Bundle bundle = data.getExtras();
            // 获取相机返回的数据，并转换为图片格式
            final Bitmap bitmap;
            String filename = null;
            bitmap = (Bitmap) bundle.get("data");


//            FileOutputStream fout = null;
//            // 定义文件存储路径
//            File file = new File("/sdcard/cloudteam/");
//            if (!file.exists()) {
//                file.mkdirs();
//            }
//            filename = file.getPath() + "/" + name;
//            try {
//                fout = new FileOutputStream(filename);
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fout);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    fout.flush();
//                    fout.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            Intent intent = new Intent(GroupMainActivity.this,
//                    ZhuangTai.class);
//            intent.putExtra("camera", filename);
//            intent.putExtra("picdata",tupian);
//            GroupMainActivity.this.startActivityForResult(intent,
//                    SHOW_CAMERA);
            Message msg = Message.obtain();
            msg.what = 20001;
            msg.obj = tupian;
            mhandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    List<Bitmap> listdata2 = new ArrayList<>();
                    listdata2.add(bitmap);
                    listdata.addAll(listdata2);
                    adapter.notifyDataSetChanged();


                }
            }, 300);
        } else if (requestCode == SHOW_CAMERA
                && resultCode == SHOW_CAMERA_RESULT) {
            Bundle bundle = data.getExtras();
            Object camera = bundle.get("imgUrl");

            // TODO 新起线程发送图片
            final String camera2 = camera.toString();


            // 将图片发送到聊天界面
            if (camera.toString().length() > 0) {

            }
        }
    }


}
