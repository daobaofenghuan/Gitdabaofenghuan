package com.sindcreate.dj.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sindcreate.dj.R;
import com.sindcreate.dj.view.MyCircleImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/25.
 */

public class QuestionAdapter2 extends RecyclerView.Adapter<QuestionAdapter2.ViewHolder> {
    private Context mContext;
    private List<String> data;
    private OnClickListener onClickListener;

    private boolean isAll = false;
    private final int initNum = 28;

    public QuestionAdapter2(Context mContext, List<String> data) {
        this.mContext = mContext;
        this.data = data;
    }

    public void setIsAll() {
        isAll = !isAll;
        notifyDataSetChanged();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_chat_icon, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (getItemCount() - 2 == position) {
            Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516894569092&di=d6bbe155c4ea35a47ab75dd12d689e28&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D1403273024%2C1983123635%26fm%3D214%26gp%3D0.jpg").into(holder.imgHeader);
            holder.tvName.setText("");
            holder.itemAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onClickListener != null) {
                        onClickListener.onAddClick();
                    }
                }
            });
        } else if (getItemCount() - 1 == position) {
            Glide.with(mContext).load("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4096081551,1012270188&fm=27&gp=0.jpg").into(holder.imgHeader);
            holder.tvName.setText("");
            holder.itemAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onClickListener != null) {
                        onClickListener.onDeleteClick();
                    }
                }
            });
        } else {
            Glide.with(mContext).load(data.get(position)).into(holder.imgHeader);
            holder.tvName.setText(data.get(position));
            holder.itemAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onClickListener != null) {
                        onClickListener.onItemClick(position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (isAll) {
            return data.size() + 2;
        } else {
            return data.size() > initNum ? initNum + 2 : data.size() + 2;
        }

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_header)
        MyCircleImageView imgHeader;
        @BindView(R.id.item_all)
        LinearLayout itemAll;
        @BindView(R.id.tv_name)
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnClickListener {
        void onItemClick(int position);

        void onAddClick();

        void onDeleteClick();
    }
}
