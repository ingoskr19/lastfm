package co.com.valid.lastfm;

import android.app.Application;

import co.com.valid.lastfm.dagger.component.ApplicationComponent;
import co.com.valid.lastfm.dagger.component.DaggerApplicationComponent;
import co.com.valid.lastfm.dagger.module.ApplicationModule;
import co.com.valid.lastfm.dagger.module.DataBaseModule;

public class StartApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .dataBaseModule(new DataBaseModule(this))
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
