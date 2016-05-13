package com.arteko.mvptdd.login;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.arteko.mvptdd.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by juancho on 13/05/16.
 */
public class LoginFragment extends Fragment {

    @InjectView(R.id.input_email)
    EditText mInputEmail;

    @InjectView(R.id.input_password)
    EditText mInputPassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;

        view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.inject(this, view);
        return view;
    }
}
