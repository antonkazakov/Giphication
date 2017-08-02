package com.antonkazakov.giphication.domain;

import android.support.annotation.NonNull;

import com.antonkazakov.giphication.data.LikesRepository;
import com.antonkazakov.giphication.data.entities.beans.GifEntity;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author Anton Kazakov
 * @date 02.08.17.
 */

public class DislikeInteractor extends UseCase<Boolean, GifEntity> {

    private LikesRepository likesRepository;

    @Inject
    public DislikeInteractor(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }

    @NonNull
    @Override
    protected Observable<Boolean> buildObservable(GifEntity parameter) {
        return Observable.just(likesRepository.dislike(parameter));
    }


}
