package com.antonkazakov.giphication.domain;

import android.support.annotation.NonNull;
import android.util.Log;

import com.antonkazakov.giphication.data.LikesRepository;
import com.antonkazakov.giphication.data.Repository;
import com.antonkazakov.giphication.data.entities.beans.GifEntity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author Anton Kazakov
 * @date 02.08.17.
 */

public class GifsInteractor extends UseCase<List<GifEntity>, String> {

    private Repository repository;
    private LikesRepository likesRepository;

    @Inject
    public GifsInteractor(Repository repository, LikesRepository likesRepository) {
        this.repository = repository;
        this.likesRepository = likesRepository;
    }

    @NonNull
    @Override
    protected Observable<List<GifEntity>> buildObservable(String parameter) {
//        return Observable.combineLatest(repository.getGifs(parameter)
//                        .flatMapIterable(gifEntities -> gifEntities).map(gifEntity -> gifEntity),
//                likesRepository.getLikesFromVault().map(LikeResponse::getLikeVaults),
//                (gifEntity, likeVaults) -> {
//                    for (LikeVault likeVault : likeVaults) {
//                        if (likeVault.getGifId().equals(gifEntity.getId())) {
//                            gifEntity.setLikes(likeVault.getLikes());
//                            gifEntity.setDislikes(likeVault.getDislikes());
//                        }
//                    }
//                    return gifEntity;
//                })
        return repository.getGifs(parameter)
                .flatMapIterable(gifEntities -> gifEntities)
                .map(gifEntity -> {
                    if (likesRepository.getById(gifEntity.getId()) != null) {
                        Log.i("", "buildObservable: " + likesRepository.getById(gifEntity.getId()));
                        gifEntity.setLiked(likesRepository.getById(gifEntity.getId()).isLiked());
                        gifEntity.setDisliked(likesRepository.getById(gifEntity.getId()).isDisliked());
                    }
                    return gifEntity;
                })
                .toList();
    }

}
