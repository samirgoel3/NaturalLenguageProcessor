package com.alejandrohall.android.naturallenguageprocessor;

import android.util.Log;

import com.alejandrohall.android.naturallenguageprocessor.models.StemmingResponse;

import java.io.IOException;

import retrofit2.Response;

/**
 * Created by alejandrohall on 21/02/16.
 */
public class Call<T> {

    private retrofit2.Call<T> retrofitCall;

    public Call(retrofit2.Call<T> retrofitCall){
        this.retrofitCall = retrofitCall;
    }

    public T sync(){
        T response = null;

        try {
            response = retrofitCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public void async(final Callback<T> callback){
        retrofitCall.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(retrofit2.Call<T> call, Response<T> response) {
                callback.onResponse(response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<T> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
