package co.com.valid.lastfm.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.com.valid.lastfm.database.entity.ImageEntity;

@Dao
public interface ImageDao {

    String TABLE_NAME = "images";

    @Query("delete from "+TABLE_NAME)
    void cleanTable();

    @Query("SELECT * FROM "+TABLE_NAME+" WHERE artistMbid=:mbid")
    LiveData<List<ImageEntity>>  findByArtisMbid(String mbid);

    @Query("SELECT * FROM "+TABLE_NAME+" WHERE trackMbid=:mbid")
    LiveData<List<ImageEntity>> findByTrackMbid(String mbid);

    @Query("SELECT * FROM "+TABLE_NAME)
    LiveData<List<ImageEntity>> findAll();

    @Insert
    long insert(ImageEntity image);

    @Update
    int update(ImageEntity image);
}
