package com.antonkazakov.giphication.data.entities.dto.search;


import com.google.gson.annotations.SerializedName;

public class FixedWidthStill {

    @SerializedName("width")
    private String width;

    @SerializedName("url")
    private String url;

    @SerializedName("height")
    private String height;

    public void setWidth(String width) {
        this.width = width;
    }

    public String getWidth() {
        return width;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return
                "FixedWidthStill{" +
                        "width = '" + width + '\'' +
                        ",url = '" + url + '\'' +
                        ",height = '" + height + '\'' +
                        "}";
    }
}