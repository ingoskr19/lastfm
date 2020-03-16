package co.com.valid.lastfm.database;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import co.com.valid.lastfm.BuildConfig;
import co.com.valid.lastfm.database.entity.ArtistEntity;
import co.com.valid.lastfm.database.entity.ImageEntity;
import co.com.valid.lastfm.database.entity.TrackEntity;
import co.com.valid.lastfm.database.helper.DataConverterHelper;

@Database(
        entities = {ArtistEntity.class, ImageEntity.class, TrackEntity.class},
        version = BuildConfig.DB_VERSION,
        exportSchema = false)
@TypeConverters({DataConverterHelper.class})
public class LastFmDatabase extends RoomDatabase {
    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
