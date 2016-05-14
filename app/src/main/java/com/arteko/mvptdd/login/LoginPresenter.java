package com.arteko.mvptdd.login;

/**
 * Created by juancho on 13/05/16.
 */
public class LoginPresenter implements LoginContract.Actions {

    private LoginContract.View mView;
    private LoginInteractor mInteractor;

    public LoginPresenter(LoginContract.View mView, LoginInteractor mInteractor) {
        this.mView = mView;
        this.mInteractor = mInteractor;
    }

    @Override
    public void onClickLoginButton() {

    }
}
