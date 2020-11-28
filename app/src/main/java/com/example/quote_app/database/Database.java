package com.example.quote_app.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.quote_app.database.model.Quote;

public final class Database {

    private static final String DATABASE_NAME = "com.example.dailysmarts";

    private static AppDatabase instance;

    private Database() {
    }

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private QuoteDao quoteDao;

        private PopulateDbAsyncTask(AppDatabase db){
            quoteDao = db.quoteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            //Test
            quoteDao.insert(new Quote("Quote 1","Author 1"));
            quoteDao.insert(new Quote("Quote 2","Author 2"));
            quoteDao.insert(new Quote("Quote 3","Author 3"));
            return null;
        }
    }

}
