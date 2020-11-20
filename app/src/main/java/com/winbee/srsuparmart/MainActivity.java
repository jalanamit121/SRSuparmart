package com.winbee.srsuparmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    PrefManager prefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    prefManager = new PrefManager(MainActivity.this);
                    if (prefManager.isFirstTimeLaunch()) {
                        startActivity(new Intent(getApplicationContext(), WebsiteActivity.class));
                        finish();
                    } else {
                        finish();

                    }


                }
            }
        };
        timer.start();
    }

}