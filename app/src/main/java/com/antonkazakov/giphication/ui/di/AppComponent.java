package com.antonkazakov.giphication.ui.di;

import android.content.Context;

import com.antonkazakov.giphication.data.ApiEndpoints;
import com.antonkazakov.giphication.data.NetworkModule;
import com.antonkazakov.giphication.data.Repository;
import com.antonkazakov.giphication.data.TrendingRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    ApiEndpoints api();

    Repository repo();

    TrendingRepository tring();

    Context context();

}
