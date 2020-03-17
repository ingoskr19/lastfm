package co.com.valid.lastfm.usecases.track;

import androidx.lifecycle.LiveData;

import java.util.List;

import co.com.valid.lastfm.base.IBaseInteractor;
import co.com.valid.lastfm.database.entity.ImageEntity;
import co.com.valid.lastfm.database.entity.TrackEntity;
import co.com.valid.lastfm.usecases.track.model.tracks.TopTracksResponse;
import io.reactivex.Observable;

public interface ITrackInteractor extends IBaseInteractor {

    Observable<TopTracksResponse> getTopTracks(int page, int limit);

    LiveData<List<TrackEntity>> getTopTracksLocal(int page, int limit);

    LiveData<List<ImageEntity>> getImagesByTrackMbid(String mbid);

    int getTracksCount();
}
