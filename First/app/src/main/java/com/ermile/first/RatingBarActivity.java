package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingBarActivity extends AppCompatActivity {
    RatingBar ratingBar;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        ratingBar = findViewById(R.id.ratingBar);
        btn_submit = findViewById(R.id.button);

        ratingBar.setNumStars(3);
        ratingBar.setRating(2.5f);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(RatingBarActivity.this, "rating" + ratingBar.getRating(), Toast.LENGTH_SHORT).show();
                ratingBar.setRating(2.0f);
            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser){
                    Toast.makeText(RatingBarActivity.this, "rating" + ratingBar.getRating(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
