package co.com.valid.lastfm.usecases.track.view.activities;

import co.com.valid.lastfm.base.IBaseView;
import co.com.valid.lastfm.usecases.track.model.tracks.TopTracksResponse;
import co.com.valid.lastfm.usecases.track.model.tracks.Track;

public interface ITrackView extends IBaseView {

    void showTopTracks(TopTracksResponse topTracks);
    void showTrackDetail(Track track);

}
