package com.alexpoltavets.djevasstest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alexpoltavets.djevasstest.model.News;

import rapid.decoder.BitmapDecoder;

/**
 * Created by Alex Poltavets on 10.10.2016.
 */

public class NewsDetailFragment extends DialogFragment {

    private ImageView image;
    private byte[] bitmap;
    private String title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.dialog_news,container,false);
        image= (ImageView) v.findViewById(R.id.news_dialog_image);
        BitmapDecoder.from(bitmap).scaleBy((float) 0.3).into(image);
        getDialog().setTitle(getString(R.string.news_title,title));
        return v;
    }

    public static void showDialog(FragmentManager fm, News news){
        NewsDetailFragment fragment=new NewsDetailFragment();
        fragment.setBitmap(news.getImage());
        fragment.setTitle(String.valueOf(news.getId()+1));
        fragment.show(fm,"NEWS_FRAGMENT");
    }

    public void setBitmap(byte[] bitmap) {
        this.bitmap = bitmap;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
