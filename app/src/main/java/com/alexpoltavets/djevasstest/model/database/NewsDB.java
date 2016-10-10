package com.alexpoltavets.djevasstest.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Alex Poltavets on 09.10.2016.
 */

public class NewsDB {
    private static SQLiteDatabase database = null;

    private NewsDB() {
    }

    public static SQLiteDatabase getInstance(Context context) {
        if (database == null) {
            database = new DBHelper(context).getReadableDatabase();
        }
        return database;
    }
}
