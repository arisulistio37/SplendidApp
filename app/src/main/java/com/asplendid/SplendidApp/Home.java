package com.asplendid.SplendidApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import com.asplendid.SplendidApp.DailyActivity.Daily;
import com.asplendid.SplendidApp.DailyActivity.DailyAdapter;
import com.asplendid.SplendidApp.DailyActivity.DataDaily;
import com.asplendid.SplendidApp.DailyActivity.FriendAdapter;
import com.asplendid.SplendidApp.DailyActivity.Frend;
import com.asplendid.SplendidApp.DailyActivity.DataFrend;
import com.asplendid.SplendidApp.Gallery.GalleryAdapter;
import com.asplendid.SplendidApp.Gallery.GalleryItem;
import com.asplendid.SplendidApp.Music.MusicAdapter;
import com.asplendid.SplendidApp.Music.MusicData;
import com.asplendid.SplendidApp.Music.MusicItem;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private RecyclerView rvFrd, rvDa, rvGal, rvMV;
    private ArrayList<Frend> frd = new ArrayList<>();
    private ArrayList<Daily> dai = new ArrayList<>();
    private ArrayList<MusicItem> mv = new ArrayList<>();

    LinearLayout home, dailyactivity, mvplaylist, profile;
    ConstraintLayout gallery;
    MaterialToolbar title;
    VideoView videoView;
    ImageView facebook,instagram,navigation, about;
    Dialog dialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        MaterialToolbar toolbar = findViewById(R.id.topappbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawerlayout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        about = findViewById(R.id.about);
        dialogue = new Dialog(this);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });


                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        drawerLayout.openDrawer(GravityCompat.START);
                    }
                });

        navigationView.getMenu().getItem(0).setChecked(true);

        home = findViewById(R.id.home_layout);
        dailyactivity = findViewById(R.id.dailyactivity_layout);
        gallery = findViewById(R.id.gallery_layout);
        mvplaylist = findViewById(R.id.mvplaylist_layout);
        profile = findViewById(R.id.profile_layout);
        title = findViewById(R.id.topappbar);

        facebook = findViewById(R.id.fb);
        instagram = findViewById(R.id.ig);
        navigation = findViewById(R.id.maps);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotolink("https://www.facebook.com/lingga.alhamdi");
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotolink("https://www.instagram.com/lingga_dvx/");
            }
        });

        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotolink("https://maps.app.goo.gl/c2g2VSxa68us7hUU6");
            }
        });

                navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        switch (id) {
                            case R.id.nav_home:
                                home.setVisibility(View.VISIBLE);
                                dailyactivity.setVisibility(View.GONE);
                                gallery.setVisibility(View.GONE);
                                mvplaylist.setVisibility(View.GONE);
                                profile.setVisibility(View.GONE);
                                title.setTitle("Home");
                                break;

                            case R.id.nav_dailyactivity:
                                home.setVisibility(View.GONE);
                                dailyactivity.setVisibility(View.VISIBLE);
                                gallery.setVisibility(View.GONE);
                                mvplaylist.setVisibility(View.GONE);
                                profile.setVisibility(View.GONE);
                                title.setTitle("Daily Activity");
                                break;

                            case R.id.nav_gallery:
                                home.setVisibility(View.GONE);
                                dailyactivity.setVisibility(View.GONE);
                                gallery.setVisibility(View.VISIBLE);
                                mvplaylist.setVisibility(View.GONE);
                                profile.setVisibility(View.GONE);
                                title.setTitle("Gallery");
                                break;

                            case R.id.nav_mvplaylist:
                                home.setVisibility(View.GONE);
                                dailyactivity.setVisibility(View.GONE);
                                gallery.setVisibility(View.GONE);
                                mvplaylist.setVisibility(View.VISIBLE);
                                profile.setVisibility(View.GONE);
                                title.setTitle("Music and Video Favorite");
                                break;

                            case R.id.nav_profile:
                                home.setVisibility(View.GONE);
                                dailyactivity.setVisibility(View.GONE);
                                gallery.setVisibility(View.GONE);
                                mvplaylist.setVisibility(View.GONE);
                                profile.setVisibility(View.VISIBLE);
                                title.setTitle("Profile");
                                break;

                            default:
                                return true;
                        }
                        return true;
                    }
                });

        rvFrd = findViewById(R.id.rvFrd);
        rvFrd.setHasFixedSize(true);
        frd.addAll(DataFrend.getListData());
        showFriendList();

        rvDa = findViewById(R.id.rvDa);
        rvDa.setHasFixedSize(true);
        dai.addAll(DataDaily.getListData());
        showDailyList();

        rvMV = findViewById(R.id.rvMV);
        rvMV.setHasFixedSize(true);
        mv.addAll(MusicData.getListData());
        showMusicList();

        rvGal = findViewById(R.id.rvGal);
        rvGal.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        //gallery_data_list
        List<GalleryItem> gallery_items = new ArrayList<>();
        gallery_items.add(new GalleryItem(R.drawable.i1));
        gallery_items.add(new GalleryItem(R.drawable.i2));


        rvGal.setAdapter(new GalleryAdapter(gallery_items));

        videoView = findViewById(R.id.video);
        MediaController mediaController = new MediaController(this);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoz));
        videoView.start();
    }

    private void openDialog() {
        dialogue.setContentView(R.layout.about);
        dialogue.getWindow();
        dialogue.show();
    }

    private void gotolink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void showFriendList() {
        rvFrd.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        FriendAdapter fladapter = new FriendAdapter(frd);
        rvFrd.setAdapter(fladapter);
    }

    private void showDailyList() {
        rvDa.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        DailyAdapter daiadapter = new DailyAdapter(dai);
        rvDa.setAdapter(daiadapter);
    }

    private void showMusicList() {
        rvMV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        MusicAdapter mvadapter = new MusicAdapter(mv);
        rvMV.setAdapter(mvadapter);
    }

}