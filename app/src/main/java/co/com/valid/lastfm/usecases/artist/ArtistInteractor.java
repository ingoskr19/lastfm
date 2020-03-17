package co.com.valid.lastfm.usecases.artist;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import co.com.valid.lastfm.base.BaseInteractor;
import co.com.valid.lastfm.database.entity.ArtistEntity;
import co.com.valid.lastfm.database.entity.ImageEntity;
import co.com.valid.lastfm.database.repository.ArtistRepository;
import co.com.valid.lastfm.database.repository.ImageRepository;
import co.com.valid.lastfm.usecases.artist.model.TopArtistsResponse;
import io.reactivex.Observable;

public class ArtistInteractor extends BaseInteractor implements IArtistInteractor {

    IArtistApiHelper apiHelper;
    ArtistRepository artistRepository;
    ImageRepository imageRepository;

    @Inject
    ArtistInteractor(IArtistApiHelper apiHelper, ArtistRepository artistRepository,
                     ImageRepository imageRepository){
        this.apiHelper = apiHelper;
        this.artistRepository = artistRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public Observable<TopArtistsResponse> getTopArtists(int page, int limit) {
        return apiHelper.getTopArtists(page,limit);
    }

    @Override
    public LiveData<List<ArtistEntity>> getTopArtistLocal(int page, int limit) {
        return artistRepository.find(page,limit);
    }

    @Override
    public LiveData<List<ImageEntity>> getImagesByArtistMbid(String mbid) {
        return imageRepository.findByArtisMbid(mbid);
    }

    @Override
    public int getTracksCount() {
        return artistRepository.getNumbersRows();
    }
}
