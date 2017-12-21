package com.bwie.newproject.model.imodel;

import com.bwie.newproject.bean.GridBean;
import com.bwie.newproject.bean.ShouBean;
import com.bwie.newproject.net.OnNetListener;

/**
 * Created by 乔晓慧 on 2017/12/13.
 */

public interface IShouModel {
    public void bannner(OnNetListener<ShouBean> onNetListener);
    public void grid(OnNetListener<GridBean> onNetListener);
}
