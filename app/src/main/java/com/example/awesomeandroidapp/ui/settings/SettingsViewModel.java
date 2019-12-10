package com.example.awesomeandroidapp.ui.settings;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.awesomeandroidapp.model.Users;
import com.example.awesomeandroidapp.model.repository.UsersRepository;

public class SettingsViewModel extends AndroidViewModel {

    private UsersRepository usersRepository;
    private LiveData<String> lastUsername;


    public SettingsViewModel(@NonNull Application application) {
        super(application);
        usersRepository = new UsersRepository(application);
        lastUsername = usersRepository.getLastUser();
    }

    public void insertUsername(Users user){
        usersRepository.insert(user);
    }

    public LiveData<String> getLastUsername(){
        return lastUsername;
    }
}
