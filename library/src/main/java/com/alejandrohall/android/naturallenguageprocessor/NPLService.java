package com.alejandrohall.android.naturallenguageprocessor;

import com.alejandrohall.android.naturallenguageprocessor.models.SentimentResponse;
import com.alejandrohall.android.naturallenguageprocessor.models.StemmingResponse;
import com.alejandrohall.android.naturallenguageprocessor.models.TagResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by alejandrohall on 20/02/16.
 */
public interface NPLService {

    @FormUrlEncoded
    @POST("stem/")
    Call<StemmingResponse> stemText(@Field("text") String text, @Field("language") String language, @Field("stemmer") String stemmer);

    @FormUrlEncoded
    @POST("sentiment/")
    Call<SentimentResponse> sentimentalAnalisysText(@Field("text") String text, @Field("language") String language);

    @FormUrlEncoded
    @POST("tag/")
    Call<TagResponse> tagText(@Field("text") String text, @Field("language") String language, @Field("output") String output);

}
