package co.com.valid.lastfm.dagger.module;

import android.app.Activity;
import android.content.Context;
import co.com.valid.lastfm.dagger.annotation.ActivityContext;
import co.com.valid.lastfm.dagger.annotation.PerActivity;
import co.com.valid.lastfm.usescases.artist.interactor.ArtistInteractor;
import co.com.valid.lastfm.usescases.artist.interactor.IArtistInteractor;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

}
