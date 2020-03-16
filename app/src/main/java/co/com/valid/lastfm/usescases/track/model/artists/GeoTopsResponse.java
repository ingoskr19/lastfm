package co.com.valid.lastfm.usescases.track.model.artists;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeoTopsResponse {
    @SerializedName("topartists")
    @Expose
    public Topartists topartists;

    public Topartists getTopartists() {
        return topartists;
    }

    public void setTopartists(Topartists topartists) {
        this.topartists = topartists;
    }
}
