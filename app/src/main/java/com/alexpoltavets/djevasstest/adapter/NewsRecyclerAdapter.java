package com.alexpoltavets.djevasstest.adapter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alexpoltavets.djevasstest.NewsDetailFragment;
import com.alexpoltavets.djevasstest.R;
import com.alexpoltavets.djevasstest.model.News;

import java.util.List;

import rapid.decoder.BitmapDecoder;

/**
 * Created by Alex Poltavets on 09.10.2016.
 */

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.NewsHolder>  {
    private List<News> itemlist;
    private FragmentManager fm;

    public NewsRecyclerAdapter(List<News> itemlist, FragmentManager fragmentManager) {
        this.itemlist = itemlist;
        this.fm = fragmentManager;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_listitem, parent, false));
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        holder.setImage(itemlist.get(position));
        holder.setListener(new AdapterItemGetter() {
            @Override
            public News getNewsItem(int id) {
                return itemlist.get(id);
            }
        },fm);

    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        private ImageView image;

        public NewsHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.newsitem_image);
        }

        public void setImage(News item) {
            BitmapDecoder.from(item.getImage()).scaleBy((float) 0.3).into(image);
        }

        public void setListener(AdapterItemGetter getter, FragmentManager fm) {
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NewsDetailFragment.showDialog( fm, getter.getNewsItem(getAdapterPosition()));
                }
            });
        }
    }

    public interface AdapterItemGetter {
        News getNewsItem(int id);
    }
}
