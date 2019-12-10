package com.example.awesomeandroidapp.model;

import android.text.Editable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class Users {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String username;

    public Users(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public Users(String text) {
        this.username = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
