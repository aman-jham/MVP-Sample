package com.examples.aman.mvpsample;

/**
 * Created by Snyxius Technologies on 7/4/2016.
 */
public class LoginPresenter implements ILoginPresenter,OnLoginFinishedListener {

    ILoginView view;
    AsyncValidateInteraction interaction;
    LoginPresenter(ILoginView view){
        this.view = view;
        interaction = new AsyncValidateInteraction();
    }

    @Override
    public void attemptLogin(String email, String password) {
        view.showProgress();
        interaction.validateCredentialsAsync(this,email,password);
    }

    @Override
    public void onError() {
        view.hideProgress();
        view.loginFailed();
    }

    @Override
    public void onSuccess() {
        view.hideProgress();
        view.navigateToListActivity();
    }

    @Override
    public void emptyEmail() {
        view.hideProgress();
        view.emptyEmail();
    }

    @Override
    public void emptyPassword() {
        view.hideProgress();
        view.emptyPassword();
    }

    @Override
    public void invalidFormatEmail() {
        view.hideProgress();
        view.invalidEmail();
    }
}
