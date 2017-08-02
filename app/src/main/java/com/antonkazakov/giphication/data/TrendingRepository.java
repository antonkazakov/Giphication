package com.antonkazakov.giphication.data;

import com.antonkazakov.giphication.data.entities.beans.GifEntity;
import com.antonkazakov.giphication.data.mapper.IMapper;
import com.antonkazakov.giphication.ui.di.TrendingQualifier;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author Anton Kazakov
 * @date 02.08.17.
 */

public class TrendingRepository {

    private ApiEndpoints apiEndpoints;
    private IMapper<com.antonkazakov.giphication.data.entities.dto.tranding.DataItem, GifEntity> mapper;

    @Inject
    public TrendingRepository(ApiEndpoints apiEndpoints, @TrendingQualifier IMapper<com.antonkazakov.giphication.data.entities.dto.tranding.DataItem, GifEntity> mapper) {
        this.apiEndpoints = apiEndpoints;
        this.mapper = mapper;
    }

    public Observable<List<GifEntity>> getGifs() {
        return apiEndpoints.getTrendingGifs()
                .flatMapIterable(searchResponse -> searchResponse.getData())
                .map(dataItem -> mapper.transform(dataItem))
                .toList();
    }
}

