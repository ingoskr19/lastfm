package co.com.valid.lastfm.database.datasource;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import co.com.valid.lastfm.database.dao.ImageDao;
import co.com.valid.lastfm.database.entity.ImageEntity;
import co.com.valid.lastfm.database.repository.ImageRepository;

public class ImageDataSource implements ImageRepository {

    private ImageDao dao;

    @Inject
    public ImageDataSource(ImageDao dao) {
        this.dao = dao;
    }

    @Override
    public void cleanTable() {
        dao.cleanTable();
    }

    @Override
    public LiveData<List<ImageEntity>> findByArtisMbid(String mbid) {
        return dao.findByArtisMbid(mbid);
    }

    @Override
    public LiveData<List<ImageEntity>> findByTrackMbid(String mbid) {
        return dao.findByTrackMbid(mbid);
    }

    @Override
    public LiveData<List<ImageEntity>> findAll() {
        return findAll();
    }

    @Override
    public long insert(ImageEntity image) {
        return dao.insert(image);
    }

    @Override
    public int update(ImageEntity image) {
        return dao.update(image);
    }
}
