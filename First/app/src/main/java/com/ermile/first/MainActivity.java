package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        button = findViewById(R.id.button);
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





//        button.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                date.setVisibility(View.VISIBLE);
//                return true;
////                when return is false means onLongClick with onClick but return is ture means onLongClick without onClick
//            }
//        });



        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                return true;
            }
        });
        Toast.makeText(this, "MainActivity: onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "MainActivity: onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(this, "MainActivity: onRestart", Toast.LENGTH_SHORT).show();
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Toast.makeText(this, "MainActivity: onResume", Toast.LENGTH_SHORT).show();
        date.setText(new Date().toString());
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "MainActivity: onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "MainActivity: onStop", Toast.LENGTH_SHORT).show();
        super.onStop();
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
