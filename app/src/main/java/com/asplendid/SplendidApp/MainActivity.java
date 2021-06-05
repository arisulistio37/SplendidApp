package com.asplendid.SplendidApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private static int splash_timeout = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent walktroughIntent = new Intent( MainActivity.this, Walkthrough.class);
                startActivity(walktroughIntent);
                finish();
            }
        }, splash_timeout);
    }
}