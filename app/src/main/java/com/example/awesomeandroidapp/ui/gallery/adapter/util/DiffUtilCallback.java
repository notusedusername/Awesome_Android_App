package com.example.awesomeandroidapp.ui.gallery.adapter.util;

import androidx.recyclerview.widget.DiffUtil;

import com.example.awesomeandroidapp.model.Image;

import java.util.List;

public class DiffUtilCallback extends DiffUtil.Callback {

    private List<Image> oldImages;
    private List<Image> newImages;

    public DiffUtilCallback(List<Image> oldImages, List<Image> newImages) {
        this.oldImages = oldImages;
        this.newImages = newImages;
    }

    @Override
    public int getOldListSize() {
        return oldImages.size();
    }

    @Override
    public int getNewListSize() {
        return newImages.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldImages.get(oldItemPosition).getId() == newImages.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldImages.get(oldItemPosition).equals(newImages.get(newItemPosition));
    }
}
