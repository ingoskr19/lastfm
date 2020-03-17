package co.com.valid.lastfm.database.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import co.com.valid.lastfm.database.entity.TrackEntity;

public interface TrackRepository {
    
    public LiveData<TrackEntity> findById(String mbid);

    public LiveData<List<TrackEntity>> find(int page, int limit);

    int getNumbersRows();
    
    public long insert(TrackEntity product);
    
    public int update(TrackEntity product);
}
