
package co.com.valid.lastfm.usecases.track.model.tracks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

public class Attr implements Serializable
{

    @SerializedName("rank")
    @Expose
    private String rank;
    private final static long serialVersionUID = 3923408665448089979L;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("rank", rank).toString();
    }

}
