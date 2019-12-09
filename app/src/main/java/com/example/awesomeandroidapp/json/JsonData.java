package com.example.awesomeandroidapp.json;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.awesomeandroidapp.model.Image;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonData {

    private List<Image> images = new ArrayList<>();

    public JsonData(){
        JSONArray photoList = JsonTask.getJsonArray();
        if(photoList != null){
            for(int i = 0; i < photoList.length(); i++ ){
                try {
                    JSONObject jsonObject = photoList.getJSONObject(i);
                    Image current = new Image(jsonObject.getInt("id"),
                            jsonObject.getString("title"),
                            jsonObject.getString("albumId"),
                            jsonObject.getString("url"),
                            jsonObject.getString("thumbnailUrl"));
                    images.add(current);
                } catch (JSONException e) {
                    Log.d(JsonData.class.getSimpleName(), "Json error while parsing!");
                }
            }
        }
    }

    public LiveData<List<Image>> getImages() {
        MutableLiveData<List<Image>> liveData = new MutableLiveData<>();
        liveData.setValue(images);
        return liveData;
    }
}
