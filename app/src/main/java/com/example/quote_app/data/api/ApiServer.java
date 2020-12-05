package com.example.quote_app.data.api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServer {

    private static ApiServer instance;
    private final ApiQuoteService service;

    private ApiServer() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.forismatic.com/api/1.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiQuoteService.class);
    }

    public static ApiServer getInstance() {
        if (instance == null) instance = new ApiServer();
        return instance;
    }

    public void getRandomQuoteEnglish(final ApiListener listener) {

        service.randomQuoteEnglish().enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {

                if (response.isSuccessful()) {

                    listener.onQuoteReceived(response.body().getQuoteText(), response.body().getQuoteAuthor());
                } else {
                    listener.onFailure();
                }
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {

                listener.onFailure();
            }
        });


    }

    public void getRandomQuoteRussian(final ApiListener listener) {

        service.randomQuoteRussian().enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {

                if (response.isSuccessful()) {

                    listener.onQuoteReceived(response.body().getQuoteText(), response.body().getQuoteAuthor());
                } else {
                    listener.onFailure();
                }
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {

                listener.onFailure();
            }
        });


    }

    public interface ApiListener {
        void onQuoteReceived(String quote, String author);

        void onFailure();
    }
}
