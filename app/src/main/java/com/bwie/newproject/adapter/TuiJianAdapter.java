package com.bwie.newproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.newproject.R;
import com.bwie.newproject.bean.ShouBean;
import com.bwie.newproject.view.ProductDetailActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/16.
 */

public class TuiJianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ShouBean.TuijianBean.ListBean> list;

    public TuiJianAdapter(Context context, List<ShouBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.tuijian, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        final ShouBean.TuijianBean.ListBean bean = list.get(position);
        final String[] img = bean.getImages().split("\\|");
        holder1.sdv.setImageURI(img[0]);
        holder1.tv1.setText(bean.getSubhead());
        holder1.tv2.setText("￥:"+bean.getPrice());
        holder1.liear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra("pid",bean.getPid()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list == null){
            return 0;
        }
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout liear;
        SimpleDraweeView sdv;
        TextView tv1;
        TextView tv2;
        public MyViewHolder(View itemView) {
            super(itemView);
            liear = itemView.findViewById(R.id.liear);
            sdv = itemView.findViewById(R.id.tj_sdv);
            tv1 = itemView.findViewById(R.id.tj_tv1);
            tv2 = itemView.findViewById(R.id.tj_tv2);
        }
    }
}
