package co.com.valid.lastfm.usescases.artist.presenter;

import javax.inject.Inject;

import co.com.valid.lastfm.base.BasePresenter;
import co.com.valid.lastfm.usescases.artist.interactor.IArtistInteractor;
import co.com.valid.lastfm.usescases.artist.view.activities.IArtistView;

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
        /*getBaseInteractor().getTopArtists(page,limit).subscribe(new Observer<TopsArtistsResponse>() {

            @Override public void onSubscribe(Disposable d) { }

            @Override
            public void onNext(TopsArtistsResponse geoTopsResponse) {
                if(geoTopsResponse.getTopartists().getArtist() != null){
                    getBaseView().showTopArtist(geoTopsResponse);
                }else{
                    getBaseView().onError("Sin Respuesta");
                }
            }

            @Override
            public void onError(Throwable e) {
                getBaseView().onError("Error occurred");
                Log.e(Constants.TOP_ARTISTS_METHOD, e.getMessage(), e);
                getBaseView().hideLoading();
            }

            @Override
            public void onComplete() {
                getBaseView().hideLoading();
            }
        });*/
    }

    private void getTopArtistsFromLocal(){

    }
}
