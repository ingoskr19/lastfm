package co.com.valid.lastfm.dagger.component;

import co.com.valid.lastfm.dagger.annotation.PerActivity;
import co.com.valid.lastfm.dagger.module.ActivityModule;
import co.com.valid.lastfm.dagger.module.DataBaseModule;
import co.com.valid.lastfm.dagger.module.RetrofitModule;
import co.com.valid.lastfm.usecases.artist.view.activities.ArtistActivity;
import co.com.valid.lastfm.usecases.track.view.activities.TrackActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {ActivityModule.class, RetrofitModule.class})
public interface ActivityComponent {

    void inject(TrackActivity activity);
    void inject(ArtistActivity artistActivity);
}
