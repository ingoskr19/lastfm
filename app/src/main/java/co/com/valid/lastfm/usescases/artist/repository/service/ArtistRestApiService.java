package co.com.valid.lastfm.usescases.artist.repository.service;

import co.com.valid.lastfm.usescases.artist.model.TopsArtistsResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArtistRestApiService {
    @GET(".")
    Observable<TopsArtistsResponse> getTopArtists(
            @Query(value = "method", encoded = true) String userName,
            @Query(value = "country", encoded = true) String country,
            @Query(value = "api_key", encoded = true) String apiKey,
            @Query(value = "format", encoded = true) String format,
            @Query(value = "page", encoded = true) int page,
            @Query(value = "limit", encoded = true) int limit
    );

    /*@GET(".")
    Observable<TopsArtistsResponse> getTopTracks(
            @Query(value = "method", encoded = true) String userName,
            @Query(value = "country", encoded = true) String country,
            @Query(value = "api_key", encoded = true) String apiKey,
            @Query(value = "format", encoded = true) String format,
            @Query(value = "page", encoded = true) int page,
            @Query(value = "limit", encoded = true) int limit
    );*/
}
