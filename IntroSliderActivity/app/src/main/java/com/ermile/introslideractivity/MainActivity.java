package com.ermile.introslideractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SliderPrefManager prefman = new SliderPrefManager(this);
        if (prefman.startSlider()){
            Intent intent = new Intent(this, IntroSliderActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
