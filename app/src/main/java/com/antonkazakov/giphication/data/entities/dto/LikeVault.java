package com.antonkazakov.giphication.data.entities.dto;

import com.google.gson.annotations.SerializedName;

/**
 * @author Anton Kazakov
 * @date 02.08.17.
 */

public class LikeVault {

    private long id;
    @SerializedName("gifid")
    private String gifId;
    private long likes;
    private long dislikes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGifId() {
        return gifId;
    }

    public void setGifId(String gifId) {
        this.gifId = gifId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LikeVault likeVault = (LikeVault) o;

        if (id != likeVault.id) return false;
        if (likes != likeVault.likes) return false;
        if (dislikes != likeVault.dislikes) return false;
        return gifId.equals(likeVault.gifId);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + gifId.hashCode();
        result = 31 * result + (int) (likes ^ (likes >>> 32));
        result = 31 * result + (int) (dislikes ^ (dislikes >>> 32));
        return result;
    }
}
