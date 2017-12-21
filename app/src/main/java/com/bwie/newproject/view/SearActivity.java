package com.bwie.newproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.newproject.R;
/*
* 点击搜索框，第一个搜索页面
* */
public class SearActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mSear;
    /**
     * 搜索
     */
    private TextView mSousuo;
    private ImageView mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sear);
        initView();
        ActionBar bar = getSupportActionBar();
        bar.hide();
    }

    private void initView() {
        mSear = findViewById(R.id.sear);
        mSousuo = findViewById(R.id.sousuo);
        mSousuo.setOnClickListener(this);
        mBack = findViewById(R.id.back);
        mBack.setOnClickListener(this);
        mSear = findViewById(R.id.sear);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.sousuo:
                String s = mSear.getText().toString().trim();
                Intent intent = new Intent(this, SearchActivity.class);
                intent.putExtra("key", s);
                startActivity(intent);
                break;
            case R.id.back:
                this.finish();
                break;
        }
    }
}
