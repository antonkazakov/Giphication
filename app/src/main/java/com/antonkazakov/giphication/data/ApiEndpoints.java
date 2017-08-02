package com.antonkazakov.giphication.data;

import android.support.annotation.NonNull;

import com.antonkazakov.giphication.data.entities.dto.ChangeStateResponse;
import com.antonkazakov.giphication.data.entities.dto.LikeResponse;
import com.antonkazakov.giphication.data.entities.dto.search.SearchResponse;
import com.antonkazakov.giphication.data.entities.dto.tranding.TrandingResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */

public interface ApiEndpoints {

    @GET("gifs/search")
    Observable<SearchResponse> getGifsByQuery(@NonNull @Query("q") String query);

    @GET("gifs/trending")
    Observable<TrandingResponse> getTrendingGifs();

    @GET()
    Observable<LikeResponse> getLikesFromVault(@Url String url);

    @GET("api/like")
    Observable<ChangeStateResponse> like(@Url String url, @Query("gifid") String id);

    @GET()
    Observable<ChangeStateResponse> dislike(@Url String url, @Query("gifid") String id);


}
