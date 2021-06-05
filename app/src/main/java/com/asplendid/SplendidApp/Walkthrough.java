package com.asplendid.SplendidApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.asplendid.SplendidApp.Fragments.Fragment0;
import com.asplendid.SplendidApp.Fragments.Fragment1;
import com.asplendid.SplendidApp.Fragments.Fragment2;

import java.util.ArrayList;
import java.util.List;

public class Walkthrough extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    TextView counter;
    Button btn1;
    int total = 3, count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        List<androidx.fragment.app.Fragment> list = new ArrayList<>();
        list.add(new Fragment0());
        list.add(new Fragment1());
        list.add(new Fragment2());

        counter = findViewById(R.id.counter);
        counter.setText(count+"/"+total);
        btn1 = findViewById(R.id.btn1);

        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePager(getSupportFragmentManager(),list);

        pager.setAdapter(pagerAdapter);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                count = 0;
                count = position + 1;
                counter.setText(count+"/"+total);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void skip(View view) {
        Intent intent1 = new Intent(Walkthrough.this, Home.class);
        startActivity(intent1);
        finish();
    }
}