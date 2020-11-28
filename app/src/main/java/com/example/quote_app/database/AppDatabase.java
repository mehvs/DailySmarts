package com.example.quote_app.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.quote_app.database.model.Quote;

@Database(entities = Quote.class, version = 0)
public abstract class AppDatabase extends RoomDatabase {
    public abstract QuoteDao quoteDao();
}
