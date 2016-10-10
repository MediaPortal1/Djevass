package com.alexpoltavets.djevasstest.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.BitmapFactory;

import com.alexpoltavets.djevasstest.R;
import com.alexpoltavets.djevasstest.model.BitmapUtility;

/**
 * Created by Alex Poltavets on 09.10.2016.
 */

public class DBHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String DB_NAME = "news_database";
    private static final int DB_VERSION = 1;

    public static final String NEWS_TABLE_NAME = "news";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createNewsTable());
        insertDataToNews(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String createNewsTable() {
        return "CREATE TABLE " + NEWS_TABLE_NAME + "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "image BLOB NOT NULL);";
    }

    private void insertDataToNews(SQLiteDatabase database) {
        ContentValues cv = new ContentValues();
        cv.put("image", BitmapUtility.getBytes(BitmapFactory.decodeResource(context.getResources(), R.drawable.news_item1)));
        database.insert(NEWS_TABLE_NAME, null, cv);
        cv = new ContentValues();
        cv.put("image", BitmapUtility.getBytes(BitmapFactory.decodeResource(context.getResources(), R.drawable.news_item2)));
        database.insert(NEWS_TABLE_NAME, null, cv);
    }
}
