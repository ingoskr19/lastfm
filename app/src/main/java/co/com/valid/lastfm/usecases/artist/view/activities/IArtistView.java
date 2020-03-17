package co.com.valid.lastfm.usecases.artist.view.activities;

import co.com.valid.lastfm.base.IBaseView;
import co.com.valid.lastfm.usecases.artist.model.Artist;
import co.com.valid.lastfm.usecases.artist.model.TopArtistsResponse;

public interface IArtistView extends IBaseView {

    void showTopArtist(TopArtistsResponse topArtists);
    void showArtistDetail(Artist artist);

}
