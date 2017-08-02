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

public class GifsPresenter {

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

    public void create(String query) {
        gifsInteractor.buildAndNoExecute(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(gifEntities -> gifsView.loadData(gifEntities),
                        throwable -> Log.e("TESTTEST", "call: ", throwable));
    }

    public void getTrending() {
        trendingInteractor.buildAndNoExecute(null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(gifEntities -> gifsView.loadData(gifEntities));
    }

    public void likeGif(GifEntity gifEntity) {
        dislikeInteractor.buildAndNoExecute(gifEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aBoolean -> {
                    if (!aBoolean){
                        gifsView.showError("Error when liking post");
                    }
                });
    }

    public void dislikeGif(GifEntity gifEntity) {
        likeInteracotr.buildAndNoExecute(gifEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aBoolean -> {
                    if (!aBoolean){
                        gifsView.showError("Error when disliking post");
                    }
                });
    }

    public void setView(GifsView gifsView) {
        this.gifsView = gifsView;
    }

}
