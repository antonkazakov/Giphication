package com.antonkazakov.giphication.data.entities.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;


/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */
@RealmClass
public class GifEntity implements Parcelable, RealmModel {

    @NonNull
    private String id;
    @NonNull
    private String thumbnail;
    private long likes;
    private long dislikes;
    @NonNull
    private String url;

    private boolean liked;
    private boolean disliked;

    public GifEntity(@NonNull String id) {
        this.id = id;
    }

    public GifEntity() {
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public boolean isDisliked() {
        return disliked;
    }

    public void setDisliked(boolean disliked) {
        this.disliked = disliked;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public long getDislikes() {
        return dislikes;
    }

    public void setDislikes(long dislikes) {
        this.dislikes = dislikes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GifEntity{");
        sb.append("id='").append(id).append('\'');
        sb.append(", thumbnail='").append(thumbnail).append('\'');
        sb.append(", likes=").append(likes);
        sb.append(", dislikes=").append(dislikes);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GifEntity gifEntity = (GifEntity) o;

        if (likes != gifEntity.likes) return false;
        if (dislikes != gifEntity.dislikes) return false;
        if (liked != gifEntity.liked) return false;
        if (disliked != gifEntity.disliked) return false;
        if (!id.equals(gifEntity.id)) return false;
        if (!thumbnail.equals(gifEntity.thumbnail)) return false;
        return url.equals(gifEntity.url);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + thumbnail.hashCode();
        result = 31 * result + (int) (likes ^ (likes >>> 32));
        result = 31 * result + (int) (dislikes ^ (dislikes >>> 32));
        result = 31 * result + url.hashCode();
        result = 31 * result + (liked ? 1 : 0);
        result = 31 * result + (disliked ? 1 : 0);
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.thumbnail);
        dest.writeLong(this.likes);
        dest.writeLong(this.dislikes);
    }


    protected GifEntity(Parcel in) {
        this.id = in.readString();
        this.thumbnail = in.readString();
        this.likes = in.readLong();
        this.dislikes = in.readLong();
    }

    public static final Parcelable.Creator<GifEntity> CREATOR = new Parcelable.Creator<GifEntity>() {
        @Override
        public GifEntity createFromParcel(Parcel source) {
            return new GifEntity(source);
        }

        @Override
        public GifEntity[] newArray(int size) {
            return new GifEntity[size];
        }
    };
}
