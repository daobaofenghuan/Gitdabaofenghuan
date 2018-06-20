package com.sindcreate.dj.fragment.myindex;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sindcreate.dj.DataMocker;
import com.sindcreate.dj.MainActivity;
import com.sindcreate.dj.R;
import com.sindcreate.dj.base.basecell.Cell;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.cell.defautcell.BannerCell;
import com.sindcreate.dj.cell.homemaincell.Part_Event;
import com.sindcreate.dj.cell.homemaincell.Part_Event2;
import com.sindcreate.dj.cell.homemaincell.Part_Event_edu;
import com.sindcreate.dj.cell.homemaincell.Part_EveryDayHomework;
import com.sindcreate.dj.cell.homemaincell.Part_EveryDayLesson;
import com.sindcreate.dj.cell.homemaincell.Part_Showresult;
import com.sindcreate.dj.cell.homemaincell.Partone;
import com.sindcreate.dj.fragment.AbsBaseFragment;
import com.sindcreate.dj.fragment.myindex.colectcell.Colect_Part1;
import com.sindcreate.dj.fragment.myindex.colectcell.Colect_Part2;
import com.sindcreate.dj.fragment.myindex.colectcell.Colect_Part_empbig;
import com.sindcreate.dj.fragment.myindex.colectcell.Colect_Part_empsm;
import com.sindcreate.dj.model.Entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sindcreate.dj.DataMocker.mockData;

/**
 * Created by Double on 2018/5/22.
 */
@RequiresApi(api = Build.VERSION_CODES.M)
public class ColectFragment extends AbsBaseFragment<Entry> {
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


    private void loadMore(){
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoadMore();
            //    mBaseAdapter.addAll(getCells(mockMoreData()));

            }
        },10000);
    }

    protected List<Cell> getCells(List<Entry> entries){
        //根据实体生成Cell
        List<Cell> cells = new ArrayList<>();
        cells.add(new Colect_Part1(null));
        cells.add(new Colect_Part2(null));
        cells.add(new Colect_Part_empbig(null));
        cells.add(new Colect_Part1(null));
        cells.add(new Colect_Part2(null));
        cells.add(new Colect_Part_empsm(null));
        cells.add(new Colect_Part2(null));
        cells.add(new Colect_Part_empsm(null));
        cells.add(new Colect_Part2(null));
        cells.add(new Colect_Part_empsm(null));
        cells.add(new Colect_Part2(null));
        return cells;
    }



    @Override
    public View addToolbar() {



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


