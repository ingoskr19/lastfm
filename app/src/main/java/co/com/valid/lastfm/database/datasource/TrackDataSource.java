package co.com.valid.lastfm.database.datasource;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import co.com.valid.lastfm.database.dao.TrackDao;
import co.com.valid.lastfm.database.entity.TrackEntity;
import co.com.valid.lastfm.database.repository.TrackRepository;

public class TrackDataSource implements TrackRepository {

    private TrackDao dao;

    @Inject
    public TrackDataSource(TrackDao trackDao) {
        this.dao = trackDao;
    }

    @Override
    public LiveData<TrackEntity> findById(String mbid) {
        return dao.findById(mbid);
    }

    @Override
    public LiveData<List<TrackEntity>> find(int page, int limit) {
        return dao.find(page, limit);
    }

    @Override
    public int getNumbersRows() {
        return dao.getNumbersRows();
    }

    @Override
    public long insert(TrackEntity track) {
        return dao.insert(track);
    }

    @Override
    public int update(TrackEntity track) {
        return dao.update(track);
    }
}
