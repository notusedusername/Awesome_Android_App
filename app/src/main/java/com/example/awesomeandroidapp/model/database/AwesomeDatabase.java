package com.example.awesomeandroidapp.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.awesomeandroidapp.model.History;
import com.example.awesomeandroidapp.model.Users;
import com.example.awesomeandroidapp.model.dao.HistoryDao;
import com.example.awesomeandroidapp.model.dao.UsersDao;

@Database(entities = {History.class, Users.class}, version = 1, exportSchema = false)
public abstract class AwesomeDatabase extends RoomDatabase {

    private static AwesomeDatabase instance;

    public abstract HistoryDao historyDao();

    public abstract UsersDao usersDao();

    public static synchronized AwesomeDatabase getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AwesomeDatabase.class, "awesome_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
