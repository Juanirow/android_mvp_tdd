package com.arteko.mvptdd.login;

import android.os.Handler;

/**
 * Created by juancho on 13/05/16.
 */
public class LoginInteractor{

    public interface OnLoginCallback {

        void onSuccess();

        void onError();
    }

    public void login(final String email, final String password, final OnLoginCallback callback){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(email.equals("email") && password.equals("password")){
                    callback.onSuccess();
                }
                else{
                    callback.onError();
                }
            }
        }, 2000);
    }
}
