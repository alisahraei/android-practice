package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        VideoView vv = findViewById(R.id.videoView);
        vv.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.zan);
        MediaController controller = new MediaController(this);
        vv.setMediaController(controller);
        controller.setAnchorView(vv);
        vv.start();
    }
}
