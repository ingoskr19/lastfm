package co.com.valid.lastfm.database.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import co.com.valid.lastfm.database.entity.ImageEntity;

public interface ImageRepository {

    void cleanTable();

    LiveData<List<ImageEntity>>  findByArtisMbid(String mbid);

    LiveData<List<ImageEntity>> findByTrackMbid(String mbid);

    LiveData<List<ImageEntity>> findAll();

    long insert(ImageEntity product);

    int update(ImageEntity product);
}
