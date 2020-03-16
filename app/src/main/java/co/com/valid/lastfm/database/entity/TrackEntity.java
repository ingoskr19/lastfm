package co.com.valid.lastfm.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.Relation;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "tracks",
        indices = {@Index(value = {"mbid"},
                unique = true)})
//@ForeignKey(entity = ArtistEntity.class,parentColumns = {"artistMbid"},childColumns = {"mbid"})
public class TrackEntity  extends BaseEntity implements Serializable {

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "listeners")
    private int listeners;

    @ColumnInfo(name = "mbid")
    private String mbid;

    @ColumnInfo(name = "artistMbid")
    private String artistMbid;

    @ColumnInfo(name = "url")
    private String url;

    @ColumnInfo(name = "duration")
    private String duration;

    //@Relation(parentColumn = "artistMbid", entityColumn = "mbid")
    @Ignore
    private List<ArtistEntity> artist;

    //@Relation(parentColumn = "mbid", entityColumn = "trackMbid")
    @Ignore
    private List<ImageEntity> image;

    @ColumnInfo(name = "rank")
    private int rank;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getListeners() {
        return listeners;
    }

    public void setListeners(int listeners) {
        this.listeners = listeners;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getArtistMbid() {
        return artistMbid;
    }

    public void setArtistMbid(String artistMbid) {
        this.artistMbid = artistMbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<ArtistEntity> getArtist() {
        return artist;
    }

    public void setArtist(List<ArtistEntity> artist) {
        this.artist = artist;
    }

    public List<ImageEntity> getImage() {
        return image;
    }

    public void setImage(List<ImageEntity> image) {
        this.image = image;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
