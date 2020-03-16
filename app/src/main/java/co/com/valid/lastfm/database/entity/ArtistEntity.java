package co.com.valid.lastfm.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.room.SkipQueryVerification;

import java.io.Serializable;
import java.util.List;


@Entity(
        tableName = "artists",
        indices = {@Index(value = {"mbid"},
        unique = true)})
public class ArtistEntity  extends BaseEntity implements Serializable {

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "listeners")
    private int listeners;

    @ColumnInfo(name = "mbid")
    private String mbid;

    @ColumnInfo(name = "url")
    private String url;

    //@Relation(parentColumn = "mbid", entityColumn = "artistMbid")
    @Ignore
    private List<ImageEntity> images;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }
}
