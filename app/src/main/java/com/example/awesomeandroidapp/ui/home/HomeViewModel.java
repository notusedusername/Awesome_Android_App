package com.example.awesomeandroidapp.ui.home;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.awesomeandroidapp.model.History;
import com.example.awesomeandroidapp.model.Users;
import com.example.awesomeandroidapp.model.repository.HistoryRepository;
import com.example.awesomeandroidapp.model.repository.UsersRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private UsersRepository usersRepository;
    private HistoryRepository historyRepository;
    private LiveData<List<History>> history;
    private LiveData<String> lastUsername;

    public HomeViewModel(@NonNull Application application) {
        super(application);

        historyRepository = new HistoryRepository(application);
        history = historyRepository.fetch();

        usersRepository = new UsersRepository(application);
        lastUsername = usersRepository.getLastUser();
    }

    public LiveData<String> getLastUsername(){
        return lastUsername;
    }

    public LiveData<List<History>> getHistory(){
        return history;
    }

}