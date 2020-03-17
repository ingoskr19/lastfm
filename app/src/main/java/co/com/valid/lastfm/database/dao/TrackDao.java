package co.com.valid.lastfm.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.com.valid.lastfm.database.entity.TrackEntity;

@Dao
public interface TrackDao {

    String TABLE_NAME = "tracks";

    @Query("delete from "+TABLE_NAME)
    void cleanTable();

    @Query("SELECT * FROM "+TABLE_NAME+" WHERE mbid=:mbid")
    LiveData<TrackEntity> findById(String mbid);

    @Query("SELECT * FROM "+TABLE_NAME+" limit :page offset :limit")
    LiveData<List<TrackEntity>> find(int page, int limit);

    @Query("SELECT COUNT(mbid) FROM "+TABLE_NAME)
    int getNumbersRows();

    @Insert
    long insert(TrackEntity product);

    @Update
    int update(TrackEntity product);
}
