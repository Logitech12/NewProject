package com.bwie.newproject.model;

import com.bwie.newproject.bean.LoginBean;
import com.bwie.newproject.model.imodel.ILoginModel;
import com.bwie.newproject.net.OnNetListener;
import com.bwie.newproject.net.RetrofitHelper;
import com.bwie.newproject.net.ServerApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 乔晓慧 on 2017/12/15.
 * 登录请求数据
 */

public class LoginModel implements ILoginModel {
    public void getLogin(final OnNetListener<LoginBean> onNetListener, String phone, String pass){
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.login(phone,pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        onNetListener.onSuccess(loginBean);
                    }
                });
    }
}
