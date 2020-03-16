package co.com.valid.lastfm.usescases.artist.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.com.valid.lastfm.BuildConfig;
import co.com.valid.lastfm.usescases.artist.model.TopsArtistsResponse;
import co.com.valid.lastfm.usescases.artist.repository.service.ArtistRestApiService;
import co.com.valid.lastfm.util.Constants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class ArtistApiHelper implements IArtistApiHelper {

    ArtistRestApiService apiService;

    @Inject
    public ArtistApiHelper(ArtistRestApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<TopsArtistsResponse> getTopArtists(int page, int limit) {
        return apiService.getTopArtists(
                Constants.TOP_ARTISTS_METHOD,
                Constants.COUNTRY,
                BuildConfig.API_KEY,
                Constants.DATA_TYPE,
                page,
                limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

