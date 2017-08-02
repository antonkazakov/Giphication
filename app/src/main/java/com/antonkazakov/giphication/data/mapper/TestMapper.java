package com.antonkazakov.giphication.data.mapper;

import android.support.annotation.NonNull;

import com.antonkazakov.giphication.data.entities.beans.GifEntity;
import com.antonkazakov.giphication.data.entities.dto.search.DataItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */

public class TestMapper implements IMapper<DataItem, GifEntity> {

    @Inject
    public TestMapper() {

    }

    @NonNull
    @Override
    public GifEntity transform(DataItem dataItem) {
        GifEntity gifEntity = new GifEntity();
        gifEntity.setId(dataItem.getId());
        gifEntity.setThumbnail(dataItem.getImages().getFixedHeightSmallStill().getUrl());
        gifEntity.setUrl(dataItem.getImages().getFixedWidth().getMp4());
        return gifEntity;
    }

    @NonNull
    @Override
    public List<GifEntity> transform(List<DataItem> dataItems) {
        List<GifEntity> gifEntities = new ArrayList<>();
        for (DataItem dataItem : dataItems) {
            gifEntities.add(transform(dataItem));
        }
        return gifEntities;
    }

}
