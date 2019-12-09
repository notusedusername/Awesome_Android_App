package com.example.awesomeandroidapp.json;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonTask extends AsyncTask<String, String, String> {

    private static JSONArray jsonArray;
    private ProgressDialog pd;
    private Context context;

    public JsonTask(Context context) {
        this.context = context;
    }

    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(context);
        pd.setMessage("Please wait");
        pd.setCancelable(false);
        pd.show();
    }

    protected String doInBackground(String... params) {
        return doCall(params[0]);
    }

    private String doCall(String param) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(param);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line+"\n");
            }

            return buffer.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "[\"empty\":null]";
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (pd.isShowing()){
            pd.dismiss();
        }
        parseJsonArray(result);
    }

    private void parseJsonArray(String stringJson){
        try {
            jsonArray = new JSONArray(stringJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}