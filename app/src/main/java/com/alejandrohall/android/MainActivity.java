package com.alejandrohall.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alejandrohall.android.naturallenguageprocessor.Callback;
import com.alejandrohall.android.naturallenguageprocessor.NaturalLanguageProcessor;
import com.alejandrohall.android.naturallenguageprocessor.models.StemmingResponse;
import com.alejandrohall.android.naturallenguageprocessor.types.Language;
import com.alejandrohall.android.naturallenguageprocessor.types.StemmingAlgorithm;

public class MainActivity extends AppCompatActivity {


    private EditText etText;
    private TextView tvResult;
    private Button btnStem;

    private NaturalLanguageProcessor nlp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = (EditText) findViewById(R.id.etText);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnStem = (Button) findViewById(R.id.btStem);
        nlp = new NaturalLanguageProcessor();

        btnStem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nlp.stem(etText.getText().toString(), Language.ENGLISH, StemmingAlgorithm.PORTER)
                        .async(new Callback<StemmingResponse>() {
                            @Override
                            public void onResponse(StemmingResponse response) {
                                tvResult.setText(response.getText());
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });
            }
        });
    }
}
