package com.asplendid.SplendidApp.DailyActivity;

import com.asplendid.SplendidApp.R;

import java.util.ArrayList;

public class DataFrend {
    private static String[] data_nama = {
            "Dandi Wahyu G",
            "Wahyu Fajar G",
            "Lazuardi Ali",
            "M Riefqi Wijaya",
            "Fauzi Nugraha"
    };


    private static int[] data_img = {
            R.drawable.f1,
            R.drawable.f2,
            R.drawable.f3,
            R.drawable.f4,
            R.drawable.f5
    };

    public static ArrayList<Frend> getListData() {
        ArrayList<Frend> list = new ArrayList<>();
        for (int position = 0; position<data_nama.length; position++) {
            Frend friends = new Frend();
            friends.setNama(data_nama[position]);
            friends.setFoto(data_img[position]);
            list.add(friends);
        }
        return list;
    }
}
