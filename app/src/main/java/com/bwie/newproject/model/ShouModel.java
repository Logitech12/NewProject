package com.bwie.newproject.model;

import com.bwie.newproject.bean.GridBean;
import com.bwie.newproject.bean.ShouBean;
import com.bwie.newproject.model.imodel.IShouModel;
import com.bwie.newproject.net.OnNetListener;
import com.bwie.newproject.net.RetrofitHelper;
import com.bwie.newproject.net.ServerApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 乔晓慧 on 2017/12/13.
 * 首页轮播图--推荐
 */

public class ShouModel implements IShouModel {
    //首页轮播
    public void bannner(final OnNetListener<ShouBean> onNetListener){
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.shou()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ShouBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //onNetListener.onFailure((Exception) e);
                        e.getMessage();
                    }

                    @Override
                    public void onNext(ShouBean shouBean) {
                        onNetListener.onSuccess(shouBean);
                    }
                });
    }

    //轮播下方九宫格
    @Override
    public void grid(final OnNetListener<GridBean> onNetListener) {
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.grid()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GridBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(GridBean gridBean) {
                        onNetListener.onSuccess(gridBean);
                    }
                });
    }
}
