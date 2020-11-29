package com.example.quote_app.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.quote_app.database.model.Quote;

import java.util.List;

public class QuoteService {
    private final QuoteDao quoteDao;
    private LiveData<List<Quote>> quoteList;

    public QuoteService(Application application){
        quoteDao = Database.getInstance(application).quoteDao();
        quoteList = quoteDao.getAll();
    }

    public LiveData<List<Quote>> getAll(){
        return quoteList;
    }

    public void insert(Quote quote){
        new InsertQuoteAsyncTask(quoteDao).execute(quote);
    }

    public void insertAll(Quote quote){
        new UpdateQuoteAsyncTask(quoteDao).execute();
    }

    public void update(Quote quote){
        new UpdateQuoteAsyncTask(quoteDao).execute(quote);
    }

    public void delete(Quote quote){
        new DeleteQuoteAsyncTask(quoteDao).execute(quote);
    }

    public void deleteAll(){
        new DeleteAllQuoteAsyncTask(quoteDao).execute();
    }

    private static class InsertQuoteAsyncTask extends AsyncTask<Quote, Void, Void> {
        private QuoteDao quoteDao;

        private InsertQuoteAsyncTask(QuoteDao quoteDao) {
            this.quoteDao = quoteDao;
        }

        @Override
        protected Void doInBackground(Quote... quotes) {
            quoteDao.insert(quotes[0]);
            return null;
        }
    }

    private static class InsertAllQuoteAsyncTask extends AsyncTask<Void, Void, Void> {
        private QuoteDao quoteDao;

        private InsertAllQuoteAsyncTask(QuoteDao quoteDao) {
            this.quoteDao = quoteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            quoteDao.insertAll();
            return null;
        }
    }

    private static class UpdateQuoteAsyncTask extends AsyncTask<Quote, Void, Void> {
        private QuoteDao quoteDao;

        private UpdateQuoteAsyncTask(QuoteDao quoteDao) {
            this.quoteDao = quoteDao;
        }

        @Override
        protected Void doInBackground(Quote... quotes) {
            quoteDao.update(quotes[0]);
            return null;
        }
    }

    private static class DeleteQuoteAsyncTask extends AsyncTask<Quote, Void, Void> {
        private QuoteDao quoteDao;

        private DeleteQuoteAsyncTask(QuoteDao quoteDao) {
            this.quoteDao = quoteDao;
        }

        @Override
        protected Void doInBackground(Quote... quotes) {
            quoteDao.delete(quotes[0]);
            return null;
        }
    }

    private static class DeleteAllQuoteAsyncTask extends AsyncTask<Void, Void, Void> {
        private QuoteDao quoteDao;

        private DeleteAllQuoteAsyncTask(QuoteDao quoteDao) {
            this.quoteDao = quoteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            quoteDao.deleteAll();
            return null;
        }
    }
}
