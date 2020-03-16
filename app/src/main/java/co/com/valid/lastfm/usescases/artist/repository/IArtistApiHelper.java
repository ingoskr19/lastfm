package co.com.valid.lastfm.usescases.artist.repository;

import javax.inject.Singleton;

import co.com.valid.lastfm.usescases.artist.model.TopsArtistsResponse;
import io.reactivex.Observable;

@Singleton
public interface IArtistApiHelper {

    Observable<TopsArtistsResponse> getTopArtists(int page, int limit);

}
