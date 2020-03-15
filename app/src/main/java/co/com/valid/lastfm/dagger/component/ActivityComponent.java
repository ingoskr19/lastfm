package co.com.valid.lastfm.dagger.component;

import co.com.valid.lastfm.TopsActivity;
import co.com.valid.lastfm.dagger.annotation.PerActivity;

@PerActivity
public interface ActivityComponent {
    void inject(TopsActivity activity);
}
