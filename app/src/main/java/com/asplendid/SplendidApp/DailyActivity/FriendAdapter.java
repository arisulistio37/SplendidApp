package com.asplendid.SplendidApp.DailyActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.asplendid.SplendidApp.R;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ListViewHolder> {

    private ArrayList<Frend> frendList;

    public FriendAdapter(ArrayList<Frend> list) { this.frendList = list; }

    @NonNull
    @Override
    public FriendAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_friend, parent, false);
        return new FriendAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendAdapter.ListViewHolder holder, int position) {
        Frend friends = frendList.get(position);
        Glide.with(holder.itemView.getContext()).load(friends.getFoto()).apply(new RequestOptions().override(75, 75))
                .into(holder.imgfoto);
        holder.nama.setText(friends.getNama());
    }

    @Override
    public int getItemCount() { return frendList.size(); }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgfoto;
        TextView nama;

        ListViewHolder(View itemview) {
            super(itemview);
            imgfoto = itemview.findViewById(R.id.friend_img);
            nama = itemview.findViewById(R.id.friend_name);
        }
    }
}
