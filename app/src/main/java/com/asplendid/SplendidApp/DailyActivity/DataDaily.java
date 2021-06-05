package com.asplendid.SplendidApp.DailyActivity;

import java.util.ArrayList;

public class DataDaily {
    private static String[] data_kegiatan = {
            "Tidur",
            "Makan",
            "Nonton",
            "Sholat",
            "Main",
    };

    public static ArrayList<Daily> getListData() {
        ArrayList<Daily> list = new ArrayList<>();
        for (int position = 0; position < data_kegiatan.length; position++) {
            Daily daily = new Daily();
            daily.setKegiatan(data_kegiatan[position]);
            list.add(daily);
        }
        return list;
    }
}
