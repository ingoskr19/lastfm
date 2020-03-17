package co.com.valid.lastfm.usecases.track;

import android.util.Log;

import javax.inject.Inject;

import co.com.valid.lastfm.base.BasePresenter;
import co.com.valid.lastfm.usecases.track.model.tracks.TopTracksResponse;
import co.com.valid.lastfm.usecases.track.view.activities.ITrackView;
import co.com.valid.lastfm.util.Constants;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TrackPresenter<V extends ITrackView, I extends ITrackInteractor>
        extends BasePresenter<V,I> implements ITrackPresenter<V,I> {

    private static final String TAG = "TrackPresenter";

    @Inject
    public TrackPresenter(I interactor) {
        super(interactor);
    }

    @Override
    public void getTopTracks(int page, int limit) {

        //Validate internet connection
        if(getView().isNetworkConnected()){
            getTopTracksFromApi(page,limit);
        } else {
            getTopTracksFromLocal();
        }

    }

    private void getTopTracksFromApi(int page, int limit){
        getInteractor().getTopTracks(page,limit).subscribe(new Observer<TopTracksResponse>() {

            @Override public void onSubscribe(Disposable d) { }

            @Override
            public void onNext(TopTracksResponse geoTopsResponse) {
                if(geoTopsResponse.getTracks().getTrack() != null){
                    getView().showTopTracks(geoTopsResponse);
                }else{
                    getView().onError("Without Response");
                }
                getView().hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                getView().onError("Error occurred");
                Log.e(Constants.TOP_ARTISTS_METHOD, e.getMessage(), e);
                getView().hideLoading();
            }

            @Override
            public void onComplete() {
                getView().hideLoading();
            }
        });
    }

    private void getTopTracksFromLocal(){
        //TODO Implement observer for local data
        getInteractor().getTopTracksLocal(1,20);
    }
}
