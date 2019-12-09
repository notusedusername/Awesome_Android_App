package com.example.awesomeandroidapp.ui.gallery;

import android.os.Bundle;
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

import com.example.awesomeandroidapp.MainActivity;
import com.example.awesomeandroidapp.R;
import com.example.awesomeandroidapp.json.JsonTask;
import com.example.awesomeandroidapp.model.Image;
import com.example.awesomeandroidapp.ui.gallery.adapter.ImageAdapter;

import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        new JsonTask(getContext()).execute("https://jsonplaceholder.typicode.com/photos");
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(false);

        final ImageAdapter adapter = new ImageAdapter();
        recyclerView.setAdapter(adapter);

        galleryViewModel.getImages().observe(this, new Observer<List<Image>>() {
            @Override
            public void onChanged(List<Image> images) {
                adapter.setImages(images);
            }
        });
        return root;
    }
}