package com.example.awesomeandroidapp.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.awesomeandroidapp.model.History;

import java.util.List;

@Dao
public interface HistoryDao {
    @Insert
    void insert(History history);

    @Query("SELECT * FROM HISTORY GROUP BY PHOTOID ORDER BY ID DESC LIMIT 10")
    LiveData<List<History>>fetch();
}
