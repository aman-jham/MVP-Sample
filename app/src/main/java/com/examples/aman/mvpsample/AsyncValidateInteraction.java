package com.examples.aman.mvpsample;

import android.os.Handler;

/**
 * Created by Snyxius Technologies on 7/4/2016.
 */
public class AsyncValidateInteraction  implements IAsyncLoginInteraction{


    @Override
    public void validateCredentialsAsync(final OnLoginFinishedListener onLoginFinishedListener, final String email, final String password) {


        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                if (email.isEmpty()) {
                    onLoginFinishedListener.emptyEmail();
                } else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    onLoginFinishedListener.invalidFormatEmail();
                } else if (password.isEmpty()) {
                    onLoginFinishedListener.emptyPassword();
                } else {
                    onLoginFinishedListener.onSuccess();
                }
            }
        }, 2000);



    }
}
