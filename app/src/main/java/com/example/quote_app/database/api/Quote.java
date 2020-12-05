package com.example.quote_app.database.api;


import com.google.gson.annotations.SerializedName;


public class Quote {

    @SerializedName("quoteText")
    String quoteText;
    @SerializedName("quoteAuthor")
    String quoteAuthor;

    public Quote(String quoteText, String quoteAuthor) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }
}
