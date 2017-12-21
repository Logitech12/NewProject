package com.bwie.newproject.view;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.bwie.newproject.R;
import com.bwie.newproject.fragment.FaFragment;
import com.bwie.newproject.fragment.FenFragment;
import com.bwie.newproject.fragment.GouFragment;
import com.bwie.newproject.fragment.MyFragment;
import com.bwie.newproject.fragment.ShouFragment;

/*
* 主界面--展示所有的Fragment
* */
public class ShowActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        shou();
        ActionBar bar = getSupportActionBar();
        bar.hide();
    }

    //进去展示的界面
    private void shou() {
        ShouFragment fragment1 = new ShouFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment1).commit();
        rb1.setBackgroundResource(R.drawable.ac1);
    }
    //点击事件的设置
    private void bai() {
        rb1.setBackgroundResource(R.drawable.ac0);
        rb2.setBackgroundResource(R.drawable.abw);
        rb3.setBackgroundResource(R.drawable.aby);
        rb4.setBackgroundResource(R.drawable.abu);
        rb5.setBackgroundResource(R.drawable.ac2);
    }

    private void initView() {
        rb1 = findViewById(R.id.rb1);
        rb1.setOnClickListener(this);
        rb2 = findViewById(R.id.rb2);
        rb2.setOnClickListener(this);
        rb3 = findViewById(R.id.rb3);
        rb3.setOnClickListener(this);
        rb4 = findViewById(R.id.rb4);
        rb4.setOnClickListener(this);
        rb5 = findViewById(R.id.rb5);
        rb5.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        int frag = getIntent().getIntExtra("frag", 0);
        if (frag == 5){
            bai();
            my();
        }
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        bai();
        switch (view.getId()) {
            case R.id.rb1:
                shou();
                break;
            case R.id.rb2:
                FenFragment fragment2 = new FenFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment2).commit();
                rb2.setBackgroundResource(R.drawable.abx);
                break;
            case R.id.rb3:
                FaFragment fragment3 = new FaFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment3).commit();
                rb3.setBackgroundResource(R.drawable.abz);
                break;
            case R.id.rb4:
                GouFragment fragment4 = new GouFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment4).commit();
                rb4.setBackgroundResource(R.drawable.abv);
                break;
            case R.id.rb5:
                my();
                break;
        }
    }

    private void my() {
        MyFragment fragment5 = new MyFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment5).commit();
        rb5.setBackgroundResource(R.drawable.ac3);
    }
}
