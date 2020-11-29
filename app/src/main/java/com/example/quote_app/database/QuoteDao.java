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

    @Query("SELECT * FROM quotes")
    LiveData<List<Quote>> getAll();

    @Insert
    void insert(Quote quote);

    @Insert
    void insertAll(Quote... quotes);

    @Update
    void update(Quote quote);

    @Delete
    void delete(Quote quote);

    @Query("DELETE FROM quotes")
    void deleteAll();

}
