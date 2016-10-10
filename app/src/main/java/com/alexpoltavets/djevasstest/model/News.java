package com.alexpoltavets.djevasstest.model;

import android.graphics.Bitmap;

/**
 * Created by Alex Poltavets on 09.10.2016.
 */

public class News {
    private int id;
    private byte[] image;

    public News(int id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public byte[] getImage() {
        return image;
    }
}
