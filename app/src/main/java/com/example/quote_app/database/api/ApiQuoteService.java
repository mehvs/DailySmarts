package com.example.quote_app.database.api;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiQuoteService {

    @GET("?method=getQuote&format=json&lang=en")
    Call<Quote> randomQuoteEnglish();

    @GET("?method=getQuote&format=json&lang=ru")
    Call<Quote> randomQuoteRussian();

}
