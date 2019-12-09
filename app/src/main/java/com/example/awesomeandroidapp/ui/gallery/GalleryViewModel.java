package com.example.awesomeandroidapp.ui.gallery;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.awesomeandroidapp.json.JsonData;
import com.example.awesomeandroidapp.model.History;
import com.example.awesomeandroidapp.model.Image;
import com.example.awesomeandroidapp.model.repository.HistoryRepository;

import java.util.List;

public class GalleryViewModel extends AndroidViewModel {

    private HistoryRepository historyRepository;

    public GalleryViewModel(Application application) {
        super(application);
        historyRepository = new HistoryRepository(application);
    }

    public void insert(History history){
        historyRepository.insert(history);
    }

    public LiveData<List<Image>> getImages(){
        return new JsonData().getImages();
    }
}