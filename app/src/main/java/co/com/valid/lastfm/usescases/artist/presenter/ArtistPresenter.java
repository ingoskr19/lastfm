package co.com.valid.lastfm.usescases.artist.presenter;

import android.util.Log;

import javax.inject.Inject;

import co.com.valid.lastfm.base.BasePresenter;
import co.com.valid.lastfm.usescases.artist.interactor.IArtistInteractor;
import co.com.valid.lastfm.usescases.artist.model.TopsArtistsResponse;
import co.com.valid.lastfm.usescases.artist.view.activities.IArtistView;
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
        getInteractor().getTopArtists(page,limit).subscribe(new Observer<TopsArtistsResponse>() {

            @Override public void onSubscribe(Disposable d) { }

            @Override
            public void onNext(TopsArtistsResponse geoTopsResponse) {
                if(geoTopsResponse.getTopartists().getArtist() != null){
                    getView().showTopArtist(geoTopsResponse);
                }else{
                    getView().onError("Sin Respuesta");
                }
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

    }
}
