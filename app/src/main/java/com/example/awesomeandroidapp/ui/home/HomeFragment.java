package com.example.awesomeandroidapp.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.awesomeandroidapp.R;
import com.example.awesomeandroidapp.model.History;
import com.example.awesomeandroidapp.model.Image;
import com.example.awesomeandroidapp.ui.gallery.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        final TextView nick = root.findViewById(R.id.user_in_header);
        homeViewModel.getLastUsername().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                //nick.setText(s);
            }
        });

        RecyclerView recyclerView = root.findViewById(R.id.recycler_home);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        final ImageAdapter adapter = new ImageAdapter(new ImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Image image) {
                //useful functionality
            }
        }, getContext());
        recyclerView.setAdapter(adapter);

        homeViewModel.getHistory().observe(this, new Observer<List<History>>() {
            @Override
            public void onChanged(List<History> histories) {
                //do the harlem shake
                Log.d(HomeFragment.class.getSimpleName(), "Refreshed history");
                List<Image> images = new ArrayList<>();
                for(History history : histories ){
                   images.add(new Image(history.getPhotoId(),
                           history.getTitle(),
                           history.getDescription(),
                           history.getUrl(),
                           history.getThumbnailUrl()));
                }
                adapter.setImages(images);

            }
        });

        return root;
    }
}