package com.example.awesomeandroidapp.ui.gallery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.awesomeandroidapp.R;
import com.example.awesomeandroidapp.model.Image;
import com.example.awesomeandroidapp.ui.gallery.adapter.util.DiffUtilCallback;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter {

    private static final int HEADER_ITEM = 0;
    private static final int LIST_ITEM = 1;
    private List<Image> images = new ArrayList<>();
    private View itemView;
    private final OnItemClickListener listener;
    private final OnItemLongClickListener longClickListener;
    private Context mContext;

    public ImageAdapter(OnItemClickListener listener, OnItemLongClickListener longClickListener, Context mContext) {
        this.mContext = mContext;
        this.longClickListener = longClickListener;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row;
        if (viewType == HEADER_ITEM) {
            row = inflater.inflate(R.layout.header, parent, false);
            return new HeaderHolder(row);
        } else {
            itemView = inflater.inflate(R.layout.image_card, parent, false);
            return new ImageHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof ImageHolder){
            ImageHolder imageHolder = (ImageHolder) holder;
            Image currentImage = images.get(position);
            imageHolder.title.setText(currentImage.getTitle());
            imageHolder.description.setText(currentImage.getDescription());
            ImageLoader.getInstance().displayImage(currentImage.getThumbnailUrl(), imageHolder.thumbnail);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(images.get(position));
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    longClickListener.onItemClick(images.get(position));
                    return true;
                }
            });
        }
        else if (holder instanceof HeaderHolder) {
            HeaderHolder headerHolder = (HeaderHolder) holder;
            Header header = (Header) images.get(position);
            //set data
            headerHolder.texViewHeaderText.setText(header.getHeaderText());
            headerHolder.textViewCategory.setText(header.getCategory());
            Glide.with(mContext).load(header.getImageUrl()).into(headerHolder.imageViewHeader);

        }
    }

    @Override
    public int getItemViewType(int position) {
        Image recyclerViewItem = images.get(position);
        if (recyclerViewItem instanceof Header)
            return HEADER_ITEM;
        else
            return LIST_ITEM;

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

    public interface OnItemLongClickListener {
        void onItemClick(Image image);
    }

    private class HeaderHolder extends RecyclerView.ViewHolder {
        TextView texViewHeaderText, textViewCategory;
        ImageView imageViewHeader;

        HeaderHolder(View itemView) {
            super(itemView);
            texViewHeaderText = itemView.findViewById(R.id.texViewHeaderText);
            textViewCategory = itemView.findViewById(R.id.textViewCategory);
            imageViewHeader = itemView.findViewById(R.id.imageViewHeader);
        }
    }

}
