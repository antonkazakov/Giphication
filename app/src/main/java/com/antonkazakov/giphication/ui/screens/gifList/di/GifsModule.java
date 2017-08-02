package com.antonkazakov.giphication.ui.screens.gifList.di;

import com.antonkazakov.giphication.domain.DislikeInteractor;
import com.antonkazakov.giphication.domain.LikeInteracotr;
import com.antonkazakov.giphication.domain.GifsInteractor;
import com.antonkazakov.giphication.domain.TrendingInteractor;
import com.antonkazakov.giphication.ui.di.FragmentScope;
import com.antonkazakov.giphication.ui.screens.gifList.GifsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */
@Module
public class GifsModule {

    @FragmentScope
    @Provides
    public GifsPresenter provideGifsPresenter(DislikeInteractor dislikeInteractor,
                                              LikeInteracotr likeInteracotr,
                                              GifsInteractor gifsInteractor,
                                              TrendingInteractor trendingInteractor) {
        return new GifsPresenter(dislikeInteractor,likeInteracotr, gifsInteractor, trendingInteractor);
    }

}
