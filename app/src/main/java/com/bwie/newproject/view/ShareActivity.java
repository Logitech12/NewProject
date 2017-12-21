package com.bwie.newproject.view;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwie.newproject.R;
/*
* 进入APP等待页
* */
public class ShareActivity extends AppCompatActivity {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //判断接受i的值 如果== 0  自动跳转
            if (msg.what == 0) {
                Intent it = new Intent(ShareActivity.this, ShowActivity.class);
                startActivity(it);
                finish();
            }
        }
    };

    int i = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        new Thread() {
            public void run() {
                while (i >= 0) {
                    try {
                        //休眠1秒
                        sleep(1000);
                        i--;
                        //将i的值发送给handler
                        handler.sendEmptyMessage(i);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }
}
