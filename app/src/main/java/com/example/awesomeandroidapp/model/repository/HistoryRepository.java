package com.example.awesomeandroidapp.model.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.awesomeandroidapp.model.History;
import com.example.awesomeandroidapp.model.dao.HistoryDao;
import com.example.awesomeandroidapp.model.database.AwesomeDatabase;

import java.util.List;

public class HistoryRepository {

    private HistoryDao historyDao;
    private LiveData<List<History>> history;

    public HistoryRepository(Application application){
        AwesomeDatabase database = AwesomeDatabase.getInstance(application);
        historyDao = database.historyDao();
        history = historyDao.fetch();
    }

    public void insert(History history){
        new InsertAsyncTask(historyDao).execute(history);
    }

    public LiveData<List<History>> fetch(){
        return history;
    }

    private static class InsertAsyncTask extends AsyncTask<History, Void, Void> {

        private HistoryDao historyDao;

        InsertAsyncTask(HistoryDao historyDao) {
            this.historyDao = historyDao;
        }

        @Override
        protected Void doInBackground(History... histories) {
            historyDao.insert(histories[0]);
            return null;
        }
    }
}
