package com.antonkazakov.giphication.data;

import android.support.annotation.NonNull;

import com.antonkazakov.giphication.data.entities.beans.GifEntity;
import com.antonkazakov.giphication.data.entities.dto.DataItem;
import com.antonkazakov.giphication.data.entities.dto.SearchResponse;
import com.antonkazakov.giphication.data.mapper.IMapper;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */

public class Repository {

    private ApiEndpoints apiEndpoints;
    private IMapper<DataItem, GifEntity> mapper;

    @Inject
    public Repository(ApiEndpoints apiEndpoints, IMapper mapper) {
        this.apiEndpoints = apiEndpoints;
        this.mapper = mapper;
    }

    public Observable<List<GifEntity>> getGifs(@NonNull String query) {
        return apiEndpoints.getGifsByQuery(query)
                .flatMapIterable(SearchResponse::getData)
                .map(dataItem -> mapper.transform(dataItem))
                .toList();
    }

}
