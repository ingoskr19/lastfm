package co.com.valid.lastfm.dagger.component;

import co.com.valid.lastfm.dagger.module.ActivityModule;
import co.com.valid.lastfm.usescases.artist.view.activities.ArtistActivity;
import co.com.valid.lastfm.dagger.annotation.PerActivity;
import co.com.valid.lastfm.usescases.track.view.activities.TrackActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(TrackActivity activity);
    void inject(ArtistActivity artistActivity);
}
