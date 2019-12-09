package com.example.awesomeandroidapp.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.awesomeandroidapp.model.Users;

@Dao
public interface UsersDao {

    @Insert
    void insert(Users users);

    @Query("SELECT username FROM USERS ORDER BY ID DESC LIMIT 1")
    String getLastUsername();
}
