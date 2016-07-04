package com.examples.aman.mvpsample;

/**
 * Created by Snyxius Technologies on 7/4/2016.
 */
public interface ILoginView {
    void navigateToListActivity();
    void loginFailed();
    void emptyEmail();
    void emptyPassword();
    void invalidEmail();
    void showProgress();
    void hideProgress();
}
