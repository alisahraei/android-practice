package com.ermile.first;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class play_ground extends AppCompatActivity {

    public static final int PLAYER_X = 0;
    public static final int PLAYER_O = 1;
    public static final int NOT_PLAYED = 2;
    private static final int NO_WINNER = -1;
    int[] status = {NOT_PLAYED,NOT_PLAYED,NOT_PLAYED
                ,NOT_PLAYED,NOT_PLAYED,NOT_PLAYED
                ,NOT_PLAYED,NOT_PLAYED,NOT_PLAYED};
    int activePlayer = PLAYER_X;
    int checkwinner = NO_WINNER;
    int[][] winner = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8} , {0, 3, 6} , {1, 4, 7} , {2, 5, 8} , {0, 4, 8} , {2, 4, 6}};
    RelativeLayout msg_layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);
        msg_layout = findViewById(R.id.msg_layout);
        msg_layout.setVisibility(View.GONE);
    }
    public void dropIn(View view){
        int tag = Integer.parseInt((String) view.getTag());
        if (checkwinner != NO_WINNER || status[tag] != NOT_PLAYED){
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
//        checkwinner = checkwinner();
//        if (checkwinner != NO_WINNER){
//            String winnername = (checkwinner == PLAYER_X) ? "x" : (checkwinner == PLAYER_O) ? "o" : "winner_no";
//           Toast.makeText(this, "Winner:" + winnername , Toast.LENGTH_SHORT).show();
//        }
        winnermsg();
    }

    private void winnermsg() {
        checkwinner = checkwinner();
        if(checkwinner != NO_WINNER || filled()) {
            String msg = "";
            int color = Color.GREEN;
            if(checkwinner == NO_WINNER){
                msg = "No Winner";
            } else if(checkwinner == PLAYER_X){
                msg = "x player won";
                color = Color.RED;
            } else if(checkwinner == PLAYER_O) {
                msg = "o player won";
                color = Color.YELLOW;
            }
            msg_layout.setBackgroundColor(color);

            TextView textView = findViewById(R.id.text_winner);
            textView.setText(msg);
            msg_layout.setVisibility(View.VISIBLE);
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
        return NO_WINNER;
        
    }

    public boolean filled(){
        for (int i = 0 ; i < status.length ; i++){
            if (status[i] == NOT_PLAYED){
                return false;
            }
        }
        return true;
    }
    public void reset(View view) {
        activePlayer = PLAYER_X;
        checkwinner = NO_WINNER;
        for (int i = 0; i < status.length; i++) {
            status[i] = NOT_PLAYED;
        }
        LinearLayout pglayout = findViewById(R.id.pg_layout);
        for (int i = 0; i < pglayout.getChildCount(); i++) {
            Toast.makeText(this, "pglayout childcount :" + pglayout.getChildCount(), Toast.LENGTH_SHORT).show();
            LinearLayout row = (pglayout.getChildAt(i) instanceof LinearLayout) ? (LinearLayout) pglayout.getChildAt(i) : null;
            if (row == null) return;
            for (int j = 0; j < row.getChildCount(); j++) {
                ImageView imageView = (row.getChildAt(j) instanceof ImageView) ? (ImageView) row.getChildAt(j) : null;
                if (imageView == null) return;
                imageView.setImageResource(0);
            }

        }
        msg_layout.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem resetItem = menu.add("reset");
        resetItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        resetItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                reset(null);
                return false;
            }
        });
        return true;
    }

}
