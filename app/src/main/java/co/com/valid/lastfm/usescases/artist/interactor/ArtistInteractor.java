package co.com.valid.lastfm.usescases.artist.interactor;

import javax.inject.Inject;

import co.com.valid.lastfm.base.BaseInteractor;
import co.com.valid.lastfm.usescases.artist.model.TopsArtistsResponse;
import io.reactivex.Observable;

public class ArtistInteractor extends BaseInteractor implements IArtistInteractor {

    @Inject
    ArtistInteractor(){

    }

    @Override
    public Observable<TopsArtistsResponse> getTopArtists(int page, int limit) {
        return null;
    }
}
