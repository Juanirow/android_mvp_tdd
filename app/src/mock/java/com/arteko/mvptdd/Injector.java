package com.arteko.mvptdd;

import com.arteko.mvptdd.login.FackeLogin;
import com.arteko.mvptdd.login.LoginContract;
import com.arteko.mvptdd.login.LoginInteractor;

/**
 * Created by juancho on 19/05/16.
 */
public class Injector {

    public static LoginContract.InteractorActions providesInteractor(){
        return LoginInteractor.getInstace(new FackeLogin());
    }
}
