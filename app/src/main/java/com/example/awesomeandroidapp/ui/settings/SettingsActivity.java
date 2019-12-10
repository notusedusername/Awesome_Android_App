package com.example.awesomeandroidapp.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.awesomeandroidapp.MainActivity;
import com.example.awesomeandroidapp.R;
import com.example.awesomeandroidapp.model.Users;

public class SettingsActivity extends AppCompatActivity {

    private SettingsViewModel settingsViewModel;
    private EditText nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        nickname = findViewById(R.id.editText);
        settingsViewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);
        nickname.setText(settingsViewModel.getLastUsername().getValue());

    }

    public void onSubmit(View v){
        settingsViewModel.insertUsername(new Users(nickname.getText().toString()));
        finish();

    }
}
