package co.com.valid.lastfm.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.io.Serializable;

@Entity(tableName = "images")
public class ImageEntity extends BaseEntity implements Serializable {

    @ColumnInfo(name = "artistMbid")
    private String artistMbid;

    @ColumnInfo(name = "trackMbid")
    private String trackMbid;

    @ColumnInfo(name = "text")
    private String text;

    @ColumnInfo(name = "size")
    private String size;

    public String getArtistMbid() {
        return artistMbid;
    }

    public void setArtistMbid(String artistMbid) {
        this.artistMbid = artistMbid;
    }

    public String getTrackMbid() {
        return trackMbid;
    }

    public void setTrackMbid(String trackMbid) {
        this.trackMbid = trackMbid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
