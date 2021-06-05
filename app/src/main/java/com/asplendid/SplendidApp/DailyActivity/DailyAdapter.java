package com.asplendid.SplendidApp.DailyActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asplendid.SplendidApp.R;

import java.util.ArrayList;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.ListViewHolder> {
    private ArrayList<Daily> dailyList;

    public DailyAdapter(ArrayList<Daily> list) {this.dailyList = list; }

    @NonNull
    @Override
    public DailyAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_item, parent, false);
        return new DailyAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyAdapter.ListViewHolder holder, int position) {
        Daily daily = dailyList.get(position);
        holder.kegiatan.setText(daily.getKegiatan());

    }

    @Override
    public int getItemCount() { return dailyList.size(); }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView kegiatan;

        ListViewHolder(View itemview) {
            super(itemview);
            kegiatan = itemview.findViewById(R.id.kegiatan);
        }
    }
}
