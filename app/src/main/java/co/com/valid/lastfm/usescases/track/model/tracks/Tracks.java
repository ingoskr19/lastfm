
package co.com.valid.lastfm.usescases.track.model.tracks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

public class Tracks implements Serializable
{

    @SerializedName("track")
    @Expose
    private List<Track> track = null;
    @SerializedName("@attr")
    @Expose
    private Attr_ attr;
    private final static long serialVersionUID = -519098931996433057L;

    public List<Track> getTrack() {
        return track;
    }

    public void setTrack(List<Track> track) {
        this.track = track;
    }

    public Attr_ getAttr() {
        return attr;
    }

    public void setAttr(Attr_ attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("track", track).append("attr", attr).toString();
    }

}
