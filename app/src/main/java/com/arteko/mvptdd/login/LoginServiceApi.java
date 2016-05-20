package com.arteko.mvptdd.login;

import android.os.Handler;

/**
 * Created by juancho on 19/05/16.
 */
public class LoginServiceApi implements ILoginServiceApi {

    @Override
    public void login(final String email, final String password, final OnLoginCallback listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(email.equals("email") && password.equals("password")){
                    listener.onSuccess();
                }
                else{
                    listener.onError();
                }
            }
        }, 2000);

    }
}
