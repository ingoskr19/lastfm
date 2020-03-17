package co.com.valid.lastfm.usecases.track;

import javax.inject.Singleton;

import co.com.valid.lastfm.usecases.track.model.tracks.TopTracksResponse;
import io.reactivex.Observable;

@Singleton
public interface ITrackApiHelper {

    Observable<TopTracksResponse> getTopTracks(int page, int limit);

}
