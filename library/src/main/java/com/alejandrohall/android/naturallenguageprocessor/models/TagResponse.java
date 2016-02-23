package com.alejandrohall.android.naturallenguageprocessor.models;

/**
 * Created by alejandrohall on 23/02/16.
 */
public class TagResponse {

    private String text;

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "TagResponse{" +
                "text='" + text + '\'' +
                '}';
    }
}
