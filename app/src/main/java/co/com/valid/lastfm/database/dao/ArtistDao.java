package co.com.valid.lastfm.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.com.valid.lastfm.database.entity.ArtistEntity;

@Dao
public interface ArtistDao {

    String TABLE_NAME = "Arstis";

    @Query("SELECT * FROM "+TABLE_NAME+" WHERE mbid=:mbid")
    LiveData<ArtistEntity> findById(String mbid);

    @Query("SELECT * FROM "+TABLE_NAME)
    LiveData<List<ArtistEntity>> findAll();

    @Insert
    long insert(ArtistEntity product);

    @Update
    long update(ArtistEntity product);
}
