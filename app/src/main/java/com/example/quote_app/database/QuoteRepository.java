package com.example.quote_app.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.quote_app.database.model.Quote;

import java.util.List;

public class QuoteRepository {
    private QuoteDao quoteDao;
    private LiveData<List<Quote>> allQuotes;

    public QuoteRepository(Application application) {
        QuoteDatabase database = QuoteDatabase.getInstance(application);
        quoteDao = database.quoteDao();
        allQuotes = quoteDao.getAllQuotes();
    }

    public void insert(Quote quote) {
        new InsertQuoteAsyncTask(quoteDao).execute(quote);
    }

    public void update(Quote quote) {
        new UpdateQuoteAsyncTask(quoteDao).execute(quote);
    }

    public void delete(Quote quote) {
        new DeleteNoteAsyncTask(quoteDao).execute(quote);
    }

    public void deleteAllQuotes() {
        new DeleteAllQuotesAsyncTask(quoteDao).execute();
    }

    public LiveData<List<Quote>> getAllQuotes() {
        return allQuotes;
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

    private static class DeleteNoteAsyncTask extends AsyncTask<Quote, Void, Void> {
        private QuoteDao quoteDao;

        private DeleteNoteAsyncTask(QuoteDao noteDao) {
            this.quoteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Quote... quotes) {
            quoteDao.delete(quotes[0]);
            return null;
        }
    }

    private static class DeleteAllQuotesAsyncTask extends AsyncTask<Void, Void, Void> {
        private QuoteDao quoteDao;

        private DeleteAllQuotesAsyncTask(QuoteDao quoteDao) {
            this.quoteDao = quoteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            quoteDao.deleteAllQuotes();
            return null;
        }
    }
}
