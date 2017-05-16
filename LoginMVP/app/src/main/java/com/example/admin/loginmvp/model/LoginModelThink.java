package com.example.admin.loginmvp.model;

import android.text.TextUtils;

import com.example.admin.loginmvp.persenter.LoginPreModel;

/**
 * Date：2017/5/16
 * author: 曹政杰Administrator.
 * function：
 */

public class LoginModelThink implements LoginModel {

    @Override
    public void login(String name, LoginPreModel preModel) {
                               if(TextUtils.isEmpty(name)){
                                          preModel.IsFalseName();
                               } else{
                                   preModel.IsTrueName();
                               }
    }
}
