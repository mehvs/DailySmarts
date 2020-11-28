package com.example.quote_app.retrofit;


public class Quote {

    //{"quoteText":"Be less curious about people and more curious about ideas.  ",
    // "quoteAuthor":"Marie Curie ", "senderName":"",
    // "senderLink":"",
    // "quoteLink":"http://forismatic.com/en/a562642f67/"}


    String quoteText;
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
