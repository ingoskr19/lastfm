package co.com.valid.lastfm.usescases.artist.presenter;

import co.com.valid.lastfm.base.IBasePresenter;
import co.com.valid.lastfm.dagger.annotation.PerActivity;
import co.com.valid.lastfm.usescases.artist.interactor.IArtistInteractor;
import co.com.valid.lastfm.usescases.artist.view.activities.IArtistView;

@PerActivity
public interface IArtistPresenter<V extends IArtistView, I extends IArtistInteractor> extends IBasePresenter<V, I> {

    void getTopArtists(int page, int limit);

}
