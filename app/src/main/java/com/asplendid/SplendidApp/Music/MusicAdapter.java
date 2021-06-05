package com.asplendid.SplendidApp.Music;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asplendid.SplendidApp.R;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ListViewHolder> {
    private ArrayList<MusicItem> musicList;

    public MusicAdapter(ArrayList<MusicItem> list) {
        this.musicList = list;
    }

    @NonNull
    @Override
    public MusicAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_music, parent, false);
        return new MusicAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.ListViewHolder holder, int position) {
        MusicItem music_item = musicList.get(position);
        holder.musiclist.setText(music_item.getMusicList());

    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView musiclist;

        ListViewHolder(View itemView) {
            super(itemView);
            musiclist = itemView.findViewById(R.id.musiclist);
        }
    }
}
