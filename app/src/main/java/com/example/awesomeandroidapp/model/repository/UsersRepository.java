package com.example.awesomeandroidapp.model.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.awesomeandroidapp.model.Users;
import com.example.awesomeandroidapp.model.dao.UsersDao;
import com.example.awesomeandroidapp.model.database.AwesomeDatabase;

public class UsersRepository {

    private UsersDao usersDao;
    private String lastUser;

    public UsersRepository(Application application){
        AwesomeDatabase database = AwesomeDatabase.getInstance(application);
        usersDao = database.usersDao();
        lastUser = usersDao.getLastUsername();
    }

    public void insert(Users users){
        new InsertUserAsyncTask(usersDao).execute(users);
    }

    public String getLastUser(){
        return lastUser;
    }

    private class InsertUserAsyncTask extends AsyncTask<Users, Void, Void> {
        private UsersDao usersDao;

        public InsertUserAsyncTask(UsersDao usersDao) {
            this.usersDao = usersDao;
        }

        @Override
        protected Void doInBackground(Users... users) {
            usersDao.insert(users[0]);
            return null;
        }
    }

}
