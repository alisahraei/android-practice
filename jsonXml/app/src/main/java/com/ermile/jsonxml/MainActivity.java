package com.ermile.jsonxml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     Button btn_xml , btn_json;
     ListView listview;
     private List<Flower> flowers;
     private ArrayAdapter<Flower> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_xml = findViewById(R.id.btn_xml);
        btn_json = findViewById(R.id.btn_json);
        listview = findViewById(R.id.listview);


        btn_xml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowers = new FlowerXmlPullParser(MainActivity.this).parseXml();
                Toast.makeText(MainActivity.this, "Returned" + flowers.size() + "items", Toast.LENGTH_SHORT).show();
                refreshDisplay();
            }
        });
    }
    public void refreshDisplay(){
        if (flowers == null){
            flowers = new ArrayList<>();

        }
        adapter = new ArrayAdapter<Flower>(this, android.R.layout.simple_list_item_1, flowers);
        listview.setAdapter(adapter);
    }
}
