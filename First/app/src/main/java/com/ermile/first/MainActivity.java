package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView ali;
    TextView date;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ali = findViewById(R.id.textView);
        //ali.setText("alisahraei");
        date = findViewById(R.id.date);
        date.setText(new Date().toString());
        button = findViewById(R.id.button);
        date.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomTextColor();
            }
        });
//        button.setOnClickListener(this);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (v.getId() == R.id.button){
//                    randomTextColor();
//                }
//            }
//        });
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                date.setVisibility(View.VISIBLE);
                return true;
//                when return is true means onLongClick with onClick but return is false means onLongClick without onClick
            }
        });
    }

    private void randomTextColor() {
        Random random = new Random();
        date.setTextColor(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
    }

    @Override
    public void onClick(View v) {
        randomTextColor();
    }
}
