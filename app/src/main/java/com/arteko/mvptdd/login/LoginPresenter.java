package com.arteko.mvptdd.login;

/**
 * Created by juancho on 13/05/16.
 */
public class LoginPresenter implements LoginContract.Actions {

    private LoginContract.View mView;
    private LoginContract.InteractorActions mInteractor;

    public LoginPresenter(LoginContract.View mView, LoginContract.InteractorActions mInteractor) {
        this.mView = mView;
        this.mInteractor = mInteractor;
    }

    @Override
    public void onClickLoginButton() {
        String email;
        String password;

        email = this.mView.getEmail();
        if(email.isEmpty()){
            this.mView.onErrorEmailNull();
            return;
        }

        password = this.mView.getPassowrd();
        if(password.isEmpty()){
            this.mView.onErrorPasswordNull();
            return;
        }
        this.mView.showProgressDialog();

        this.mInteractor.login(email, password, new ILoginServiceApi.OnLoginCallback() {
            @Override
            public void onSuccess() {
                mView.onLoginSuccess();
                mView.hideProgressDialog();
            }

            @Override
            public void onError() {
                mView.onLoginError();
                mView.hideProgressDialog();
            }
        });
    }
}
