package com.arteko.mvptdd.login;

/**
 * Created by juancho on 19/05/16.
 */
public interface ILoginServiceApi {

    interface OnLoginCallback {

        void onSuccess();

        void onError();
    }


    void login(final String email, final String password, OnLoginCallback listener);
}
