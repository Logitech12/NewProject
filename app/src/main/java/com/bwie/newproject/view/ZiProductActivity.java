package com.bwie.newproject.view;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bwie.newproject.R;
import com.bwie.newproject.adapter.ZiProductAdapter;
import com.bwie.newproject.bean.ZiProduct;
import com.bwie.newproject.presenter.ZiProductPresenter;
import com.bwie.newproject.view.iview.IZiProductActivity;

import java.util.List;
/*
* 子条目
* */
public class ZiProductActivity extends AppCompatActivity implements IZiProductActivity {
    private RecyclerView mPdRv;
    private ZiProductPresenter ziProductPresenter;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zi_product);
        initView();
        ActionBar bar = getSupportActionBar();
        bar.hide();
        Intent intent = getIntent();
        String pid = intent.getStringExtra("pid");
        Log.e("PID",pid);
        ziProductPresenter = new ZiProductPresenter(this);
        ziProductPresenter.setZiProduct(pid);
        mPdRv.setLayoutManager(new LinearLayoutManager(this));
        iv = findViewById(R.id.tit_sou);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ZiProductActivity.this, SearActivity.class);
                startActivity(intent1);
            }
        });
    }
    private void initView() {
        mPdRv = findViewById(R.id.zi_rv);
    }
    @Override
    public void shouZIProduct(ZiProduct ziProduct) {
        List<ZiProduct.DataBean> data = ziProduct.getData();
        ZiProductAdapter adapter = new ZiProductAdapter(this, data);
        mPdRv.setAdapter(adapter);
    }
}
