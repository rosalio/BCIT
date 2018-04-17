package com.comp3617.assignment3;

import android.util.Log;

import java.io.Serializable;

public abstract class Callback<T> implements Serializable {

    public abstract void onSuccess(T result);

    public void onError(Throwable error) {
        if (error != null) {
            Log.d("Error", String.format("Exception %s during callback", error.getMessage()));
        }
    }

}
