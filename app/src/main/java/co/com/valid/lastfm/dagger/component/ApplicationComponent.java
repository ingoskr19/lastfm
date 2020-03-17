package co.com.valid.lastfm.dagger.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import co.com.valid.lastfm.StartApplication;
import co.com.valid.lastfm.dagger.annotation.ApplicationContext;
import co.com.valid.lastfm.dagger.module.ApplicationModule;
import co.com.valid.lastfm.dagger.module.DataBaseModule;
import co.com.valid.lastfm.database.LastFmDatabase;
import co.com.valid.lastfm.database.repository.ArtistRepository;
import co.com.valid.lastfm.database.repository.ImageRepository;
import co.com.valid.lastfm.database.repository.TrackRepository;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, DataBaseModule.class})
public interface ApplicationComponent {

    void inject(StartApplication app);

    @ApplicationContext
    Context context();

    Application application();

    LastFmDatabase database();

    ArtistRepository artistRepository();

    TrackRepository trackRepository();

    ImageRepository imageRepository();

}