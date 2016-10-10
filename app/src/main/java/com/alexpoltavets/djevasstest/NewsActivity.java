package com.alexpoltavets.djevasstest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alexpoltavets.djevasstest.adapter.NewsRecyclerAdapter;
import com.alexpoltavets.djevasstest.model.News;
import com.alexpoltavets.djevasstest.model.NewsFactory;

import java.util.List;


public class NewsActivity extends AppCompatActivity {
    private RecyclerView mRecycler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        iniViews();
    }

    private void iniViews() {
        mRecycler = (RecyclerView) findViewById(R.id.news_recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));
        new LoadNews().execute();
    }

    private class LoadNews extends AsyncTask<Void, Void, List<News>> {

        @Override
        protected List<News> doInBackground(Void... params) {
            return NewsFactory.getNewsPresenter(getBaseContext()).getNews();
        }

        @Override
        protected void onPostExecute(List<News> newses) {
            super.onPostExecute(newses);
            NewsRecyclerAdapter adapter = new NewsRecyclerAdapter(newses,getSupportFragmentManager());
            mRecycler.setAdapter(adapter);
        }
    }

}
