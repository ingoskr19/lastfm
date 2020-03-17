package co.com.valid.lastfm.usecases.track;

import co.com.valid.lastfm.base.IBasePresenter;
import co.com.valid.lastfm.dagger.annotation.PerActivity;
import co.com.valid.lastfm.usecases.track.view.activities.ITrackView;

@PerActivity
public interface ITrackPresenter<V extends ITrackView, I extends ITrackInteractor> extends IBasePresenter<V, I> {

    void getTopTracks(int page, int limit);

}
