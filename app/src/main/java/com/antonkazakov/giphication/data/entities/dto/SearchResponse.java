package com.antonkazakov.giphication.data.entities.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {

    @SerializedName("pagination")
    private Pagination pagination;

    @SerializedName("data")
    private List<DataItem> data;

    @SerializedName("meta")
    private Meta meta;

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setData(List<DataItem> data) {
        this.data = data;
    }

    public List<DataItem> getData() {
        return data;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Meta getMeta() {
        return meta;
    }

    @Override
    public String toString() {
        return
                "SearchResponse{" +
                        "pagination = '" + pagination + '\'' +
                        ",data = '" + data + '\'' +
                        ",meta = '" + meta + '\'' +
                        "}";
    }
}