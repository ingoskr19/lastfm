package co.com.valid.lastfm.usecases.artist;

import android.util.Log;

import javax.inject.Inject;

import co.com.valid.lastfm.base.BasePresenter;
import co.com.valid.lastfm.usecases.artist.model.TopArtistsResponse;
import co.com.valid.lastfm.usecases.artist.view.activities.IArtistView;
import co.com.valid.lastfm.util.Constants;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ArtistPresenter<V extends IArtistView, I extends IArtistInteractor>
        extends BasePresenter<V,I> implements IArtistPresenter<V,I> {

    private static final String TAG = "ArtistPresenter";

    @Inject
    public ArtistPresenter(I interactor) {
        super(interactor);
    }

    @Override
    public void getTopArtists(int page, int limit) {

        //Validate internet connection
        if(getView().isNetworkConnected()){
            getTopArtistsFromApi(page,limit);
        } else {
            getTopArtistsFromLocal();
        }

    }

    private void getTopArtistsFromApi(int page, int limit){
        getInteractor().getTopArtists(page,limit).subscribe(new Observer<TopArtistsResponse>() {

            @Override public void onSubscribe(Disposable d) { }

            @Override
            public void onNext(TopArtistsResponse geoTopsResponse) {
                if(geoTopsResponse.getTopartists().getArtist() != null){
                    getView().showTopArtist(geoTopsResponse);
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

    private void getTopArtistsFromLocal(){
        //TODO Implement observer for local data
        getInteractor().getTopArtistLocal(1,20);
    }
}
