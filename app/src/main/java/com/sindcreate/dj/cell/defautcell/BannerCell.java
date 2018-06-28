package com.sindcreate.dj.cell.defautcell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.adapter.CBPageAdapter;
import com.bigkoo.convenientbanner.adapter.CBViewHolderCreator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.sindcreate.dj.R;

import com.sindcreate.dj.base.basecell.RVBaseCell;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;


import java.util.List;

/**
 * Created by zhouwei on 17/2/7.
 */

public class BannerCell extends RVBaseCell<List<String>> {
    public static final int TYPE = 2;
    private ConvenientBanner mConvenientBanner;
    public BannerCell(List<String> strings) {
        super(strings);
    }

    @Override
    public int getItemType() {
        return TYPE;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell_layoout,null));
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {
       mConvenientBanner = (ConvenientBanner) holder.getView(R.id.banner);
        mConvenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }//后续添加指示器操作
        }, mData).setPointViewVisible(true)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.icon_yandian_right, R.mipmap.icon_wrong})
                //设置指示器的方向（左、中、右）
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                //设置手动影响（设置了该项无法手动切换）
                .setManualPageable(true);
        ;
        if(!mConvenientBanner.isTurning()){
            //设置自动切换（同时设置了切换时间间隔）
            mConvenientBanner.startTurning(2000);
        }
    }

    @Override
    public void releaseResource() {
        if(mConvenientBanner!=null){
            mConvenientBanner.stopTurning();
        }
    }

    public static class NetworkImageHolderView implements CBPageAdapter.Holder<String>{
        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {

            ImageLoader.getInstance().displayImage(data,imageView);
        }
    }
}
