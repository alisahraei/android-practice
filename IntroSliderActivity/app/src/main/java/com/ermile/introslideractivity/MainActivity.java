package com.ermile.introslideractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SliderPrefManager prefman = new SliderPrefManager(this);
//        if (prefman.startSlider()){
//            Intent intent = new Intent(this, IntroSliderActivity.class);
//            startActivity(intent);
//            finish();
//        }
    }

    public void playagain(View view) {
        new SliderPrefManager(this).setStartSlider(true);
        Intent intent = new Intent(this, IntroSliderActivity.class);
        startActivity(intent);
        finish();
    }
}
