package com.examples.aman.mvpsample;

/**
 * Created by jpotts18 on 5/11/15.
 */
public interface OnLoginFinishedListener {
    void onError();
    void onSuccess();
    void emptyEmail();
    void emptyPassword();
    void invalidFormatEmail();
}
