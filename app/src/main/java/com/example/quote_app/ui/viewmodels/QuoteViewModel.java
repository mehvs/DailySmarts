package com.example.quote_app.ui.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.quote_app.database.QuoteService;
import com.example.quote_app.database.model.Quote;

import java.util.List;

public class QuoteViewModel extends AndroidViewModel {
    private QuoteService quoteService;
    private LiveData<List<Quote>> allQuotes;

    public QuoteViewModel(@NonNull Application application) {
        super(application);
        quoteService = new QuoteService(application);
        allQuotes = quoteService.getAll();
    }

    public void insert(Quote quote) {
        quoteService.insert(quote);
    }

    public void update(Quote quote) {
        quoteService.update(quote);
    }

    public void delete(Quote quote) {
        quoteService.delete(quote);
    }

    public void deleteAll() {
        quoteService.deleteAll();
    }

    public LiveData<List<Quote>> getAllQuotes() {
        return allQuotes;
    }


}
