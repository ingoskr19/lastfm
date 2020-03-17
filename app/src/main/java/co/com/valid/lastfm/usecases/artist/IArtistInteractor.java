package co.com.valid.lastfm.usecases.artist;

import androidx.lifecycle.LiveData;

import java.util.List;

import co.com.valid.lastfm.base.IBaseInteractor;
import co.com.valid.lastfm.database.entity.ArtistEntity;
import co.com.valid.lastfm.database.entity.ImageEntity;
import co.com.valid.lastfm.usecases.artist.model.TopArtistsResponse;
import io.reactivex.Observable;

public interface IArtistInteractor extends IBaseInteractor {

    Observable<TopArtistsResponse> getTopArtists(int page, int limit);
    LiveData<List<ArtistEntity>> getTopArtistLocal(int page, int limit);
    LiveData<List<ImageEntity>> getImagesByArtistMbid(String mbid);
    int getTracksCount();
}
