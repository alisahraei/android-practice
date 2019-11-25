package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class connect_duz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_duz);
    }

    public void dropIn(View view){
        ImageView img = (ImageView) view;
        img.setImageResource(R.drawable.o);
    }
}
