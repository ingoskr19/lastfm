package co.com.valid.lastfm.usecases.track;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.com.valid.lastfm.BuildConfig;
import co.com.valid.lastfm.usecases.track.model.tracks.TopTracksResponse;
import co.com.valid.lastfm.usecases.track.service.TrackRestApiService;
import co.com.valid.lastfm.util.Constants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class TrackApiHelper implements ITrackApiHelper {

    TrackRestApiService apiService;

    @Inject
    public TrackApiHelper(TrackRestApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<TopTracksResponse> getTopTracks(int page, int limit) {
        return apiService.getTopTracks(
                Constants.TOP_TRACKS_METHOD,
                Constants.COUNTRY,
                BuildConfig.API_KEY,
                Constants.DATA_TYPE,
                page,
                limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

