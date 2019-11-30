package com.ermile.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class simplelistAcrivity extends AppCompatActivity {
    List<String> items;
    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplelist_acrivity);
        listView = findViewById(R.id.listveiw);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        items = new ArrayList<>();
        prepareData();
        refreshDispley();
    }


    private void prepareData(){
        items = new ArrayList<>();
        items.add("Tehran");
        items.add("Mashhad");
        items.add("Isfahan");
        items.add("Shiraz");
        items.add("Kerman");
        items.add("Ferdows");
        items.add("Tabriz");
        items.add("Ahwaz");
        items.add("Zahedan");
        items.add("Kermanshah");
        items.add("Ardebil");
        items.add("Qom");
        items.add("Kordestan");
        items.add("Gilan");
        items.add("Orumie");
        items.add("Karaj");
        items.add("Bojnurd");
    }
    private void refreshDispley() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(simplelistAcrivity.this, items.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("addItem").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                items.add("new item");
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        menu.add("removeitem").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (items.isEmpty())
                    return false;
                items.remove(items.size()-1);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
