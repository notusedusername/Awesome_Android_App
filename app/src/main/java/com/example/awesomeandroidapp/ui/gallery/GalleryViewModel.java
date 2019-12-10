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
    private LiveData<List<Image>> images;

    public GalleryViewModel(Application application) {
        super(application);
        historyRepository = new HistoryRepository(application);
        images = new JsonData().getImages();

    }

    public void insert(History history){
        historyRepository.insert(history);
    }

    public LiveData<List<Image>> getImages(){
        return images;
    }
}