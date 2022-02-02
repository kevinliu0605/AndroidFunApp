package com.momo.androidfunapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.momo.androidfunapp.model.Article;

@Database(entities = {Article.class}, version = 1, exportSchema = false)
public abstract class NewsDatabase extends RoomDatabase {

    public abstract ArticleDao articleDao();
}
