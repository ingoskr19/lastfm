package co.com.valid.lastfm.dagger.module;

import android.app.Application;

import androidx.room.Room;

import javax.inject.Singleton;

import co.com.valid.lastfm.database.LastFmDatabase;
import co.com.valid.lastfm.database.dao.ArtistDao;
import co.com.valid.lastfm.database.dao.ImageDao;
import co.com.valid.lastfm.database.dao.TrackDao;
import co.com.valid.lastfm.database.datasource.ArtistDataSource;
import co.com.valid.lastfm.database.datasource.ImageDataSource;
import co.com.valid.lastfm.database.datasource.TrackDataSource;
import co.com.valid.lastfm.database.repository.ArtistRepository;
import co.com.valid.lastfm.database.repository.ImageRepository;
import co.com.valid.lastfm.database.repository.TrackRepository;
import co.com.valid.lastfm.util.Constants;
import dagger.Module;
import dagger.Provides;

@Module
public class DataBaseModule {

    private LastFmDatabase mDatabase;

    public DataBaseModule(Application mApplication) {
        mDatabase = Room.databaseBuilder(mApplication, LastFmDatabase.class, Constants.DATABASE_NAME).build();
    }

    @Singleton
    @Provides
    LastFmDatabase providesRoomDatabase() {
        return mDatabase;
    }

    @Singleton
    @Provides
    ArtistDao providesProductDao(LastFmDatabase database) {
        return database.getArtistDao();
    }

    @Singleton
    @Provides
    TrackDao providesTrackDao(LastFmDatabase database) {
        return database.getTrackDao();
    }

    @Singleton
    @Provides
    ImageDao providesImagesDao(LastFmDatabase database) {
        return database.getImageDao();
    }

    @Singleton
    @Provides
    ArtistRepository provideArtistRepository(ArtistDao dao) {
        return new ArtistDataSource(dao);
    }

    @Singleton
    @Provides
    TrackRepository provideTrackRepository(TrackDao dao) {
        return new TrackDataSource(dao);
    }

    @Singleton
    @Provides
    ImageRepository provideImageRepository(ImageDao dao) {
        return new ImageDataSource(dao);
    }
}
