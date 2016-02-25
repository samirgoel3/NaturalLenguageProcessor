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
import com.alejandrohall.android.naturallenguageprocessor.models.StemmingResponse;
import com.alejandrohall.android.naturallenguageprocessor.types.Language;
import com.alejandrohall.android.naturallenguageprocessor.types.StemmingAlgorithm;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class StemmFragment extends Fragment {

    @Bind(R.id.tvResultStemm)
    TextView mTvResultStemm;
    @Bind(R.id.etStemm)
    EditText mEtStemm;

    private NaturalLanguageProcessor naturalLanguageProcessor;


    public StemmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stemm, container, false);
        ButterKnife.bind(this, rootView);

        this.naturalLanguageProcessor = new NaturalLanguageProcessor();

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btnStemmText)
    public void onStemmTextClicked(){
        naturalLanguageProcessor.stem(mEtStemm.getText().toString(), Language.ENGLISH, StemmingAlgorithm.PORTER)
                .async(new Callback<StemmingResponse>() {
                    @Override
                    public void onResponse(StemmingResponse response) {
                        mTvResultStemm.setText(response.getText());
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
