package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class AudioActivity extends AppCompatActivity implements View.OnClickListener {
    Button play, pause;
    MediaPlayer mplayer;
    SeekBar volumeseek;
    SeekBar changeseek;
    TextView textseek;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
//        MediaPlayer mplayer = MediaPlayer.create(this, R.raw.babel);
//        mplayer.start();


        //button
        pause = findViewById(R.id.pause);
        play = findViewById(R.id.play);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);


        mplayer= MediaPlayer.create(this, R.raw.babel);
        volumeseek = findViewById(R.id.volume);
        textseek = findViewById(R.id.textseek);
        changeseek = findViewById(R.id.change);
        //audiomanger
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        final int maxVolume = audioManager.getStreamMaxVolume(audioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamVolume(audioManager.STREAM_MUSIC);
        //volume
        volumeseek.setMax(maxVolume);
        volumeseek.setProgress(curVolume);


        volumeseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(audioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //position
        changeseek.setMax(mplayer.getDuration());
        changeseek.setProgress(0);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                changeseek.setProgress(mplayer.getCurrentPosition());
            }
        },0 , 100);
        changeseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (mplayer != null && fromUser){
                    mplayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                mplayer.start();
                break;
            case R.id.pause:
                mplayer.pause();
                break;
            default:break;
        }
    }
}
