package com.example.quote_app.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quote_app.database.model.Quote;

import java.util.List;

@Dao
public interface QuoteDao {
    @Insert
    void insert(Quote quote);

    @Update
    void update(Quote quote);

    @Delete
    void delete(Quote quote);

    @Query("DELETE FROM quote_table")
    void deleteAllQuotes();

    @Query("SELECT * FROM quote_table")
    LiveData<List<Quote>> getAllQuotes();

    @Query("DELETE FROM quote_table WHERE quote_text = :quote")
    void deleteByQuoteText(String quote);
}
