package com.alejandrohall.android.naturallenguageprocessor;

import com.alejandrohall.android.naturallenguageprocessor.models.StemmingResponse;

/**
 * Created by alejandrohall on 21/02/16.
 */
public interface Callback<T> {

    void onResponse(T response);
    void onError(Throwable e);

}
