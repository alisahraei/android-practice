package com.ermile.first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView iv_pingpong;
    ImageView iv_golf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        iv_pingpong = findViewById(R.id.iv_pingpong);
        iv_pingpong.setOnClickListener(this);
        iv_golf = findViewById(R.id.iv_golf);
        iv_golf.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == iv_pingpong.getId()){
            fade();
        }else if (v.getId() == iv_golf.getId()){
            fade();
        }
    }

    private void fade() {
            iv_pingpong.animate().alpha(1f - iv_pingpong.getAlpha()).setDuration(2000);
            iv_golf.animate().alpha(1f - iv_golf.getAlpha()).setDuration(2000);

//        if (iv_pingpong.getAlpha() == 0f) {
//            iv_pingpong.animate().alpha(1f).setDuration(2000);
//            iv_golf.animate().alpha(0f).setDuration(2000);
//        }else if (iv_golf.getAlpha() == 0f){
//            iv_pingpong.animate().alpha(0f).setDuration(2000);
//            iv_golf.animate().alpha(1f).setDuration(2000);
//        }
    }
}
