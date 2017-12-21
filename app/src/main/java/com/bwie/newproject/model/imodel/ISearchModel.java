package com.bwie.newproject.model.imodel;

import com.bwie.newproject.bean.SearchBean;
import com.bwie.newproject.net.OnNetListener;

/**
 * Created by 乔晓慧 on 2017/12/15.
 */

public interface ISearchModel {
    public void getSearch(OnNetListener<SearchBean> onNetListener, String key);
}
