package com.momo.androidfunapp;

import android.app.Application;

import androidx.room.Room;

import com.facebook.stetho.Stetho;
import com.momo.androidfunapp.database.NewsDatabase;

public class NewsApplication extends Application {

    private static NewsDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        database = Room.databaseBuilder(this, NewsDatabase.class, "tinnews_db").build();
    }

    public static NewsDatabase getDatabase() {
        return database;
    }
}