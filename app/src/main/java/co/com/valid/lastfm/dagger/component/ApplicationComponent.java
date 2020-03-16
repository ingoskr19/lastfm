package co.com.valid.lastfm.dagger.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import co.com.valid.lastfm.StartApplication;
import co.com.valid.lastfm.dagger.annotation.ApplicationContext;
import co.com.valid.lastfm.dagger.module.ApplicationModule;
import co.com.valid.lastfm.usescases.artist.repository.ArtistApiHelper;
import co.com.valid.lastfm.usescases.artist.repository.service.ArtistRestApiService;
import dagger.Component;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(StartApplication app);

    @ApplicationContext
    Context context();

    Application application();

}