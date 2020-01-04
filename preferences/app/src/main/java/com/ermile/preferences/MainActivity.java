package com.ermile.preferences;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText input_firstname, input_lastname, input_age;
    Button btn_save, btn_load;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

//        pref = getPreferences(MODE_PRIVATE);
        pref = getSharedPreferences("myprefs" , MODE_PRIVATE);


        initView();
    }
//  pref_screen
    private void loadAppPrefValues() {
        SharedPreferences appPref = PreferenceManager.getDefaultSharedPreferences(this);
        String username = appPref.getString("username" , "");
        String userbio = appPref.getString("userbio" , "");
        boolean viewimages = appPref.getBoolean("viewimages" , false);
        boolean notifications = appPref.getBoolean("notifications" , true);
        new AlertDialog.Builder(this)
                        .setMessage("username : " + username + "\n" + "userbio : " + userbio + "\n" + "viewimages : " + viewimages + "\n" +
                        "notification : " + notifications)
                        .show();


    }

    private void initView() {
        btn_save = findViewById(R.id.btn_save);
        btn_load = findViewById(R.id.btn_load);
        input_firstname = findViewById(R.id.input_firstname);
        input_lastname = findViewById(R.id.input_lastname);
        input_age = findViewById(R.id.input_age);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = input_firstname.getText().toString().trim();
                String lastname = input_lastname.getText().toString().trim();
                String agestr = input_age.getText().toString().trim();
                if (! firstname.isEmpty() && ! lastname.isEmpty() && ! agestr.isEmpty()){
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("firstname" , firstname);
                    editor.putString("lastname", lastname);
                    editor.putInt("age", Integer.valueOf(agestr));
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = pref.getString("firstname" , "not-found");
                String lastname = pref.getString("lastname", "not-found");
                int age = pref.getInt("age" , -1);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("pref. values")
                        .setMessage("firstname : " + firstname + "\n" + "lastname : " + lastname + "\n" + "age : " + (age == -1 ? "not-found" : age))
                        .show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("SecondActivity").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(MainActivity.this , SecondActivity.class);
                startActivity(intent);
                return false;
            }
        });
        menu.add("Setting").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(MainActivity.this , SettingActivity.class);
                startActivity(intent);
                return false;
            }
        });
        menu.add("load app pref...").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                loadAppPrefValues();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
