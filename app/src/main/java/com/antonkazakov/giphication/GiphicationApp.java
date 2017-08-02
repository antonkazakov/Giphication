package com.antonkazakov.giphication;

import android.app.Application;

import com.antonkazakov.giphication.ui.di.AppComponent;
import com.antonkazakov.giphication.ui.di.AppModule;
import com.antonkazakov.giphication.ui.di.DaggerAppComponent;
import com.antonkazakov.giphication.data.NetworkModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */

public class GiphicationApp extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .networkModule(new NetworkModule())
                .build();

    }

    public static synchronized AppComponent getAppComponent() {
        return appComponent;
    }

    private void initRealm() {
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(3)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }


}
