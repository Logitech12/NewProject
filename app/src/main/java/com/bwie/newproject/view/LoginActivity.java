package com.bwie.newproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.newproject.R;
import com.bwie.newproject.bean.LoginBean;
import com.bwie.newproject.presenter.LoginPresenter;
import com.bwie.newproject.view.iview.ILoginActivity;
import com.bwie.newproject.widgth.MyApp;

/*
* 登录
* */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener,ILoginActivity {

    /**
     * 请输入账号
     */
    private EditText mAccont;
    /**
     * 请输入密码
     */
    private EditText mPass;
    /**
     * 登录
     */
    private Button mLogin;
    /**
     * 请注册
     */
    private TextView mRegist;
    private LoginPresenter loginPresenter;
    String codes;
    String msgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        ActionBar bar = getSupportActionBar();
        bar.hide();
        loginPresenter = new LoginPresenter(this);
    }

    private void initView() {
        mAccont = findViewById(R.id.accont);
        mPass = findViewById(R.id.pass);
        mLogin = findViewById(R.id.login);
        mLogin.setOnClickListener(this);
        mRegist = findViewById(R.id.regist);
        mRegist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login:
                String phone = mAccont.getText().toString().trim();
                String pass = mPass.getText().toString().trim();
                loginPresenter.setLogin(phone,pass);
                Intent intent = new Intent(this, ShowActivity.class);
                intent.putExtra("frag",5);
                startActivity(intent);
                break;
            case R.id.regist:
                Intent intent1 = new Intent(this, RegisterActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void showLogin(LoginBean loginBean,String code,String msg) {
        codes = code;
        msgs = msg;
        if (codes.equals("0")){
            Toast.makeText(this,msgs,Toast.LENGTH_SHORT).show();
            LoginBean.DataBean data = loginBean.getData();
            int uid = data.getUid();
            String name = data.getUsername();
            String token = data.getToken();
            MyApp.edit.putInt("uid",uid);
            MyApp.edit.putString("name",name);
            MyApp.edit.putString("token",token);
            MyApp.edit.putBoolean("flag",true);
            MyApp.edit.commit();
            finish();
        } else {
            MyApp.edit.putBoolean("flag",false);
            MyApp.edit.commit();
            Toast.makeText(this,msgs,Toast.LENGTH_SHORT).show();
        }
    }
}