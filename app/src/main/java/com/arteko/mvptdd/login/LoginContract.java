package com.arteko.mvptdd.login;

/**
 * Created by juancho on 13/05/16.
 */
public class LoginContract {

    public interface View {

        String getEmail();

        void onErrorEmailNull();
    }

    public interface Actions{

        void onClickLoginButton();
    }
}
