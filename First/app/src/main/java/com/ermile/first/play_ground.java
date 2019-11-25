package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class play_ground extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);
    }
    public void dropIn(View view){
        ImageView img = (ImageView) view;
        img.setTranslationY(-2000f);

        img.setImageResource(R.drawable.o);
        img.animate().translationY(0f).rotation(360f).setDuration(500);
    }
}
