package com.arteko.mvptdd.login;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Created by juancho on 13/05/16.
 */
public class LoginPresenterTest {

    @Mock
    LoginContract.InteractorActions mInteractor;

    @Mock
    LoginContract.View mView;

    LoginPresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        this.mPresenter = new LoginPresenter(mView, mInteractor);
    }

    @Test
    public void shouldShowErrorEmailNull() throws Exception {
        Mockito.when(this.mView.getEmail()).thenReturn("");
        this.mPresenter.onClickLoginButton();
        Mockito.verify(this.mView).onErrorEmailNull();
    }

    @Test
    public void shouldShowErrorPasswordNull() throws Exception {
        Mockito.when(this.mView.getEmail()).thenReturn("email");
        Mockito.when(this.mView.getPassowrd()).thenReturn("");
        this.mPresenter.onClickLoginButton();
        Mockito.verify(this.mView).onErrorPasswordNull();
    }

    @Test
    public void shouldShowAProgressWhenLoginRequestSend() throws Exception {
        Mockito.when(this.mView.getEmail()).thenReturn("email");
        Mockito.when(this.mView.getPassowrd()).thenReturn("password");
        this.mPresenter.onClickLoginButton();
        Mockito.verify(this.mView).showProgressDialog();
    }

    @Test
    public void shouldLoginReturnError() throws Exception {

        ArgumentCaptor<ILoginServiceApi.OnLoginCallback> callbackCaptor
                = ArgumentCaptor.forClass(ILoginServiceApi.OnLoginCallback.class);

        Mockito.when(this.mView.getEmail()).thenReturn("email");
        Mockito.when(this.mView.getPassowrd()).thenReturn("pass");
        this.mPresenter.onClickLoginButton();
        Mockito.verify(this.mView).showProgressDialog();

        Mockito.verify(mInteractor).login(
                Mockito.eq("email")
                , Mockito.eq("pass")
                , callbackCaptor.capture());

        callbackCaptor.getValue().onError();

        Mockito.verify(this.mView).onLoginError();
        Mockito.verify(this.mView).hideProgressDialog();
    }

    @Test
    public void shouldLoginReturnSuccess() throws Exception {

        ArgumentCaptor<ILoginServiceApi.OnLoginCallback> callbackCaptor
                = ArgumentCaptor.forClass(ILoginServiceApi.OnLoginCallback.class);

        Mockito.when(this.mView.getEmail()).thenReturn("email");
        Mockito.when(this.mView.getPassowrd()).thenReturn("password");
        this.mPresenter.onClickLoginButton();
        Mockito.verify(this.mView).showProgressDialog();

        Mockito.verify(mInteractor).login(
                Mockito.eq("email")
                , Mockito.eq("password")
                , callbackCaptor.capture());

        callbackCaptor.getValue().onSuccess();

        Mockito.verify(this.mView).onLoginSuccess();
        Mockito.verify(this.mView).hideProgressDialog();
    }
}
