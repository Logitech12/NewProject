package com.bwie.newproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.newproject.R;
import com.bwie.newproject.presenter.RegisterPresenter;
import com.bwie.newproject.view.iview.IRegisterActivity;
/*
* 注册
* */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,IRegisterActivity {

    /**
     * 请输入账号
     */
    private EditText raccont;
    /**
     * 请输入密码
     */
    private EditText rpass;
    /**
     * 注册
     */
    private Button register;
    private RegisterPresenter registerPresenter;
    String codes;
    String msgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        ActionBar bar = getSupportActionBar();
        bar.hide();
        registerPresenter = new RegisterPresenter(this);
    }

    private void initView() {
        raccont = findViewById(R.id.raccont);
        rpass = findViewById(R.id.rpass);
        register = findViewById(R.id.register);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.register:
                String phone = raccont.getText().toString().trim();
                String pass = rpass.getText().toString().trim();
                registerPresenter.setRegist(phone,pass);
                break;
        }
    }

    @Override
    public void showRegister(String code, String msg) {
        codes = code;
        msgs = msg;
        if (codes.equals("0")){
            Toast.makeText(this,msgs,Toast.LENGTH_SHORT).show();
            if (msgs.equals("注册成功")){
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        } else {
            Toast.makeText(this,msgs,Toast.LENGTH_SHORT).show();
        }
    }
}
