package com.example.awesomeandroidapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "history")
public class History {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int photoId;

    private String title;

    private String description;

    private String url;

    private String thumbnailUrl;

    public History(int id, int photoId, String title, String description, String url, String thumbnailUrl) {
        this.id = id;
        this.photoId = photoId;
        this.title = title;
        this.description = description;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public History(Image image) {
        this.photoId = image.getId();
        this.title = image.getTitle();
        this.description = image.getDescription();
        this.url = image.getUrl();
        this.thumbnailUrl = image.getThumbnailUrl();
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
