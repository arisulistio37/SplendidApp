package com.asplendid.SplendidApp.Gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asplendid.SplendidApp.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    private List<GalleryItem> gallery_items;

    public GalleryAdapter(List<GalleryItem> gallery_items) {this.gallery_items = gallery_items; }

    @NonNull
    @Override
    public GalleryAdapter.GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GalleryViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.GalleryViewHolder holder, int position) {
        holder.setPostImage(gallery_items.get(position));
    }

    @Override
    public int getItemCount() { return gallery_items.size(); }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView imageView;

        public GalleryViewHolder(@NonNull View ItemView) {
            super(ItemView);
            imageView = ItemView.findViewById(R.id.gallery_item_layout);
        }

        public void setPostImage(GalleryItem gallery_item) {
            imageView.setImageResource(gallery_item.getImage());
        }
    }
}
