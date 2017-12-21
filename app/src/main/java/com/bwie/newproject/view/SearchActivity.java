package com.bwie.newproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bwie.newproject.R;
import com.bwie.newproject.adapter.SearchAdapter;
import com.bwie.newproject.bean.SearchBean;
import com.bwie.newproject.presenter.SearchPresenter;
import com.bwie.newproject.view.iview.ISearchView;
/*
* 点击搜索后，跳转到第二个搜索页面，展示搜索信息
* */
public class SearchActivity extends AppCompatActivity implements ISearchView, View.OnClickListener {

    private EditText mSearch;
    private RecyclerView mSouRv;
    private SearchPresenter searchPresenter;
    private ImageView mBacks;
    private ImageView mGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        ActionBar bar = getSupportActionBar();
        bar.hide();
        searchPresenter = new SearchPresenter(this);
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        searchPresenter.setSearch(key);
        mSearch.setText(key);
        mSouRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initView() {
        mSearch = findViewById(R.id.search);
        mSouRv = findViewById(R.id.sou_rv);
        mBacks = findViewById(R.id.backs);
        mBacks.setOnClickListener(this);
        mSearch = findViewById(R.id.search);
        mSearch.setOnClickListener(this);
        mGrid = findViewById(R.id.grid);
        mGrid.setOnClickListener(this);
        mSouRv = findViewById(R.id.sou_rv);
    }

    @Override
    public void show(SearchBean searchBean) {
        mSouRv.setAdapter(new SearchAdapter(this, searchBean.getData()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.backs:
                this.finish();
                break;
            case R.id.grid:
                mGrid.setImageResource(R.drawable.lin);
                break;
            case R.id.search:
                Intent intent = new Intent(this, SearActivity.class);
                startActivity(intent);
                break;
        }
    }
}
