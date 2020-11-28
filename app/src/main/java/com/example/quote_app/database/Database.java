package com.example.quote_app.database;

import android.content.Context;

import androidx.room.Room;

public final class Database {

    private static final String DATABASE_NAME = "com.example.dailysmarts";

    private static AppDatabase instance;

    private Database() {}

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
