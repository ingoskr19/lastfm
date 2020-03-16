package co.com.valid.lastfm.usescases.artist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import co.com.valid.lastfm.usescases.track.model.artists.Topartists;

public class TopsArtistsResponse {
    @SerializedName("topartists")
    @Expose
    public co.com.valid.lastfm.usescases.track.model.artists.Topartists topartists;

    public co.com.valid.lastfm.usescases.track.model.artists.Topartists getTopartists() {
        return topartists;
    }

    public void setTopartists(Topartists topartists) {
        this.topartists = topartists;
    }
}
