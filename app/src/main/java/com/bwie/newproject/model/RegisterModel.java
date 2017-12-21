package com.bwie.newproject.model;

import com.bwie.newproject.bean.RegisterBean;
import com.bwie.newproject.model.imodel.IRegisterModel;
import com.bwie.newproject.net.OnNetListener;
import com.bwie.newproject.net.RetrofitHelper;
import com.bwie.newproject.net.ServerApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by 乔晓慧 on 2017/12/15.
 */

public class RegisterModel implements IRegisterModel {
    @Override
    public void getRegister(final OnNetListener<RegisterBean> onNetListener, String phone, String pass) {
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.regist(phone,pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RegisterBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        onNetListener.onSuccess(registerBean);
                    }
                });
    }
}
