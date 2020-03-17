package co.com.valid.lastfm.usecases.artist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopArtistsResponse {
    @SerializedName("topartists")
    @Expose
    public co.com.valid.lastfm.usecases.artist.model.Topartists topartists;

    public co.com.valid.lastfm.usecases.artist.model.Topartists getTopartists() {
        return topartists;
    }

    public void setTopartists(Topartists topartists) {
        this.topartists = topartists;
    }
}
