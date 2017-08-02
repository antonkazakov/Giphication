package com.antonkazakov.giphication.data.entities.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton Kazakov
 * @date 02.08.17.
 */

public class LikeResponse {

    @SerializedName("main")
    List<LikeVault> likeVaults = new ArrayList<>();

    public List<LikeVault> getLikeVaults() {
        return likeVaults;
    }

    public void setLikeVaults(List<LikeVault> likeVaults) {
        this.likeVaults = likeVaults;
    }
}
