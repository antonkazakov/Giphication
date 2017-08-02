package com.antonkazakov.giphication.data;

import android.support.annotation.Nullable;

import com.antonkazakov.giphication.data.entities.beans.GifEntity;
import com.antonkazakov.giphication.data.entities.beans.LikedGif;
import com.antonkazakov.giphication.data.entities.dto.LikeResponse;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Observable;

/**
 * @author Anton Kazakov
 * @date 02.08.17.
 */

public class LikesRepository {

    private static final String URL = "http://31.220.53.68/api/getAll";

    private ApiEndpoints apiEndpoints;

    @Inject
    public LikesRepository(ApiEndpoints apiEndpoints) {
        this.apiEndpoints = apiEndpoints;
    }

    public Observable<LikeResponse> getLikesFromVault() {
        return apiEndpoints.getLikesFromVault(URL);
    }

    public boolean like(GifEntity gifEntity) {
        LikedGif likedGif = new LikedGif();
        likedGif.setGifId(gifEntity.getId());
        likedGif.setLiked(true);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.insertOrUpdate(likedGif);
        realm.commitTransaction();
        realm.close();
        return true;
    }

    public boolean dislike(GifEntity gifEntity) {
        LikedGif likedGif = new LikedGif();
        likedGif.setGifId(gifEntity.getId());
        likedGif.setDisliked(true);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.insertOrUpdate(likedGif);
        realm.commitTransaction();
        realm.close();
        return true;
    }

    @Nullable
    public LikedGif getById(String id) {
        LikedGif gifEntity = null;
        Realm realm = Realm.getDefaultInstance();
        if (realm.where(LikedGif.class)
                .equalTo("gifId", id).findFirst() != null) {
             gifEntity = realm.copyFromRealm(realm.where(LikedGif.class)
                    .equalTo("gifId", id).findFirst());
        }
        return gifEntity;
    }


}
