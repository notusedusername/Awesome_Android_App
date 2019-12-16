package com.example.awesomeandroidapp.ui.gallery.adapter;

import com.example.awesomeandroidapp.model.Image;

public class Header extends Image {

    private String HeaderText;
    private String Category;
    private String ImageUrl;

    public Header(String headerText, String category, String imageUrl) {
        super(0, headerText, category, null, imageUrl);
        HeaderText = headerText;
        Category = category;
        ImageUrl = imageUrl;
    }

    public String getHeaderText() {
        return HeaderText;
    }

    public void setHeaderText(String headerText) {
        HeaderText = headerText;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

}
