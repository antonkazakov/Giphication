package com.antonkazakov.giphication.ui.screens.gifList.di;

import com.antonkazakov.giphication.ui.di.AppComponent;
import com.antonkazakov.giphication.ui.di.FragmentScope;
import com.antonkazakov.giphication.ui.screens.gifList.GifsController;

import dagger.Component;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */
@Component(modules = GifsModule.class, dependencies = AppComponent.class)
@FragmentScope
public interface GifsComponent {

    void inject(GifsController gifsFragment);

}
