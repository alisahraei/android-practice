package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class play_ground extends AppCompatActivity {

    public static final int PLAYER_X = 0;
    public static final int PLAYER_O = 1;
    public static final int NOT_PLAYED = 2;
    private static final int NO_WINNER = 3;
    int[] status = {NOT_PLAYED,NOT_PLAYED,NOT_PLAYED
                ,NOT_PLAYED,NOT_PLAYED,NOT_PLAYED
                ,NOT_PLAYED,NOT_PLAYED,NOT_PLAYED};
    int activePlayer = PLAYER_X;
    int[][] winner = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8} , {0, 3, 6} , {1, 4, 7} , {2, 5, 8} , {0, 4, 8} , {2, 4, 6}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);
    }
    public void dropIn(View view){
        int tag = Integer.parseInt((String) view.getTag());
        if (status[tag] != NOT_PLAYED){
            return;
        }
        ImageView img = (ImageView) view;
        img.setTranslationY(-2000f);
        if (activePlayer == PLAYER_X){
            img.setImageResource(R.drawable.x);
            status[tag] = PLAYER_X;
            activePlayer = PLAYER_O;
        }else if (activePlayer == PLAYER_O){
            img.setImageResource(R.drawable.o);
            status[tag] = PLAYER_O;
            activePlayer = PLAYER_X;
        }
        img.animate().translationY(0f).rotation(360f).setDuration(500);
        int winner = checkwinner();
        if (checkwinner()!= NO_WINNER){
           Toast.makeText(this, "Winner:" + ((winner == PLAYER_X) ? "X" : "O") , Toast.LENGTH_SHORT).show();
        }
    }
    //no winner = -1
    //X = PLAYER_X
    //O = PLAYER_O
    public int checkwinner(){
        for (int[] position : winner){
            if (status[position[0]] == status[position[1]] &&
                status[position[1]] == status[position[2]]&&
                status[position[0]] != NOT_PLAYED){
                return status[position[0]];
            }
        }
        return 0;
    }
}
