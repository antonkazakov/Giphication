package com.antonkazakov.giphication.data.entities.beans;

import android.support.annotation.NonNull;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */

public class GifEntity {

    @NonNull
    private String id;
    @NonNull
    private String url;
    private long likes;
    private long dislikes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        sb.append(", url='").append(url).append('\'');
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
        if (!id.equals(gifEntity.id)) return false;
        return url.equals(gifEntity.url);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + (int) (likes ^ (likes >>> 32));
        result = 31 * result + (int) (dislikes ^ (dislikes >>> 32));
        return result;
    }
}
