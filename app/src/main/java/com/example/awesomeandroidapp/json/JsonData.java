package com.example.awesomeandroidapp.json;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.awesomeandroidapp.model.Image;
import com.example.awesomeandroidapp.ui.gallery.adapter.Header;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonData {

    private List<Image> images = new ArrayList<>();

    public JsonData(){
        addHeader();
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

    private void addHeader() {
        images.add(new Header("Awesome Header", "Noice", "https://worldofwonder.net/wp-content/uploads/2019/11/awesome-Rect-1024x781-1000x763.jpg"));
    }

    public LiveData<List<Image>> getImages() {
        MutableLiveData<List<Image>> liveData = new MutableLiveData<>();
        liveData.setValue(images);
        return liveData;
    }
}
