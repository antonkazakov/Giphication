package com.antonkazakov.giphication.data.entities.beans;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author Anton Kazakov
 * @date 02.08.17.
 */
public class LikedGif extends RealmObject {

    @PrimaryKey
    private String gifId;

    private boolean liked;

    private boolean disliked;

    public LikedGif() {
    }

    public LikedGif(String gifId, boolean liked, boolean disliked) {
        this.gifId = gifId;
        this.liked = liked;
        this.disliked = disliked;
    }

    public String getGifId() {
        return gifId;
    }

    public void setGifId(String gifId) {
        this.gifId = gifId;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LikedGif likedGif = (LikedGif) o;

        if (liked != likedGif.liked) return false;
        if (disliked != likedGif.disliked) return false;
        return gifId.equals(likedGif.gifId);

    }

    @Override
    public int hashCode() {
        int result = gifId.hashCode();
        result = 31 * result + (liked ? 1 : 0);
        result = 31 * result + (disliked ? 1 : 0);
        return result;
    }

    public boolean getLiked() {
        return liked;
    }

    public boolean getDisliked() {
        return disliked;
    }
}
