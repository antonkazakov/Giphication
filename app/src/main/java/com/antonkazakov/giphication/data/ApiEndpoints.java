package com.antonkazakov.giphication.data;

import android.support.annotation.NonNull;

import com.antonkazakov.giphication.data.entities.dto.SearchResponse;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */

public interface ApiEndpoints {

    @POST("gifs/search")
    Observable<SearchResponse> getGifsByQuery(@NonNull @Query("query") String query);

}
