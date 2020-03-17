package co.com.valid.lastfm.usecases.track;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import co.com.valid.lastfm.base.BaseInteractor;
import co.com.valid.lastfm.database.entity.ImageEntity;
import co.com.valid.lastfm.database.entity.TrackEntity;
import co.com.valid.lastfm.database.repository.ImageRepository;
import co.com.valid.lastfm.database.repository.TrackRepository;
import co.com.valid.lastfm.usecases.track.model.tracks.TopTracksResponse;
import io.reactivex.Observable;

public class TrackInteractor extends BaseInteractor implements ITrackInteractor {

    ITrackApiHelper apiHelper;
    TrackRepository trackRepository;
    ImageRepository imageRepository;

    @Inject
    TrackInteractor(ITrackApiHelper apiHelper, TrackRepository trackRepository,
                    ImageRepository imageRepository){
        this.apiHelper = apiHelper;
        this.trackRepository = trackRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public Observable<TopTracksResponse> getTopTracks(int page, int limit) {
        return apiHelper.getTopTracks(page,limit);
    }

    @Override
    public LiveData<List<TrackEntity>> getTopTracksLocal(int page, int limit) {
        return trackRepository.find(page,limit);
    }

    @Override
    public LiveData<List<ImageEntity>> getImagesByTrackMbid(String mbid) {
        return imageRepository.findByTrackMbid(mbid);
    }

    @Override
    public int getTracksCount() {
        return trackRepository.getNumbersRows();
    }
}
