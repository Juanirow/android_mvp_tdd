package com.arteko.mvptdd.login;

import android.os.Handler;

/**
 * Created by juancho on 19/05/16.
 */
public class FackeLogin implements ILoginServiceApi {

    @Override
    public void login(String email, String password, final OnLoginCallback listener) {

        final String fEmail = email;
        final String fPassword = password;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(fEmail.equals("test") && fPassword.equals("password")){
                    listener.onSuccess();
                }
                else{
                    listener.onError();
                }
            }
        }, 2000);

    }
}
