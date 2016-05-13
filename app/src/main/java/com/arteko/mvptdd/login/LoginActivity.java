package com.arteko.mvptdd.login;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.arteko.mvptdd.R;

/**
 * Created by juancho on 13/05/16.
 */
public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(savedInstanceState == null){
            this.initFragment();
        }
    }

    private void initFragment() {
        FragmentManager manager;
        FragmentTransaction transaction;

        manager = this.getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.content_fragment, LoginFragment.getInstance());
        transaction.commit();
    }
}
