package com.bwie.newproject.presenter;

import com.bwie.newproject.bean.RegisterBean;
import com.bwie.newproject.model.RegisterModel;
import com.bwie.newproject.model.imodel.IRegisterModel;
import com.bwie.newproject.net.OnNetListener;
import com.bwie.newproject.view.iview.IRegisterActivity;

/**
 * Created by 乔晓慧 on 2017/12/15.
 * 注册
 */

public class RegisterPresenter {
    private IRegisterModel iRegisterModel;
    private IRegisterActivity iRegisterActivity;

    public RegisterPresenter(IRegisterActivity iRegisterActivity) {
        this.iRegisterActivity = iRegisterActivity;
        iRegisterModel = new RegisterModel();
    }
    public void setRegist(String phone,String pass){
        iRegisterModel.getRegister(new OnNetListener<RegisterBean>() {
            @Override
            public void onSuccess(RegisterBean registerBean) {
                String code = registerBean.getCode();
                String msg = registerBean.getMsg();
                iRegisterActivity.showRegister(code,msg);
            }

            @Override
            public void onFailure(Exception e) {

            }
        }, phone, pass);
    }
}
