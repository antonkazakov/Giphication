package com.antonkazakov.giphication.domain;

import android.support.annotation.NonNull;

import com.antonkazakov.giphication.data.TrendingRepository;
import com.antonkazakov.giphication.data.entities.beans.GifEntity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author Anton Kazakov
 * @date 02.08.17.
 */

public class TrendingInteractor extends UseCase<List<GifEntity>, Void> {

    private TrendingRepository trendingRepository;

    @Inject
    public TrendingInteractor(TrendingRepository trendingRepository) {
        this.trendingRepository = trendingRepository;
    }

    @NonNull
    @Override
    protected Observable<List<GifEntity>> buildObservable(Void parameter) {
        return trendingRepository.getGifs();
    }

}
