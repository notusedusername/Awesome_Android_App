package com.example.awesomeandroidapp.ui.gallery;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.awesomeandroidapp.R;
import com.example.awesomeandroidapp.json.JsonTask;
import com.example.awesomeandroidapp.model.History;
import com.example.awesomeandroidapp.model.Image;
import com.example.awesomeandroidapp.ui.fullscreen.DetailsFragment;
import com.example.awesomeandroidapp.ui.fullscreen.DetailsFragmentArgs;
import com.example.awesomeandroidapp.ui.gallery.adapter.ImageAdapter;

import java.util.List;

import static com.example.awesomeandroidapp.ui.gallery.GalleryFragmentDirections.actionNavGalleryToNavDetails;

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
        recyclerView.setHasFixedSize(true);

        final ImageAdapter adapter = new ImageAdapter(new ImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Image image) {
                galleryViewModel.insert(new History(image));
                Toast.makeText(getContext(), R.string.like, Toast.LENGTH_SHORT).show();
            }

        }, new ImageAdapter.OnItemLongClickListener() {
            @Override
            public void onItemClick(Image image) {
                //nothing
                GalleryFragmentDirections.ActionNavGalleryToNavDetails action = GalleryFragmentDirections.actionNavGalleryToNavDetails();
                action.setTitle(image.getTitle());
                action.setUrl(image.getUrl());
                Navigation.findNavController(recyclerView).navigate(action);
            }
        }, getContext());
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