package co.com.valid.lastfm.database.datasource;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import co.com.valid.lastfm.database.dao.ArtistDao;
import co.com.valid.lastfm.database.entity.ArtistEntity;
import co.com.valid.lastfm.database.repository.ArtistRepository;

public class ArtistDataSource implements ArtistRepository {

    private ArtistDao dao;

    @Inject
    public ArtistDataSource(ArtistDao artistDao) {
        this.dao = artistDao;
    }

    @Override
    public LiveData<ArtistEntity> findById(String mbid) {
        return dao.findById(mbid);
    }

    @Override
    public int getNumbersRows() {
        return dao.getNumbersRows();
    }

    @Override
    public LiveData<List<ArtistEntity>> find(int page, int limit) {
        return dao.find(page,limit);
    }

    @Override
    public long insert(ArtistEntity artist) {
        return dao.insert(artist);
    }

    @Override
    public int update(ArtistEntity artist) {
        return dao.update(artist);
    }
}
