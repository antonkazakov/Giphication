package com.antonkazakov.giphication.data;

import android.support.annotation.NonNull;

import com.antonkazakov.giphication.BuildConfig;
import com.antonkazakov.giphication.data.mapper.IMapper;
import com.antonkazakov.giphication.data.mapper.TestMapper;
import com.antonkazakov.giphication.data.mapper.TrendingMapper;
import com.antonkazakov.giphication.ui.di.Search;
import com.antonkazakov.giphication.ui.di.TrendingQualifier;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Anton Kazakov
 * @date 01.08.17.
 */

@Module
public class NetworkModule {

    @NonNull
    @Singleton
    @Provides
    @Search
    public IMapper provideMapper() {
        return new TestMapper();
    }

    @NonNull
    @Singleton
    @Provides
    @TrendingQualifier
    public IMapper provideMapper1() {
        return new TrendingMapper();
    }

    @NonNull
    @Singleton
    @Provides
    public Repository repository( ApiEndpoints apiEndpoints, @Search IMapper iMapper) {
        return new Repository(apiEndpoints, iMapper);
    }

    @NonNull
    @Singleton
    @Provides
    public TrendingRepository repository1(ApiEndpoints apiEndpoints, @TrendingQualifier IMapper iMapper) {
        return new TrendingRepository(apiEndpoints, iMapper);
    }


    @NonNull
    @Singleton
    @Provides
    public static OkHttpClient provideOkHttp(@NonNull HttpLoggingInterceptor httpLoggingInterceptor,
                                             @NonNull Interceptor keyInterceptor) {

        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(keyInterceptor)
                .build();
    }

    @NonNull
    @Provides
    @Singleton
    public static Retrofit provideRetrofit(@NonNull GsonConverterFactory gsonConverterFactory,
                                           @NonNull RxJavaCallAdapterFactory rxAdapter,
                                           @NonNull OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl("http://api.giphy.com/v1/")
                .client(client)
                .callbackExecutor(Executors.newFixedThreadPool(2))
                .addCallAdapterFactory(rxAdapter)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @NonNull
    @Provides
    @Singleton
    public GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @NonNull
    @Provides
    @Singleton
    public RxJavaCallAdapterFactory providesRxAdapter() {
        return RxJavaCallAdapterFactory.create();
    }

    @NonNull
    @Provides
    @Singleton
    public ApiEndpoints provideApiEndpoints(Retrofit retrofit) {
        return retrofit.create(ApiEndpoints.class);
    }


    @NonNull
    @Provides
    @Singleton
    public Interceptor provideKeyInterceptor() {
        return chain -> {
            Request request = chain.request();
            HttpUrl httpUrl = request.url()
                    .newBuilder()
                    .addQueryParameter("api_key", BuildConfig.KEY)
                    .build();
            request = request.newBuilder().url(httpUrl).build();
            return chain.proceed(request);
        };
    }

    @NonNull
    @Provides
    @Singleton
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

}
