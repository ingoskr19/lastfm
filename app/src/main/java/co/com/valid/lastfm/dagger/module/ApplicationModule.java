

package co.com.valid.lastfm.dagger.module;

import android.app.Application;
import android.content.Context;

import co.com.valid.lastfm.dagger.annotation.ApplicationContext;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

}
