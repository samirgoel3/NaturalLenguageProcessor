package com.alejandrohall.android.naturallenguageprocessor.models;

/**
 * Created by alejandrohall on 21/02/16.
 */
public class SentimentResponse {

    private String label;
    private Probability probability;

    public String getLabel() {
        return label;
    }

    public Probability getProbability() {
        return probability;
    }
}
