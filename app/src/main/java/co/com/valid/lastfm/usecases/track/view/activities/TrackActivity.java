package co.com.valid.lastfm.usecases.track.view.activities;

import android.os.Bundle;

import co.com.valid.lastfm.R;
import co.com.valid.lastfm.base.BaseActivity;
import co.com.valid.lastfm.usecases.track.model.tracks.TopTracksResponse;
import co.com.valid.lastfm.usecases.track.model.tracks.Track;

public class TrackActivity  extends BaseActivity implements ITrackView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    public void showTopTracks(TopTracksResponse topTracks) {

    }

    @Override
    public void showTrackDetail(Track track) {

    }

    @Override
    public void onError(String message) {

    }
}
