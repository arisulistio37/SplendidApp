package com.asplendid.SplendidApp.Music;

import java.util.ArrayList;

public class MusicData {
    private static String[] data_musik = {
            "Otomodachi Film",
            "Renai Circulation",
            "Fuwa Fuwa Time",
            "Glistening",
            "Kizuna Music"
    };

    public static ArrayList<MusicItem> getListData() {
        ArrayList<MusicItem> list = new ArrayList<>();
        for (int position = 0; position <data_musik.length; position++) {
            MusicItem mi = new MusicItem();
            mi.setMusicList(data_musik[position]);
            list.add(mi);
        }
        return list;
    }
}
