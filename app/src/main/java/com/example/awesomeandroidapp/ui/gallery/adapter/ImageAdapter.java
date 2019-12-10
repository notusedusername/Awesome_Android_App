package com.example.awesomeandroidapp.ui.gallery.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.awesomeandroidapp.R;
import com.example.awesomeandroidapp.model.Image;
import com.example.awesomeandroidapp.ui.gallery.adapter.util.DiffUtilCallback;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {

    private List<Image> images = new ArrayList<>();
    private View itemView;
    private final OnItemClickListener listener;

    public ImageAdapter(OnItemClickListener listener) {
        this.images = images;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_card, parent, false);
        return new ImageHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, final int position) {
        Image currentImage = images.get(position);
        holder.title.setText(currentImage.getTitle());
        holder.description.setText(currentImage.getDescription());
        ImageLoader.getInstance().displayImage(currentImage.getThumbnailUrl(), holder.thumbnail);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(images.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void setImages(List<Image> images){
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtilCallback(this.images, images));
        diffResult.dispatchUpdatesTo(this);
        this.images.clear();
        this.images.addAll(images);
    }

    class ImageHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView thumbnail;
        private TextView description;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_view_title);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            description = itemView.findViewById(R.id.text_view_description);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Image image);
    }

}
