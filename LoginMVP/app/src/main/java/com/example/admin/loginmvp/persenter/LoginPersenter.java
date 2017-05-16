package com.example.admin.loginmvp.persenter;

import com.example.admin.loginmvp.model.LoginModel;
import com.example.admin.loginmvp.model.LoginModelThink;
import com.example.admin.loginmvp.view.LoginView;

/**
 * Date：2017/5/16
 * author: 曹政杰Administrator.
 * function：
 */

public class LoginPersenter implements  LoginPerView,LoginPreModel {
                      private LoginView loginview;
                      private LoginModel loginModel;
    public LoginPersenter(LoginView loginview) {
        this.loginview = loginview;
        this.loginModel=new LoginModelThink();
    }

    @Override
    public void getName(String name) {
                      loginModel.login(name,this);
    }

    @Override
    public void onDestroy() {
                   loginview=null;
    }

    @Override
    public void IsTrueName() {
               if(loginview!=null){
                   loginview.IsRightName();
               }
    }

    @Override
    public void IsFalseName() {
                 if(loginview!=null){
                     loginview.IsErrorName();
                 }
    }

    @Override
    public void onsuccess() {

    }
}
