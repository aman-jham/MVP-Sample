package com.examples.aman.mvpsample;

/**
 * Created by Snyxius Technologies on 7/4/2016.
 */
public interface IAsyncLoginInteraction {
    void validateCredentialsAsync(OnLoginFinishedListener onLoginFinishedListener, String email, String password);
}
