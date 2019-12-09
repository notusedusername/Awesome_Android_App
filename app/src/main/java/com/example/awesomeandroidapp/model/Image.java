package com.example.awesomeandroidapp.model;

import android.graphics.Bitmap;

public class Image {

    private int id;

    private String title;

    private String description;

    private String url;

    private String thumbnailUrl;


    public Image(int id, String title, String description, String url, String thumbnailUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
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


    public Bitmap getThumbnail() {
        //resolve thumbnail url
        return null;
    }
}
