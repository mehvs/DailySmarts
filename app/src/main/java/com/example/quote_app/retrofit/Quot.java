package com.example.quote_app.retrofit;


public class Quot {

    //{"quoteText":"Be less curious about people and more curious about ideas.  ",
    // "quoteAuthor":"Marie Curie ", "senderName":"",
    // "senderLink":"",
    // "quoteLink":"http://forismatic.com/en/a562642f67/"}


    String quoteText;
    String quoteAuthor;

    public Quot(String quoteText, String quoteAuthor) {
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
