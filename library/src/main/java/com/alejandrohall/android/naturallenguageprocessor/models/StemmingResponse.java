package com.alejandrohall.android.naturallenguageprocessor.models;

/**
 * Created by alejandrohall on 20/02/16.
 */
public class StemmingResponse {

    private String text;

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "StemmingResponse{" +
                "text='" + text + '\'' +
                '}';
    }
}
