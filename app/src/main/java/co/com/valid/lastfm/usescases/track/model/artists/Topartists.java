
package co.com.valid.lastfm.usescases.track.model.artists;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Topartists
{
    @SerializedName("artist")
    @Expose
    private ArrayList<Artist> artist = null;
    @SerializedName("@attr")
    @Expose
    private Attr attr;
    //private final static long serialVersionUID = -6624564566097301867L;

    public ArrayList<Artist> getArtist() {
        return artist;
    }

    public void setArtist(ArrayList<Artist> artist) {
        this.artist = artist;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

}
