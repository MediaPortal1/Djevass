package com.alexpoltavets.djevasstest.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import com.alexpoltavets.djevasstest.model.database.DBHelper;
import com.alexpoltavets.djevasstest.model.database.NewsDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Poltavets on 09.10.2016.
 */

public class NewsFactory {

    private NewsFactory() {
    }

    public static NewsPresenter getNewsPresenter(Context context){
        return new NewsPresenter() {
            @Override
            public List<News> getNews() {
                List<News> items=new ArrayList<News>();
                SQLiteDatabase database=NewsDB.getInstance(context);
                database.beginTransaction();
                Cursor cursor=database.query(DBHelper.NEWS_TABLE_NAME,null,null,null,null,null,null);
                cursor.moveToFirst();
                do{
                    int id=cursor.getPosition();
                    byte[] image=cursor.getBlob(cursor.getColumnIndex("image"));
                    items.add(new News(id,image));
                }while (cursor.moveToNext());
                database.endTransaction();
                return items;
            }
        };
    }
}
