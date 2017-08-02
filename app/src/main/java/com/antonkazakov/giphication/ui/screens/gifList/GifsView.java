package com.antonkazakov.giphication.ui.screens.gifList;

import com.antonkazakov.giphication.data.entities.beans.GifEntity;
import com.antonkazakov.giphication.ui.screens.base.BaseView;

import java.util.List;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */

public interface GifsView extends BaseView {

    void loadData(List<GifEntity> gifEntities);

}
