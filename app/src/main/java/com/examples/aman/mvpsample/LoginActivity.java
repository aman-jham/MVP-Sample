package com.examples.aman.mvpsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView{


    LoginPresenter loginPresenter;
    @BindViews({R.id.email,R.id.password})
    List<EditText> list;
    @BindView(R.id.progress)
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
    }

    @OnClick(R.id.login) void submit(){
        loginPresenter.attemptLogin(list.get(0).getText().toString(),list.get(1).getText().toString());
    }


    @Override
    public void navigateToListActivity() {
        Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
            Toast.makeText(getApplicationContext(),"Invalid email or password",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void emptyEmail() {
        list.get(0).setError(getString(R.string.email_error));
        list.get(0).setFocusable(true);
    }

    @Override
    public void emptyPassword() {
        list.get(1).setError(getString(R.string.password_error));
        list.get(1).setFocusable(true);
    }

    @Override
    public void invalidEmail() {
        Toast.makeText(getApplicationContext(),getString(R.string.invalid_email),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }
}
