package com.bwie.newproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.newproject.R;
import com.bwie.newproject.adapter.DetailAdapter;
import com.bwie.newproject.bean.AddCartBean;
import com.bwie.newproject.bean.ProductDetailBean;
import com.bwie.newproject.presenter.ProductDetailPresenter;
import com.bwie.newproject.view.iview.IProductDetailActivity;
import com.bwie.newproject.widgth.MyApp;

import java.util.ArrayList;
import java.util.List;

/*
* 商品详情
* */
public class ProductDetailActivity extends AppCompatActivity implements IProductDetailActivity {

    private ProductDetailPresenter productDetailPresenter;
    private RecyclerView mPdRv;
    private List<ProductDetailBean.DataBean> list;
    private TextView add;
    private int uid;
    private String pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        initView();
        ActionBar bar = getSupportActionBar();
        bar.hide();
        productDetailPresenter = new ProductDetailPresenter(this);
        list = new ArrayList<>();
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        Log.e("PID", pid + "");
        productDetailPresenter.setDetail(pid);
        mPdRv.setLayoutManager(new LinearLayoutManager(this));
        uid = MyApp.sp.getInt("uid", 0);
        productDetailPresenter.setAddCart(uid+"",pid);
    }

    private void initView() {
        mPdRv = findViewById(R.id.de_rv);
        add = findViewById(R.id.de_add);
    }
    @Override
    public void shouDetail(ProductDetailBean detailBean) {
        ProductDetailBean.DataBean data = detailBean.getData();
        list.add(data);
        DetailAdapter adapter = new DetailAdapter(this, list);
        mPdRv.setAdapter(adapter);
    }

    @Override
    public void shouAddCart(final AddCartBean addCartBean) {
        final String code = addCartBean.getCode();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (code.equals("0")){
                    Toast.makeText(ProductDetailActivity.this,addCartBean.getMsg()+"",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ProductDetailActivity.this,addCartBean.getMsg()+"",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
