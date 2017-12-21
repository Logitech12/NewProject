package com.bwie.newproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.newproject.R;
import com.bwie.newproject.view.LoginActivity;
import com.bwie.newproject.view.MyActivity;
import com.bwie.newproject.widgth.MyApp;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by 乔晓慧 on 2017/12/12.
 * 我的
 */

public class MyFragment extends Fragment {
    private static final int RESULT_OK = -1;
    private TextView my_login;
    private TextView my_nickname;
    private SimpleDraweeView my_ximg;
    private ImageView my_img;
    private String nickname;
    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.my, null);
        my_nickname = view.findViewById(R.id.my_nickname);
        my_login = view.findViewById(R.id.my_login);
        my_ximg = view.findViewById(R.id.my_ximg);
        my_img = view.findViewById(R.id.my_img);
        info();
        into();
        return view;
    }
    public void into(){
        boolean isLogin = MyApp.sp.getBoolean("flag", false);
        if(isLogin){
            nickname = MyApp.sp.getString("name", "");
            my_nickname.setText(nickname+"");
            my_ximg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
    public void info(){
        boolean isLogin = MyApp.sp.getBoolean("flag", false);
        Log.e("-----",isLogin+"");
        if(isLogin){
            my_login.setVisibility(View.GONE);
            my_img.setVisibility(View.GONE);
            my_nickname.setVisibility(View.VISIBLE);
            my_ximg.setVisibility(View.VISIBLE);
            my_nickname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), MyActivity.class);
                    intent.putExtra("name",nickname);
                    startActivity(intent);
                }
            });

        }else{
            my_login.setVisibility(View.VISIBLE);
            my_img.setVisibility(View.VISIBLE);
            my_nickname.setVisibility(View.GONE);
            my_ximg.setVisibility(View.GONE);
            my_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            });
            my_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            });

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        into();
        info();
    }
}
