package com.bwie.newproject.presenter;

import com.bwie.newproject.bean.LoginBean;
import com.bwie.newproject.model.LoginModel;
import com.bwie.newproject.model.imodel.ILoginModel;
import com.bwie.newproject.net.OnNetListener;
import com.bwie.newproject.view.iview.ILoginActivity;

/**
 * Created by 乔晓慧 on 2017/12/15.
 * 登录
 */

public class LoginPresenter {
    private ILoginModel iLoginModel;
    private ILoginActivity iLoginActivity;

    public LoginPresenter(ILoginActivity iLoginActivity) {
        this.iLoginActivity = iLoginActivity;
        iLoginModel = new LoginModel();
    }
    public void setLogin(String phone,String pass){
        iLoginModel.getLogin(new OnNetListener<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                String code = loginBean.getCode();
                String msg = loginBean.getMsg();
                iLoginActivity.showLogin(loginBean,code,msg);
            }

            @Override
            public void onFailure(Exception e) {

            }
        },phone,pass);
    }
}
