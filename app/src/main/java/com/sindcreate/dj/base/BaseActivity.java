package com.sindcreate.dj.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sindcreate.dj.R;

import java.nio.Buffer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Double on 2018/6/7.
 */

public class BaseActivity extends AppCompatActivity {
@BindView(R.id.id_title_text)
  public  TextView titletext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @OnClick(R.id.id_title_back)
    public  void  goback(View v){
        finish();
    }

}
