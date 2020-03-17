package co.com.valid.lastfm.usecases.artist;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.com.valid.lastfm.BuildConfig;
import co.com.valid.lastfm.usecases.artist.model.TopArtistsResponse;
import co.com.valid.lastfm.usecases.artist.service.ArtistRestApiService;
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
    public Observable<TopArtistsResponse> getTopArtists(int page, int limit) {
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

