package com.bwie.newproject.model;

import com.bwie.newproject.bean.SearchBean;
import com.bwie.newproject.model.imodel.ISearchModel;
import com.bwie.newproject.net.OnNetListener;
import com.bwie.newproject.net.RetrofitHelper;
import com.bwie.newproject.net.ServerApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 乔晓慧 on 2017/12/15.
 */

public class SearchModel implements ISearchModel {
    public void getSearch(final OnNetListener<SearchBean> onNetListener, String key){
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.search(key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SearchBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(SearchBean searchBean) {
                        onNetListener.onSuccess(searchBean);
                    }
                });
    }
}
