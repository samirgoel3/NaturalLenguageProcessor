package com.alejandrohall.android.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.alejandrohall.android.R;
import com.alejandrohall.android.naturallenguageprocessor.NaturalLanguageProcessor;
import com.alejandrohall.android.naturallenguageprocessor.callback.Callback;
import com.alejandrohall.android.naturallenguageprocessor.models.SentimentResponse;
import com.alejandrohall.android.naturallenguageprocessor.models.StemmingResponse;
import com.alejandrohall.android.naturallenguageprocessor.types.Language;
import com.alejandrohall.android.naturallenguageprocessor.types.StemmingAlgorithm;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SentimentFragment extends Fragment {

    @Bind(R.id.tvResultSentiment)
    TextView mTvResultSentiment;
    @Bind(R.id.etSentiment)
    EditText mEtSentiment;

    private NaturalLanguageProcessor naturalLanguageProcessor;


    public SentimentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sentiment, container, false);
        ButterKnife.bind(this, rootView);

        this.naturalLanguageProcessor = new NaturalLanguageProcessor();

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btnSentimentText)
    public void onSentimentTextClicked(){
        naturalLanguageProcessor.sentiment(mEtSentiment.getText().toString(), Language.ENGLISH)
                .async(new Callback<SentimentResponse>() {
                    @Override
                    public void onResponse(SentimentResponse response) {
                        mTvResultSentiment.setText(response.toString());
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        //handle failure
                    }

                    @Override
                    public void onError(Throwable e) {
                        //handle error
                    }
                });
    }
}
