package co.com.valid.lastfm.dagger.module;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.com.valid.lastfm.BuildConfig;
import co.com.valid.lastfm.dagger.annotation.ApplicationContext;
import co.com.valid.lastfm.dagger.annotation.PerActivity;
import co.com.valid.lastfm.usescases.artist.interactor.ArtistInteractor;
import co.com.valid.lastfm.usescases.artist.interactor.IArtistInteractor;
import co.com.valid.lastfm.usescases.artist.repository.ArtistApiHelper;
import co.com.valid.lastfm.usescases.artist.repository.IArtistApiHelper;
import co.com.valid.lastfm.usescases.artist.repository.service.ArtistRestApiService;
import co.com.valid.lastfm.util.Constants;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @Provides
    @ApplicationContext
    Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient(getHttpLoggingInterceptor()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @ApplicationContext
    OkHttpClient getOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(Constants.READ_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @ApplicationContext
    HttpLoggingInterceptor getHttpLoggingInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @PerActivity
    IArtistInteractor provideArtistInteractor(ArtistInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    IArtistApiHelper provideArtistApiHelper() {
        return new ArtistApiHelper(provideArtistRestApiService(getRetrofit()));
    }

    @Provides
    @PerActivity
    ArtistRestApiService provideArtistRestApiService(Retrofit retrofit) {
        return retrofit.create(ArtistRestApiService.class);
    }

}
