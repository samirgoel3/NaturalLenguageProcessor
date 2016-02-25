package com.alejandrohall.android.naturallenguageprocessor.callback;

import com.alejandrohall.android.naturallenguageprocessor.models.StemmingResponse;

/**
 * Created by alejandrohall on 21/02/16.
 */
public interface Callback<T> {

    void onResponse(T response);

    void onFailure(int errorCode, String errorMsg);

    void onError(Throwable e);

}
