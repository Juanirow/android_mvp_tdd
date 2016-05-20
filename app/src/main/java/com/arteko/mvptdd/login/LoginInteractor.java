package com.arteko.mvptdd.login;

import android.os.Handler;
import android.support.annotation.NonNull;

/**
 * Created by juancho on 13/05/16.
 */
public class LoginInteractor implements LoginContract.InteractorActions{

    private static LoginInteractor  mInstance = null;

    private final ILoginServiceApi mServiceApi;

    public synchronized static LoginInteractor getInstace(ILoginServiceApi serviceApi){
        if(mInstance == null){
            mInstance = new LoginInteractor(serviceApi);
        }
        return mInstance;
    }

    public LoginInteractor(ILoginServiceApi mServiceApi) {
        this.mServiceApi = mServiceApi;
    }

    @Override
    public void login(String email, String password, ILoginServiceApi.OnLoginCallback listener) {
        this.mServiceApi.login(email, password, listener);
    }
}

