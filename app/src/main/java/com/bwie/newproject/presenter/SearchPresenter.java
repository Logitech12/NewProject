package com.bwie.newproject.presenter;

import com.bwie.newproject.bean.SearchBean;
import com.bwie.newproject.model.SearchModel;
import com.bwie.newproject.model.imodel.ISearchModel;
import com.bwie.newproject.net.OnNetListener;
import com.bwie.newproject.view.iview.ISearchView;

/**
 * Created by 乔晓慧 on 2017/12/15.
 */

public class SearchPresenter {
    private ISearchModel iSearchModel;
    private ISearchView iSearchView;

    public SearchPresenter(ISearchView iSearchView) {
        this.iSearchView = iSearchView;
        iSearchModel = new SearchModel();
    }
    public void setSearch(String key){
        iSearchModel.getSearch(new OnNetListener<SearchBean>() {
            @Override
            public void onSuccess(SearchBean searchBean) {
                iSearchView.show(searchBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        }, key);
    }
}
