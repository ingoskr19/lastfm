
package co.com.valid.lastfm.usecases.track.model.tracks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

public class Streamable implements Serializable
{

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("fulltrack")
    @Expose
    private String fulltrack;
    private final static long serialVersionUID = -3973500806438512775L;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFulltrack() {
        return fulltrack;
    }

    public void setFulltrack(String fulltrack) {
        this.fulltrack = fulltrack;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("text", text).append("fulltrack", fulltrack).toString();
    }

}
