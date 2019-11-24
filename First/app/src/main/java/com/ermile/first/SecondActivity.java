package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    TextView TextView;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        TextView = findViewById(R.id.TextView);
        if (extras != null){
            String email = "";
            String phone = "";
            String name = "";
            if (extras.containsKey("name")){
                name = extras.getString("name");
            }
            if (extras.containsKey("phone")){
                phone= extras.getString("phone");
            }
            if (extras.containsKey("email")){
                email = extras.getString("email");
            }
            TextView.setText("Name:" + name + "\n");
            TextView.append("Phone:" + phone + "\n");
            TextView.append("Email:" + email + "\n");
        }
        Toast.makeText(this, "SecondActivity: onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem itemOk = menu.add("OK");
        itemOk.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        itemOk.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem itemOk) {
                Intent intent = new Intent();
                intent.putExtra("message" , "it's ok");
                setResult(RESULT_OK, intent);
                finish();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}




















//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(this, "SecondActivity: onStart", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onRestart() {
//        Toast.makeText(this, "SecondActivity: onRestart", Toast.LENGTH_SHORT).show();
//        super.onRestart();
//    }
//
//    @Override
//    protected void onResume() {
//        Toast.makeText(this, "SecondActivity: onResume", Toast.LENGTH_SHORT).show();
//        super.onResume();
//    }
//
//    @Override
//    protected void onDestroy() {
//        Toast.makeText(this, "SecondActivity: onDestroy", Toast.LENGTH_SHORT).show();
//        super.onDestroy();
//    }
//
//    @Override
//    protected void onStop() {
//        Toast.makeText(this, "SecondActivity: onStop", Toast.LENGTH_SHORT).show();
//        super.onStop();
//    }
