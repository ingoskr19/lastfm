package co.com.valid.lastfm.usescases.artist.interactor;

import co.com.valid.lastfm.base.IBaseInteractor;
import co.com.valid.lastfm.usescases.artist.model.TopsArtistsResponse;
import io.reactivex.Observable;

public interface IArtistInteractor extends IBaseInteractor {

    Observable<TopsArtistsResponse> getTopArtists(int page, int limit);
}
