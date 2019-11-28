package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import static com.ermile.first.play_ground.PLAYER_X;

public class dialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);
    }

    public void showProgressDialog(View view) {
        final ProgressDialog pdialog = new ProgressDialog(this);
        pdialog.setCancelable(false);
        pdialog.setTitle("Process dialog example");
        pdialog.setMessage(" please wait...");
        pdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        pdialog.setIndeterminate(true);
        pdialog.show();
//        pdialog.setProgress(0);
        long duration = 5000L;


        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (pdialog == null)
                    return;
                if (pdialog.getProgress() < pdialog.getMax()) {
                    pdialog.incrementProgressBy(1);
                } else {
                    pdialog.dismiss();
                }
            }
        }, 0, 200);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (pdialog.getSecondaryProgress() < pdialog.getMax()){
                    pdialog.incrementSecondaryProgressBy(1);
                }
            }
        }, 0, 140);


////        process simulatin
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                pdialog.dismiss();
//            }
//        }, 3000L);
    }

    public void showAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);



//        Type 1
//        builder.setTitle("ALertDialog")
//                .setMessage("Do you want to delete this test")
//                .setCancelable(false)
//                .setIcon(android.R.drawable.star_on)
//                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(dialActivity.this, "file deleted", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setNegativeButton("no" ,null)
//                .setNeutralButton("cancel", null);



//        Type 2
//        builder.setTitle("question?")
//                .setCancelable(false)
//                .setSingleChoiceItems(new String[]{"a", "b" ,"c" , "d"}, 1 , new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int i) {
//                        Toast.makeText(dialActivity.this, "i =" + i, Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setPositiveButton("ok" , null);
//        builder.show();


//        Type 3
        builder.setTitle("")
                .setCancelable(true)
                .setMultiChoiceItems(new String[]{"item0", "item1", "item2", "item3", "item4", "item5"},
                        new boolean[]{false, true, false, true, true, false},
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(dialActivity.this, "item" + which + ":" + isChecked, Toast.LENGTH_SHORT).show();
                            }
                        })
        .setPositiveButton("ok", null);
        builder.show();
    }

    public void showDialog(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setTitle("Dialog");
        dialog.setContentView(R.layout.activity_play_ground);
        dialog.show();
    }
    public void dropIn(View view){
        ImageView img = (ImageView) view;
        img.setImageResource(R.drawable.x);
        img.setTranslationY(-2000f);
        img.animate().translationY(0f).setDuration(1000L);
    }


}
