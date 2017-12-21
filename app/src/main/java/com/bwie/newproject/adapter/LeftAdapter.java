package com.bwie.newproject.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.newproject.R;
import com.bwie.newproject.bean.GridBean;

import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/13.
 * 分类左适配器
 */

public class LeftAdapter extends BaseAdapter {
    private Context context;
    private List<GridBean.DataBean> list;

    public LeftAdapter(Context context, List<GridBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder holder;
        if (view == null){
            holder = new MyViewHolder();
            view = View.inflate(context, R.layout.left,null);
            holder.tv = view.findViewById(R.id.left_tv);
            view.setTag(holder);
        } else {
            holder = (MyViewHolder) view.getTag();
        }
        GridBean.DataBean dataBean = list.get(i);
        holder.tv.setText(dataBean.getName());
        return view;
    }
    class MyViewHolder{
        TextView tv;
    }
}
