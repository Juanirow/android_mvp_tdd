package com.arteko.mvptdd.login;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.arteko.mvptdd.Injector;
import com.arteko.mvptdd.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by juancho on 13/05/16.
 */
public class LoginFragment extends Fragment implements LoginContract.View {

    private static final String TAG = "LoginFragment";
    @InjectView(R.id.input_email)
    EditText mInputEmail;

    @InjectView(R.id.input_password)
    EditText mInputPassword;

    private LoginContract.Actions mActionsListener;

    private ProgressDialog mProgressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;

        view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mActionsListener = new LoginPresenter(this, Injector.providesInteractor());
        this.mProgressDialog = new ProgressDialog(this.getActivity());
        this.mProgressDialog.setTitle(R.string.send_credentials);
        this.mProgressDialog.setMessage(getString(R.string.login_wait));
        this.mProgressDialog.setCancelable(false);
    }

    public static LoginFragment getInstance() {
        return new LoginFragment();
    }

    @Override
    public String getEmail() {
        return this.mInputEmail.getText().toString().trim();
    }

    @Override
    public void onLoginSuccess() {
        Log.d(TAG, "onLoginSuccess: ");
    }

    @Override
    public void onLoginError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
        builder.setIcon(android.R.drawable.ic_delete);
        builder.setTitle(R.string.error);
        builder.setMessage(R.string.error_wrong_credentials);
        builder.create().show();
    }

    @Override
    public void showProgressDialog() {
        this.mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        this.mProgressDialog.dismiss();
    }

    @Override
    public void onErrorEmailNull() {
        this.mInputEmail.setError(getString(R.string.not_null));
    }

    @Override
    public String getPassowrd() {
        return this.mInputPassword.getText().toString().trim();
    }

    @Override
    public void onErrorPasswordNull() {
        this.mInputPassword.setError(getString(R.string.not_null));
    }

    @OnClick(R.id.btn_login)
    public void onClickLoginBtn(){
        this.mActionsListener.onClickLoginButton();
    }

}
