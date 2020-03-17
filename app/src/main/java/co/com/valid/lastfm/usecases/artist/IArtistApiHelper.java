package co.com.valid.lastfm.usecases.artist;

import javax.inject.Singleton;

import co.com.valid.lastfm.usecases.artist.model.TopArtistsResponse;
import io.reactivex.Observable;

@Singleton
public interface IArtistApiHelper {

    Observable<TopArtistsResponse> getTopArtists(int page, int limit);

}
