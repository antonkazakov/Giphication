package com.antonkazakov.giphication.ui.screens.gifList;

import com.antonkazakov.giphication.data.entities.beans.GifEntity;
import com.antonkazakov.giphication.ui.screens.gifList.GifsView;

/**
 * @author Anton Kazakov
 * @date 02.08.17.
 */

public interface IGifsPresenter {

    void searchGifs(String query);

    void getTrending();

    void likeGif(GifEntity gifEntity);

    void dislikeGif(GifEntity gifEntity);

    void setView(GifsView gifsView);

}
