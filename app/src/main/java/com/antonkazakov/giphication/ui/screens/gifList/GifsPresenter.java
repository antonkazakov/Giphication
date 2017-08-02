package com.antonkazakov.giphication.ui.screens.gifList;

import android.util.Log;

import com.antonkazakov.giphication.data.entities.beans.GifEntity;
import com.antonkazakov.giphication.domain.DislikeInteractor;
import com.antonkazakov.giphication.domain.GifsInteractor;
import com.antonkazakov.giphication.domain.LikeInteracotr;
import com.antonkazakov.giphication.domain.TrendingInteractor;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */

public class GifsPresenter implements IGifsPresenter {

    private GifsView gifsView;

    private DislikeInteractor dislikeInteractor;
    private LikeInteracotr likeInteracotr;
    private GifsInteractor gifsInteractor;
    private TrendingInteractor trendingInteractor;

    @Inject
    public GifsPresenter(DislikeInteractor dislikeInteractor,
                         LikeInteracotr likeInteracotr,
                         GifsInteractor gifsInteractor,
                         TrendingInteractor trendingInteractor) {
        this.dislikeInteractor = dislikeInteractor;
        this.likeInteracotr = likeInteracotr;
        this.gifsInteractor = gifsInteractor;
        this.trendingInteractor = trendingInteractor;
    }

    @Override
    public void searchGifs(String query) {
        gifsInteractor.buildAndNoExecute(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(gifEntities -> {
                            if (gifsView != null)
                                gifsView.loadData(gifEntities);
                        },
                        throwable -> Log.e("searchGifs", "call: ", throwable));
    }

    @Override
    public void getTrending() {
        trendingInteractor.buildAndNoExecute(null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(gifEntities -> {
                    if (gifsView != null)
                        gifsView.loadData(gifEntities);
                });
    }

    @Override
    public void likeGif(GifEntity gifEntity) {
        dislikeInteractor.buildAndNoExecute(gifEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aBoolean -> {
                    if (!aBoolean) {
                        if (gifsView != null)
                            gifsView.showError("Error when liking post");
                    }
                });
    }

    @Override
    public void dislikeGif(GifEntity gifEntity) {
        likeInteracotr.buildAndNoExecute(gifEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aBoolean -> {
                    if (!aBoolean) {
                        if (gifsView != null)
                            gifsView.showError("Error when disliking post");
                    }
                });
    }

    @Override
    public void setView(GifsView gifsView) {
        this.gifsView = gifsView;
    }

}
