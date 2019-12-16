package com.example.awesomeandroidapp.ui.fullscreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.awesomeandroidapp.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class DetailsFragment extends Fragment {

    private String url;
    private String title;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_detail, container, false);
        title = DetailsFragmentArgs.fromBundle(getArguments()).getTitle();
        url = DetailsFragmentArgs.fromBundle(getArguments()).getUrl();
        ImageLoader.getInstance().displayImage(url, (ImageView) root.findViewById(R.id.fullscreen));
        TextView titleV =  root.findViewById(R.id.details);
        titleV.setText(title);
        return root;
    }
}
