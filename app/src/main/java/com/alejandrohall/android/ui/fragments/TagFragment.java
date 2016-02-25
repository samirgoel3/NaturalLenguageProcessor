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
import com.alejandrohall.android.naturallenguageprocessor.models.TagResponse;
import com.alejandrohall.android.naturallenguageprocessor.types.Language;
import com.alejandrohall.android.naturallenguageprocessor.types.Output;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TagFragment extends Fragment {

    @Bind(R.id.tvResultTag)
    TextView mTvResultTag;
    @Bind(R.id.etTag)
    EditText mEtTag;

    private NaturalLanguageProcessor naturalLanguageProcessor;


    public TagFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tag, container, false);
        ButterKnife.bind(this, rootView);

        this.naturalLanguageProcessor = new NaturalLanguageProcessor();

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btnTagText)
    public void onTagTextClicked(){
        naturalLanguageProcessor.tag(mEtTag.getText().toString(), Language.ENGLISH, Output.SEXPR)
                .async(new Callback<TagResponse>() {
                    @Override
                    public void onResponse(TagResponse response) {
                        mTvResultTag.setText(response.getText());
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
