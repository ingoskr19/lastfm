package co.com.valid.lastfm.usescases.artist.view.activities;

import co.com.valid.lastfm.base.IBaseView;
import co.com.valid.lastfm.usescases.artist.model.Artist;
import co.com.valid.lastfm.usescases.artist.model.TopsArtistsResponse;

public interface IArtistView extends IBaseView {

    void showTopArtist(TopsArtistsResponse topArtists);
    void showArtistDetail(Artist artist);

}
