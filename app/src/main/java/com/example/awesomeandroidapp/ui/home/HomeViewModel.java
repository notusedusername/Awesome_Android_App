package com.example.awesomeandroidapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        //todo get nick from db
        mText = new MutableLiveData<>();
        mText.setValue("Tap to set your nickname!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}