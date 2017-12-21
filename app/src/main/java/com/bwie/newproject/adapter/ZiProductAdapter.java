package com.bwie.newproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.newproject.R;
import com.bwie.newproject.bean.ProductDetailBean;
import com.bwie.newproject.bean.ZiProduct;
import com.bwie.newproject.view.ProductDetailActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/14.
 * 分类商品子条目适配器
 */

public class ZiProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ZiProduct.DataBean>  list;

    public ZiProductAdapter(Context context, List<ZiProduct.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.ziproduct, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        final ZiProduct.DataBean bean = list.get(position);
        String images = bean.getImages();
        String[] split = images.split("!");
        holder1.sdv.setImageURI(split[0]);
        holder1.name.setText(bean.getSubhead());
        holder1.price.setText("￥"+bean.getPrice());
        holder1.lin.setOnClickListener(new View.OnClickListener() {
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
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout lin;
        SimpleDraweeView sdv;
        TextView name;
        TextView price;

        public MyViewHolder(View itemView) {
            super(itemView);
            lin = itemView.findViewById(R.id.zi_li);
            sdv = itemView.findViewById(R.id.zi_sdv);
            name = itemView.findViewById(R.id.zi_tv1);
            price = itemView.findViewById(R.id.zi_price);
        }
    }
}
