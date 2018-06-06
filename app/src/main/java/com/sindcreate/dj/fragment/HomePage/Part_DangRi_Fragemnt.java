package com.sindcreate.dj.fragment.HomePage;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.sindcreate.dj.MainActivity;
import com.sindcreate.dj.R;
import com.sindcreate.dj.base.Cell;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.fragment.AbsBaseFragment;
import com.sindcreate.dj.fragment.HomePage.DangRicell.Drangri_Part1;
import com.sindcreate.dj.fragment.HomePage.DangRicell.Drangri_Part2;
import com.sindcreate.dj.fragment.HomePage.DangRicell.Drangri_Part3;
import com.sindcreate.dj.fragment.HomePage.DangRicell.Drangri_title;
import com.sindcreate.dj.model.Entry;

import java.util.ArrayList;
import java.util.List;

import static com.sindcreate.dj.DataMocker.mockData;
import static com.sindcreate.dj.DataMocker.mockMoreData;

/**
 * Created by Double on 2018/5/22.
 */
@RequiresApi(api = Build.VERSION_CODES.M)
public class Part_DangRi_Fragemnt extends AbsBaseFragment<Entry> {
    @Override
    public void onRecyclerViewInitialized() {
        //初始化View和数据加载
        //设置刷新进度条颜色
        setColorSchemeResources(R.color.colorAccent);
        loadData();
    }

    @Override
    public void onPullRefresh() {
        //下拉刷新回调
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                setRefreshing(false);
            }
        },2000);
    }

    @Override
    public void onLoadMore() {
        //上拉加载回调
        loadMore();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.rv_base_fragment_layout2,null);



        return view;
    }

    private void loadMore(){
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoadMore();
                mBaseAdapter.addAll(getCells(mockMoreData()));

            }
        },10000);
    }

    protected List<Cell> getCells(List<Entry> entries){
        //根据实体生成Cell
        List<Cell> cells = new ArrayList<>();
       cells.add(new Drangri_title(null));
        cells.add(new Drangri_Part1(null));
        cells.add(new Drangri_Part2(null));
        cells.add(new Drangri_Part3(null));
        cells.add(new Drangri_Part2(null));
        cells.add(new Drangri_Part3(null));
        cells.add(new Drangri_Part2(null));
        cells.add(new Drangri_Part3(null));

        return cells;
    }



    @Override
    public View addToolbar() {
        View toolbar = LayoutInflater.from(getContext()).inflate(R.layout.title_show,null);





        return null;
    }

    /**
     * 模拟从服务器取数据
     */
    private void loadData(){
        View loadingView = LayoutInflater.from(getContext()).inflate(R.layout.manu_loading_layout,null);
        mBaseAdapter.showLoading(loadingView);
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mBaseAdapter.hideLoading();
                mBaseAdapter.addAll(getCells(mockData()));
            }
        },20);
    }
}


