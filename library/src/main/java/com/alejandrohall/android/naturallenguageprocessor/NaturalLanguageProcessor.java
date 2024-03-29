package com.alejandrohall.android.naturallenguageprocessor;

import com.alejandrohall.android.naturallenguageprocessor.api.NPLService;
import com.alejandrohall.android.naturallenguageprocessor.callback.Call;
import com.alejandrohall.android.naturallenguageprocessor.models.SentimentResponse;
import com.alejandrohall.android.naturallenguageprocessor.models.StemmingResponse;
import com.alejandrohall.android.naturallenguageprocessor.models.TagResponse;
import com.alejandrohall.android.naturallenguageprocessor.types.Language;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alejandrohall on 20/02/16.
 */
public class NaturalLanguageProcessor {

    private NPLService nplService;

    public NaturalLanguageProcessor(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://text-processing.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.nplService = retrofit.create(NPLService.class);
    }

    public Call<StemmingResponse> stem(String text, String language, String stemmerAlgorithm){
        checkStemParameters(text, language, stemmerAlgorithm);

        Call<StemmingResponse> result = new Call<>(nplService.stemText(text, language, stemmerAlgorithm));

        return result;
    }

    public Call<SentimentResponse> sentiment(String text, String language){
        checkSentimentParameters(text, language);

        Call<SentimentResponse> result = new Call<>(nplService.sentimentalAnalisysText(text, language));

        return result;
    }

    public Call<TagResponse> tag(String text, String language, String output){
        checkTagParameters(text, language, output);

        Call<TagResponse> result = new Call<>(nplService.tagText(text, language, output));

        return result;
    }



    //region Checkers
    private void checkStemParameters(String text, String language, String stemmerAlgorithm){
        if(text.isEmpty()){
            throw new IllegalArgumentException("Text cannot be empty");
        }else if(text.length() > 60000){
            throw new IllegalArgumentException("Text cannot be greater than 60000 characters");
        }
    }

    private void checkSentimentParameters(String text, String language){
        if(text.isEmpty()){
            throw new IllegalArgumentException("Text cannot be empty");
        }else if(text.length() > 80000){
            throw new IllegalArgumentException("Text cannot be greater than 80000 characters");
        }else if(!language.equals(Language.ENGLISH) && !language.equals(Language.DUTCH) && !language.equals(Language.FRENCH)){
            throw new IllegalArgumentException("Language not allowed. Only allowed: ENGLISH, DUTCH, FRENCH");
        }
    }

    private void checkTagParameters(String text, String language, String output){
        if(text.isEmpty()){
            throw new IllegalArgumentException("Text cannot be empty");
        }else if(text.length() > 2000){
            throw new IllegalArgumentException("Text cannot be greater than 2000 characters");
        }
    }
    //endregion

}
