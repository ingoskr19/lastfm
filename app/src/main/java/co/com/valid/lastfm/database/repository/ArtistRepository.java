package co.com.valid.lastfm.database.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import co.com.valid.lastfm.database.entity.ArtistEntity;

public interface ArtistRepository {

    public LiveData<ArtistEntity> findById(String mbid);

    public LiveData<List<ArtistEntity>> find(int page, int limit);

    int getNumbersRows();

    public long insert(ArtistEntity product);

    public int update(ArtistEntity product);
}
