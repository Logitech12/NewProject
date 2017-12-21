package com.bwie.newproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.newproject.R;
import com.bwie.newproject.bean.GridBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/13.
 * 首页九宫格适配器
 */

public class GridShouAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<GridBean.DataBean> list;

    public GridShouAdapter(Context context, List<GridBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.gridshou, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        GridBean.DataBean dataBean = list.get(position);
        holder1.sdv.setImageURI(dataBean.getIcon());
        holder1.tv.setText(dataBean.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView sdv;
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.grid_sdv);
            tv = itemView.findViewById(R.id.grid_tv);
        }
    }
}
