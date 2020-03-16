package co.com.valid.lastfm.usescases.artist.interactor;

import javax.inject.Inject;

import co.com.valid.lastfm.base.BaseInteractor;
import co.com.valid.lastfm.usescases.artist.model.TopsArtistsResponse;
import co.com.valid.lastfm.usescases.artist.repository.IArtistApiHelper;
import io.reactivex.Observable;

public class ArtistInteractor extends BaseInteractor implements IArtistInteractor {

    IArtistApiHelper apiHelper;

    @Inject
    ArtistInteractor(IArtistApiHelper apiHelper){
        this.apiHelper = apiHelper;
    }

    @Override
    public Observable<TopsArtistsResponse> getTopArtists(int page, int limit) {
        return apiHelper.getTopArtists(page,limit);
    }
}
