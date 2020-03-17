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

    String TABLE_NAME = "artists";

    @Query("delete from "+TABLE_NAME)
    void cleanTable();

    @Query("SELECT * FROM "+TABLE_NAME+" WHERE mbid=:mbid")
    LiveData<ArtistEntity> findById(String mbid);

    @Query("SELECT * FROM "+TABLE_NAME+" limit :page offset :limit")
    LiveData<List<ArtistEntity>> find(int page, int limit);

    @Query("SELECT COUNT(mbid) FROM "+TABLE_NAME)
    int getNumbersRows();

    @Insert
    long insert(ArtistEntity artist);

    @Update
    int update(ArtistEntity artist);
}
