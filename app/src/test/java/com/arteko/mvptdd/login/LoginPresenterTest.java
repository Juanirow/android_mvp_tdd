package com.arteko.mvptdd.login;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Created by juancho on 13/05/16.
 */
public class LoginPresenterTest {

    @Mock
    LoginInteractor mInteractor;

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
}