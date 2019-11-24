package com.ermile.first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity {
    ImageView anime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        anime = findViewById(R.id.iv_anime);
//        anime.setTranslationY(2000);
//        anime.animate().translationYBy(-2000).setDuration(2000);
          anime.setTranslationY(0f);
          anime.setTranslationX(0f);
          anime.setScaleX(0.2f);
          anime.setScaleY(0.2f);
          animation();

//        anime.setAlpha(0f);
//        animate(anime);
    }

    private void animation() {
        anime.animate()
                .rotationBy(5 * 360f)
                .rotationY(180f)
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(3000);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void animate(View v){
//        anime.animate().alpha(1f).setDuration(2000);
//        anime.animate().translationYBy(50).setDuration(1000);


//        anime.animate().translationY(2000).setDuration(2000);
//        anime.animate().translationX(1000).setDuration(2000);
//        anime.animate().rotationXBy(180f).rotationBy(180f).setDuration(2000);
//          anime.animate().scaleXBy(0.5f).setDuration(2000);
    }
}
