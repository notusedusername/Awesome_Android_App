package com.example.awesomeandroidapp.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        //todo get nick from db
        mText = new MutableLiveData<>();
        mText.setValue("Tap to set your nickname!");
        Log.d(HomeViewModel.class.getSimpleName(), "Constructed");
    }

    public void setText(String text) {
        this.mText.setValue(text);
    }

    public LiveData<String> getText() {
        return mText;
    }
}