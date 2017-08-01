package com.antonkazakov.giphication.data.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {



}
