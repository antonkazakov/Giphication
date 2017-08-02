package com.antonkazakov.giphication.data;

import android.support.annotation.NonNull;

import com.antonkazakov.giphication.data.entities.beans.GifEntity;
import com.antonkazakov.giphication.data.entities.dto.search.DataItem;
import com.antonkazakov.giphication.data.mapper.IMapper;
import com.antonkazakov.giphication.ui.di.Search;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */

public class Repository {

    private ApiEndpoints apiEndpoints;
    private IMapper<DataItem, GifEntity> mapper;

    @Inject
    public Repository(ApiEndpoints apiEndpoints, @Search IMapper mapper) {
        this.apiEndpoints = apiEndpoints;
        this.mapper = mapper;
    }

    public Observable<List<GifEntity>> getGifs(@NonNull String query) {
        return apiEndpoints.getGifsByQuery(query)
                .flatMapIterable(searchResponse -> searchResponse.getData())
                .map(dataItem -> mapper.transform(dataItem))
                .observeOn(Schedulers.io())
                .map(entity -> {
                    Realm realm = Realm.getDefaultInstance();
                    GifEntity foundEntity = realm.where(GifEntity.class).findFirst();
                    if (foundEntity == null) {
                    } else if (foundEntity.isLiked()) {
                        entity.setLiked(true);
                        entity.setDisliked(false);
                    } else if (foundEntity.isDisliked()) {
                        entity.setLiked(false);
                        entity.setDisliked(true);
                    }
                    return entity;
                })
                .toList();

    }

}
