package com.example.quote_app.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiQuoteService {

    @GET("/quotes/random")
    Call<Quot> randomQuot();
}
