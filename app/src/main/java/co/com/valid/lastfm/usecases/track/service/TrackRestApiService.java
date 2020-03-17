package co.com.valid.lastfm.usecases.track.service;

import co.com.valid.lastfm.usecases.track.model.tracks.TopTracksResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TrackRestApiService {
    @GET(".")
    Observable<TopTracksResponse> getTopTracks(
            @Query(value = "method", encoded = true) String userName,
            @Query(value = "country", encoded = true) String country,
            @Query(value = "api_key", encoded = true) String apiKey,
            @Query(value = "format", encoded = true) String format,
            @Query(value = "page", encoded = true) int page,
            @Query(value = "limit", encoded = true) int limit
    );
}
